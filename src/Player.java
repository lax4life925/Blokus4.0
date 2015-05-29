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
	private Location startingLoc;
	private static Location[] fourPlayerStartingLocations = {new Location(1,20),new Location(1,1),new Location(20,1),new Location(20,20)};
	private static Location[] threePlayerStartingLocations = {};
	private static Location[] twoPlayerStartingLocations = {new Location(5,5),new Location(15,15)};
	private static Location[][] startingLocations ={twoPlayerStartingLocations,threePlayerStartingLocations,fourPlayerStartingLocations};
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
		Piece.fill(usablePieces,this);

		startingLoc = new Location(1,1);
		startingLoc = getStartLoc(t,nP);
		score = Integer.MIN_VALUE;
	}

	private static Location getStartLoc(int t, int numP) {
		// TODO Auto-generated method stub
		return startingLocations[numP-2][t];
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
		if(score==Integer.MIN_VALUE){
			for(Piece p: usablePieces){
				for(Block b: p.getBlockList()){
					score--;
				}
			}
		}
		return score;
	}
	public void firstMoveComplete() {
		// TODO Auto-generated method stub
		firstMove = false;
	}
	public boolean playIsPossible() {
		// TODO Auto-generated method stub
		return true;
	}
}
