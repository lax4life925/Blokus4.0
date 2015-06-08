import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class BlokusPanel extends JPanel{
	BlokusBoard board;
	private int GameTurn=0;
	Location firstClick;
	Piece selectedP;
	Block selectedB;
	PassButton passB;
	JButton passButton;
	List<Player> playerList = new ArrayList<Player>();
	MyListener listen= new MyListener(this);
	ArtificialIntelligence ai = new ArtificialIntelligence();
	int numPlayers = 4;
	List<Player> cantPlayAnymore = new ArrayList<Player>();
	private boolean gameOver;
	// true if game has begun
	boolean playing = false;
	Color[] colors = {Color.blue,Color.yellow,Color.red,Color.green};
	//player blue's turn = 0
	//player yellow's turn = 1
	//player red's turn = 2
	//player green's turn = 3
	List<Piece> piecesAvailable = new ArrayList<Piece>();
	List<Piece> piecesUsed = new ArrayList<Piece>();
	private List<String> playerNames;
	public BlokusPanel(List<String> pn){
		super();
		this.setBackground(Color.WHITE);
		playerNames = pn;
		this.numPlayers = pn.size();
		this.addMouseListener(listen);
		addMouseMotionListener(listen);
		setPreferredSize(new Dimension(BlokusFrame.width,BlokusFrame.height));
		board = new BlokusBoard(this);
		passButton = new JButton();
		passButton.setSize(25, 25);
		passButton.setText("Pass");
		passButton.setFocusable(false);
		passButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				pass();
				
			}
			
		});
		this.add(passButton);
		//setUpTimer();
		
		setUpPlayers();
		//test();
		//testForPieceFlip();
		
	}
	private int getNumPlayers(){
		return numPlayers;
	}
	private void setUpPlayers() {
		// TODO Auto-generated method stub
		//numPlayers = getNumPlayersInitial();
		for(int i = 0; i < numPlayers;i++){
			playerList.add(new Player(colors[i], i, numPlayers));
			if(this.playerNames.get(i).contains("CPU"))
				playerList.get(i).setAsCPU();
		}
		repaint();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
			board.draw(g);
			//passB.draw(g);
			Player myTurn = whosturn();
			
			g.drawString(this.playerNames.get(GameTurn) + "'s Score: " + myTurn.getScore(), 25, 100);
			if(whosturn() != null){
				for(Piece p : whosturn().getAvailablePieces()){
					p.draw(g);
				}	
			}
	}
	

	
	public Player whosturn(){
		for(Player z: this.playerList){
			if(z.getTurn()==GameTurn){
				return z;
			}
		}
		return null;
	}


	public boolean selectPiece(int x, int y) {
		Player myTurn = whosturn();
		if(myTurn.playIsPossible()){
			if(myTurn!=null && myTurn.getAvailablePieces().size() > 0){
				for(Piece z: myTurn.getAvailablePieces()){
					for(Block v: z.blockList){
						if(v.contains(x,y)){
							firstClick= new Location(x,y);
							selectedP=z;
							return true;
						}
					}	
				}
			}
		}
		else 
			nextTurn();
		return false;
	}

	public boolean dropPiece(int x, int y){
		Location secondClick = new Location (x,y);
		Location secondClkBrd = secondClick.convertToGrid();
		Player myTurn = whosturn();
		if(board.onGrid(secondClkBrd)){
			if(board.validPlay(selectedP)){
				this.piecesUsed.add(selectedP);
				for(Block block : selectedP.getBlockList()){
					board.add(block);
				}
				if(selectedP.blockList.size()==1 && myTurn.getAvailablePieces().size()==1){
					myTurn.playedSingleLast();
				}
				myTurn.getAvailablePieces().remove(selectedP);
				//System.out.println("Valid move");
				nextTurn();
			}
			else{
				//System.out.println("Invalid move");
				selectedP.follow(selectedP.og.getX(), selectedP.og.getY());
				repaint();
			}
		}
		firstClick = null;
		selectedP = null;
		selectedB = null;
		return true;
	}


	public Block getSelectedBlock() {
		// TODO Auto-generated method stub
		return this.selectedB;
	}

	public Piece getSelectedPiece() {
		// TODO Auto-generated method stub
		return this.selectedP;
	}

	public void nextTurn() {
		// TODO Auto-generated method stub
		this.GameTurn++;
		GameTurn = GameTurn%this.numPlayers;
		Player current = whosturn();
		//ai.howManyMovesPossible(this.board, current);
		if(!current.canPlay()){
			if(!this.cantPlayAnymore.contains(current))
				this.cantPlayAnymore.add(current);
			if(this.cantPlayAnymore.size() >= this.numPlayers)
				gameOver();
			else
				nextTurn();
		}
		else if(current.isCPU()){
				//System.out.println(current.isCPU());
				//ai.playRandom(board, current);
				ai.playPrioritizeBlocking(board, current, playerList);
				nextTurn();
			}
	}
	private void gameOver() {
		// TODO Auto-generated method stub
		this.gameOver = true;
		//System.out.print("Game over!");
	}
	public boolean onScreen(Location loc){
		int x = loc.getX();
		int y = loc.getY();
		int dx = this.getWidth();
		int dy = this.getHeight();
		if(x>=0 && x<=dx && y>=0 && y<=dy)
			return true;
		return false;
	}
	public void pass() {
		// TODO Auto-generated method stub
		
			nextTurn();
			firstClick = null;
			selectedP = null;
			selectedB = null;
			repaint();
		
	}
	





}
