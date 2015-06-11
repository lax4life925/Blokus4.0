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
	JButton passButton;
	Player winner;
	List<Player> playerList = new ArrayList<Player>();
	MyListener listen= new MyListener(this);
	ArtificialIntelligence ai = new ArtificialIntelligence();
	int numPlayers = 4;
	List<Player> cantPlayAnymore = new ArrayList<Player>();
	private boolean gameOver;
	private boolean CPUfirst = false;
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
				Player p = playerList.get(GameTurn);
				pass(p);

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
	private ArrayList<Player> findTies(){
		ArrayList<Player> ties = new ArrayList();
		if(numPlayers==4){
		for(Player p: this.playerList){
			if(p.getScore()==winner.getScore()){
				ties.add(p);
			}
		}
		}
		else if(numPlayers==2){
			int x = this.playerList.get(0).getScore() + this.playerList.get(2).getScore();
			int y = this.playerList.get(1).getScore() + this.playerList.get(3).getScore();
			if(x==y){
				ties.add(playerList.get(0));
				ties.add(playerList.get(1));
			}
		}
		return ties;
	}
	private void setUpPlayers() {
		// TODO Auto-generated method stub
		//numPlayers = getNumPlayersInitial();
		for(int i = 0; i < 4;i++){
			playerList.add(new Player(colors[i], i, numPlayers));
			if(i<numPlayers){
				if(this.playerNames.get(i).contains("CPU")){
					playerList.get(i).setAsCPU();
				}
			}
		}
		if(playerList.get(0).isCPU()==true){
			CPUfirst = true;
			nextTurn();
		}
		repaint();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		board.draw(g);
		String s2 = "Rotate = space bar";
		String s1 = "Flip = arrow keys";
		g.setColor(Color.black);
		g.drawString(s2, 1000, 100);
		g.drawString(s1, 1000, 120);
		//passB.draw(g);
		if(gameOver){
			Player p = findWinner();
			winner=p;
			ArrayList<Player> ties = findTies();
			if(ties.size()<=1){
			g.drawString(this.playerNames.get(p.getTurn()) + " WON! Congratulations!", passButton.getX() - 50, passButton.getY() + 50);
			}
			else if(numPlayers==4){
				String s="";
				for(int i= 0; i< ties.size();i++){
					if(i!=ties.size()-1)
					s+=playerNames.get(ties.get(i).getTurn()) + " and ";
					else{
						s+=playerNames.get(ties.get(i).getTurn());
					}
				}
				
				g.drawString(s + " tied for first!", passButton.getX() - 50, passButton.getY() + 50);
			}
			else if(numPlayers==2){
				String s="";
				s+= playerNames.get(0) + " and " + playerNames.get(1);
				g.drawString( s+ " tied!", passButton.getX() - 50, passButton.getY() + 50);
			}
		}
		Player myTurn = whosturn();
		if(numPlayers==4){
			for(int i=0; i<this.getNumPlayers();i++){
				if(myTurn.equals(playerList.get(i))){
					Color c = this.playerList.get(i).getColor();
					if(c.equals(Color.yellow)){
						c = Color.magenta;
					}
					g.setColor(c);
				}
				else{
					g.setColor(Color.black);
				}
				g.drawString(this.playerNames.get(i) + "'s Score: " + this.playerList.get(i).getScore(), 20, 25 +25*i);
			}
		}
		else if(numPlayers==2){
			for(int i=0; i<this.getNumPlayers();i++){
				if(myTurn.equals(playerList.get(i)) || myTurn.equals(playerList.get(i+2))){
					Color c = myTurn.getColor();
					if(c.equals(Color.yellow)){
						c = Color.magenta;
					}
					g.setColor(c);
				}
				else{
					g.setColor(Color.black);
				}
				int x = this.playerList.get(i).getScore() + this.playerList.get(i + 2).getScore();
				g.drawString(this.playerNames.get(i) + "'s Score: " + x, 20, 25 +25*i);
			}
		}
		//g.drawString(this.playerNames.get(GameTurn) + "'s Score: " + myTurn.getScore(), 25, 100);
		if(whosturn() != null){
			for(Piece p : whosturn().getAvailablePieces()){
				p.draw(g);
			}	
		}
	}



	private Player findWinner() {
		// TODO Auto-generated method stub
		int x = Integer.MIN_VALUE;
		Player winner = null;
		if(numPlayers == 4){
			for(Player z: this.playerList){
				if(z.getScore()>x){
					winner = z;
					x = z.getScore();
				}
			}
		}
		else if(numPlayers == 2){
			if((playerList.get(1).getScore()+playerList.get(3).getScore())>(playerList.get(0).getScore()+playerList.get(2).getScore())){
				winner = playerList.get(1);
			}
			else{
				winner = playerList.get(0);
			}
		}
		return winner;
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
		if(CPUfirst){
			GameTurn--;
			CPUfirst = false;
		}
		GameTurn = GameTurn%4;
		Player current = whosturn();
		//System.out.println(current);
		//ai.howManyMovesPossible(this.board, current);
		if(current.canPlay()==false){
			if(!this.cantPlayAnymore.contains(current)){
				//System.out.println("here");
				this.cantPlayAnymore.add(current);
			}
			if(this.cantPlayAnymore.size() >= playerList.size()){
				//System.out.println("Here");
				gameOver();
			}
			else
				nextTurn();
		}
		else {
			int x = GameTurn;
			if(GameTurn>=playerNames.size()){
				x=GameTurn-2;
			}
			if(this.playerNames.get(x).contains("EASY CPU")){
				//System.out.println(current.isCPU());
				//ai.playRandom(board, current);
				//System.out.println("I'm here!");
				ai.playPrioritizeBlocking(board, current, playerList);
				nextTurn();
			}
			else if(this.playerNames.get(x).contains("HARD CPU")){
				//System.out.println(current.isCPU());
				//ai.playRandom(board, current);
				ai.playPrioritizeBlocking(board, current, playerList);
				nextTurn();
			}

			else if(this.playerNames.get(x).contains("RANDOM CPU")){
				//System.out.println(current.isCPU());
				//ai.playRandom(board, current);
				//ai.playPrioritizeBlocking(board, current, playerList);
				ai.playRandom(this.board, current);
				nextTurn();
			}
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
	public void pass(Player p) {
		// TODO Auto-generated method stub
		if(p.isCPU()==false){
			int n = JOptionPane.showConfirmDialog(
		            null,
		            "Are you out of moves?"
		            + "\n(If you answer yes, you will not be able make any moves in the future.)",
		            "Can't play?",
		            JOptionPane.YES_NO_OPTION);

		        if(n == JOptionPane.YES_OPTION){
		            JOptionPane.showMessageDialog(null, "Goodluck!");
		            p.cannotPlay();
		        }
		        else {
		            JOptionPane.showMessageDialog(null, "You have just forfeited your turn.");
		            
		        }
		}
		nextTurn();
		firstClick = null;
		selectedP = null;
		selectedB = null;
		repaint();

	}






}
