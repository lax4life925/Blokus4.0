import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ArtificialIntelligence {
	Block[][] arr;
	BlokusBoard board;
	Player player;
	List<Piece> possiblePlays;
	public void playPrioritizeBlocking(BlokusBoard b,Player p,List<Player> playerList){
		howManyMovesPossible(b,p);
		List<Location> corners = new ArrayList<Location>();
		List<Piece> blockingMoves = new ArrayList<Piece>();
		for(Player pl : playerList)
			if(!pl.equals(p))
				corners.addAll(getCorners(pl));
		
		for(Location loc : corners)
			for(Piece piec : possiblePlays)
				for(Block bloc : piec.getBlockList())
					if(bloc.getScreenLoc().convertToGrid().sameLoc(loc)){
						blockingMoves.add(piec);
						break;
					}
		
		Piece toPlay = null;
		System.out.println("Blocking moves = " + blockingMoves.size());
		if(blockingMoves.size() > 0){
			Collections.shuffle(blockingMoves);
			Collections.sort(blockingMoves);
			toPlay = blockingMoves.get(0);
		}
		else{
			Collections.shuffle(possiblePlays);
			Collections.sort(possiblePlays);
			if(possiblePlays.size() > 0)
				toPlay = possiblePlays.get(0);
			else p.cannotPlay();
		}
		if(toPlay != null)
			playPiece(toPlay);
			
	}
	public void playRandom(BlokusBoard b,Player p){
		howManyMovesPossible(b,p);
		if(possiblePlays.size() == 0){
			p.cannotPlay();
			return;
		}
		
		Collections.shuffle(possiblePlays);
		Collections.sort(possiblePlays);
		Piece toPlay = possiblePlays.get(0);
		playPiece(toPlay);
		
	}
	private void playPiece(Piece p) {
		// TODO Auto-generated method stub
		if(p != null){
			Piece toRemove = null;
			for(Piece piece : player.getAvailablePieces()){
				if(piece.type.equals(p.type))
					toRemove = piece;
			}
			player.getAvailablePieces().remove(toRemove);
			for(Block bo : p.blockList)
				board.add(bo);
		}
	}
	public void howManyMovesPossible(BlokusBoard b,Player p){
		possiblePlays = new ArrayList<Piece>();
		player = p;
		board = b;
		arr = b.getArray();
		int cornersAvailable = 0;
		int totalmoves = 0;
		List<Location> corners = getCorners(p);
		if(p.firstMove())
			corners.add(p.getStartingLocation());
		for(Location corn : corners){
			for(Piece piece : player.getAvailablePieces()){
				Piece pieceToCheck = piece.cloneSelf();
				for(Block block : pieceToCheck.getCornerList()){
					pieceToCheck.setBlockAsOrigin(block);
					Location screenLoc = corn.toScreen();
					pieceToCheck.follow(screenLoc.getX()-Block.SIZE/2, screenLoc.getY()-Block.SIZE/2);
					for(int j = 0; j < 4; j++){
						pieceToCheck.rotate();
						if(board.validPlay(pieceToCheck)){
							totalmoves++;
							possiblePlays.add(pieceToCheck.exactClone());
						}
					}
					if(pieceToCheck.flippingMatters()){
						pieceToCheck.flipHorizontally();
						for(int j1 = 0; j1 < 4; j1++){
							if(board.validPlay(pieceToCheck)){
								totalmoves++;
								possiblePlays.add(pieceToCheck.exactClone());
								
							}
							pieceToCheck.rotate();
						}
					}
				}
			}
		}
		
		//System.out.println("Total moves possible = " + totalmoves);
	}
	
	public boolean canTheyPlay(BlokusBoard b,Player p){
		player = p;
		board = b;
		arr = b.getArray();
		if(p.firstMove())
			return true;
		List<Location> corners = getCorners(p);
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

	private List<Location> getCorners(Player p) {
		// TODO Auto-generated method stub
		arr = board.getArray();
		List<Location> corners = new ArrayList<Location>();
		for(int r = 1; r < BlokusBoard.sizeOfBoard+1; r++){
			for(int c = 1; c < BlokusBoard.sizeOfBoard+1; c++){
				if(arr[r][c] != null && arr[r][c].getColor().equals(p.getColor()))
					corners.addAll(new Location(r,c).getCorners());
			}
		}
		corners = filter(corners,p);
		return corners;
	}
	//filters out same corners, off grid corners, occupied spots, and adjacent spots
	private List<Location> filter(List<Location> temp,Player p) {
		// TODO Auto-generated method stub
		List<Location> corners = new ArrayList<Location>();
		
		for(Location loc : temp)
			if(board.onGrid(loc) && !board.checkOccupied(loc) && !board.checkAdjacent(loc, p.getColor()) && !corners.contains(loc))
				corners.add(loc);
		
		return corners;
	}
}
