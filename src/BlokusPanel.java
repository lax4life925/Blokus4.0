import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class BlokusPanel extends JPanel{
	BlokusBoard board;
	private int GameTurn=4;
	Location firstClick;
	Piece selectedP;
	Block selectedB;
	List<Player> playerList = new ArrayList<Player>();
	MyListener listen= new MyListener(this);
	int numPlayers = 0;
	// true if game has begun
	boolean playing = false;
	Color[] colors = {Color.blue,Color.yellow,Color.red,Color.green};
	//player blue's turn = 0
	//player yellow's turn = 1
	//player red's turn = 2
	//player green's turn = 3
	List<Piece> piecesAvailable = new ArrayList<Piece>();
	List<Piece> piecesUsed = new ArrayList<Piece>();
	public BlokusPanel(){
		super();
		this.addMouseListener(listen);
		addMouseMotionListener(listen);
		setPreferredSize(new Dimension(BlokusFrame.width,BlokusFrame.height));
		board = new BlokusBoard(this);
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
		numPlayers = getNumPlayersInitial();
		for(int i = 0; i < numPlayers;i++){
			playerList.add(new Player(colors[i], i,numPlayers));
		}
		repaint();
	}

	private int getNumPlayersInitial() {
		// TODO Auto-generated method stub
		JOptionPane jop = new JOptionPane();
		String s = jop.showInputDialog("How many players?").toString();
		int x = 0;
		try {x = Integer.parseInt(s);} catch (NumberFormatException e) {}
		while(x > 4 || x < 2){
			s = jop.showInputDialog("Please enter an number between 1 and 4. How many players?");
			try {x = Integer.parseInt(s);} catch (NumberFormatException e) {}
		}
		return x;
	}

	private void testForPieceFlip() {
		// TODO Auto-generated method stub
		Piece p = new Corner(playerList.get(0),10,10);
		int i = 1;
		for(Block b : p.blockList){
			int x = b.getRelativeLoc().getX();
			int y = b.getRelativeLoc().getY();
			System.out.println("Block " + i + " x: " + x + " y: " + y);
			
			
		}
		
		p.flipHorizontally();
		System.out.println("Flipped horizontally");
		for(Block b : p.blockList){
			int x = b.getRelativeLoc().getX();
			int y = b.getRelativeLoc().getY();
			System.out.println("Block " + i + " x: " + x + " y: " + y);
			
			
		}
		p.flipHorizontally();
		p.flipVertically();
		System.out.println("Flipped Vertically");
		for(Block b : p.blockList){
			int x = b.getRelativeLoc().getX();
			int y = b.getRelativeLoc().getY();
			System.out.println("Block " + i + " x: " + x + " y: " + y);
			
			
		}
	}

	private void setUpTimer() {
		// TODO Auto-generated method stub

	}

	public void addAllPieces(){
		// we're gonna need to hard code all the pieces individually onto the board I think since
		// we're doing a separate class for each class...
		// also that will give us more control when determining each piece's characteristics
		// all pieces will go into pieces Available list
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
			board.draw(g);
			if(whosturn() != null)
				for(Piece p : whosturn().getAvailablePieces()){
					p.draw(g);
				}
		
		
	}
	

	
	public Player whosturn(){
		int x = GameTurn%this.getNumPlayers();
		for(Player z: this.playerList){
			if(z.getTurn()==x){
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
				
				myTurn.getAvailablePieces().remove(selectedP);
				System.out.println("Valid move");
				nextTurn();
			}
			else{
				System.out.println("Invalid move");
				selectedP.follow(firstClick.getX(), firstClick.getY());
				repaint();
			}
		}
		firstClick = null;
		selectedP = null;
		selectedB = null;
		return false;
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
	}





}
