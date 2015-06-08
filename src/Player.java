import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;


public class Player {

	private Color color;
	private int turn;
	private int score;
	private List<Piece> usablePieces;
	private boolean firstMove = true;
	private boolean playedSingleLast = false;
	
	private Location startingLoc;
	private static Location[] startingLocations = {new Location(1,20),new Location(1,1),new Location(20,1),new Location(20,20)};
	//player blue's turn = 0
	//player yellow's turn = 1
	//player red's turn = 2
	//player green's turn = 3
	/*	usablePieces = new ArrayList<Piece>();
	turn = t;
	color = c;		
	Piece.fill(usablePieces,this);

	startingLoc = new Location(1,1);
	switch (turn){
	case 0: startingLoc = new Location(1,20);
			break;
	case 1: startingLoc = new Location(1,1);
			break;
	case 2: startingLoc = new Location(20,1);
			break;
	case 3: startingLoc = new Location(20,20);
			break;
	 */
	public Player(Color c, int t, int nP) {
		// TODO Auto-generated constructor stub
		usablePieces = new ArrayList<Piece>();
		turn = t;
		color = c;	
		PieceBag pb = new PieceBag(this);
		usablePieces = pb.getPieces();
		startingLoc = new Location(1,1);
		startingLoc = getStartLoc(t);
		score = Integer.MIN_VALUE;
	}

	private static Location getStartLoc(int t) {
		// TODO Auto-generated method stub
		return startingLocations[t];
	}

	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}

	public int getTurn(){
		return turn;
	}
	public List<Piece> getAvailablePieces(){
		return usablePieces;
	}
	public boolean firstMove(){
		return firstMove;
	}

	public Location getStartingLocation() {
		// TODO Auto-generated method stub
		return startingLoc;
	}
	public int getScore(){
		if(usablePieces.size()>0){
			score=0;
			for(Piece p: usablePieces){
				for(Block b: p.getBlockList()){
					score--;
				}
			}
		}
		if(usablePieces.size()==0){
			score=0;
			score+=15;
		}
		if(playedSingleLast){
			score+=5;
		}
		return score;
	}
	public void firstMoveComplete() {
		// TODO Auto-generated method stub
		firstMove = false;
	}
	public void playedSingleLast(){
		playedSingleLast=true;
	}
	public boolean playIsPossible() {
		// TODO Auto-generated method stub
		
		return true;
	}

}
