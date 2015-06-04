import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PlayIsPossibleTester {
	Block[][] arr;
	BlokusBoard board;
	Player player;
	List<Piece> possiblePlays;
	public void playRandom(BlokusBoard b,Player p){
		if(p.firstMove())
			return;
		howManyMovesPossible(b,p);
		if(possiblePlays.size() == 0)
			return;
		Collections.shuffle(possiblePlays);
		Piece toPlay = possiblePlays.get(0);
		
		if(toPlay != null){
			Piece toRemove = null;
			for(Piece piece : p.getAvailablePieces()){
				if(piece.type.equals(toPlay.type))
					toRemove = piece;
			}
			p.getAvailablePieces().remove(toRemove);
			for(Block bo : toPlay.blockList)
				board.add(bo);
		}
	}
	public void howManyMovesPossible(BlokusBoard b,Player p){
		possiblePlays = new ArrayList<Piece>();
		if(p.firstMove())
			return;
		player = p;
		board = b;
		arr = b.getArray();
		int cornersAvailable = 0;
		int totalmoves = 0;
		List<Location> corners = getCorners();
		System.out.println("How many corners available " + corners.size());
		for(Location corn : corners){
			for(Piece piece : player.getAvailablePieces()){
				Piece pieceToCheck = piece.cloneSelf();
				for(Block block : pieceToCheck.getCornerList()){
					pieceToCheck.setBlockAsOrigin(block);
					Location screenLoc = corn.toScreen();
					pieceToCheck.follow(screenLoc.getX()-Block.SIZE/2, screenLoc.getY()-Block.SIZE/2);
					for(int j = 0; j < 4; j++){
						//pieceToCheck.rotate();
						if(board.validPlay(pieceToCheck)){
							totalmoves++;
							possiblePlays.add(pieceToCheck.exactClone());
						}
					}
				/*	if(pieceToCheck.flippingMatters()){
						pieceToCheck.flipHorizontally();
						for(int j1 = 0; j1 < 4; j1++){
							if(board.validPlay(pieceToCheck)){
								totalmoves++;
								possiblePlays.add(pieceToCheck.exactClone());
								
							}
							pieceToCheck.rotate();
						}
					}*/	
				}
			}
		}
		
		System.out.println("Total moves possible = " + totalmoves);
	}
	
	public boolean canTheyPlay(BlokusBoard b,Player p){
		player = p;
		board = b;
		arr = b.getArray();
		if(p.firstMove())
			return true;
		List<Location> corners = getCorners();
		for(Location corn : corners){
			System.out.println("Checking corner (" + corn.getX() + "," + corn.getY() + ")");
			if(canPlayOnCorner(corn))
				return true;
		}
		
		return false;
		
	}

	private boolean canPlayOnCorner(Location loc) {
		// TODO Auto-generated method stub
		for(Piece piece : player.getAvailablePieces()){
			System.out.println("Checking Piece: " + piece.type);
			if(pieceWorksOnCorner(piece,loc))
				return true;
		}
			return false;
	}

	private boolean pieceWorksOnCorner(Piece piece, Location loc) {
		// TODO Auto-generated method stub
		int i = 1;
		Piece p = piece.cloneSelf();
		
		for(Block b : p.getCornerList()){
			System.out.println("Checking piece corner: " + i);
			p.setBlockAsOrigin(b);
			Location screenLoc = loc.toScreen();
			p.follow(screenLoc.getX()+Block.SIZE/2, screenLoc.getY()+Block.SIZE/2);
			for(int j = 0; j < 4; j++){
				if(this.board.validPlay(p))
					return true;
				else{
					System.out.println("Rotating");
					p.rotate();
				}
				}
			i++;
			if(p.flippingMatters()){
				p.flipHorizontally();
				for(int j = 0; j < 4; j++){
					if(this.board.validPlay(p))
						return true;
					else
						p.rotate();
					}
				}
			}
		return false;
	}

	private List<Location> getCorners() {
		// TODO Auto-generated method stub
		arr = board.getArray();
		List<Location> corners = new ArrayList<Location>();
		for(int r = 1; r < BlokusBoard.sizeOfBoard+1; r++){
			for(int c = 1; c < BlokusBoard.sizeOfBoard+1; c++){
				if(arr[r][c] != null && arr[r][c].getColor().equals(player.getColor()))
					corners.addAll(new Location(r,c).getCorners());
			}
		}
		corners = filter(corners);
		return corners;
	}
	//filters out same corners, off grid corners, occupied spots, and adjacent spots
	private List<Location> filter(List<Location> temp) {
		// TODO Auto-generated method stub
		List<Location> corners = new ArrayList<Location>();
		
		for(Location loc : temp)
			if(board.onGrid(loc) && !board.checkOccupied(loc) && !board.checkAdjacent(loc, player.getColor()) && !corners.contains(loc))
				corners.add(loc);
		
		return corners;
	}
}
