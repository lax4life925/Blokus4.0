import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class BlokusBoard {
	
	
	BlokusPanel blokusPanel;
	Block[][] arr;
	static int sizeOfBoard = 20;
	public static final int HORIZONTAL_BUFFER = (BlokusFrame.width - sizeOfBoard*Block.SIZE)/8;
	public static final int VERTICAL_BUFFER =  (BlokusFrame.height - sizeOfBoard*Block.SIZE)/2;
	
	public BlokusBoard(BlokusPanel bp) {
		// TODO Auto-generated constructor stub
		arr = new Block[sizeOfBoard+2][sizeOfBoard+2];
		this.blokusPanel = bp;

	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
		
		for(int r = 1; r < sizeOfBoard+1; r++){
			for(int c = 1; c < sizeOfBoard+1; c++){
				int x = HORIZONTAL_BUFFER + r*Block.SIZE;
				int y = VERTICAL_BUFFER + c*Block.SIZE;
				if(arr[r][c] != null){
					g.setColor(arr[r][c].getColor());
					g.fillRect(x, y, Block.SIZE, Block.SIZE);
				}
				g.setColor(Color.black);
				g.drawRect(x, y, Block.SIZE, Block.SIZE);
			}
				
		}
		Player current = blokusPanel.whosturn();
		if(current.firstMove()){
			g.setColor(current.getColor());
			Location loc = current.getStartingLocation().toScreen();
			g.drawOval(loc.getX(), loc.getY(), Block.SIZE, Block.SIZE);
		}
			
	}

	public boolean validPlay(Piece p) {
		// TODO Auto-generated method stub
		boolean touchingCorner = false;
		boolean startingAtRightSpot = false;
		Color c = p.getColor();
		List<Location> locList = new ArrayList<Location>();
		
		for(Block block : p.getBlockList()){
			int x,y;
			x = block.getScreenLoc().getX() + Block.SIZE/2;
			y = block.getScreenLoc().getY() + Block.SIZE/2;
			locList.add(new Location(x,y).convertToGrid());
		}
		
		for(Location loc : locList){
			
			if(!onGrid(loc) || this.checkOccupied(loc) || this.checkAdjacent(loc,c))
				return false;
			
			if(touchingCorner(loc,c))
				touchingCorner = true;
			
			Player play = p.getPlayer();
			if(play.firstMove()){
				if(play.getStartingLocation().sameLoc(loc))
					startingAtRightSpot = true;
			}
		}if(p.getPlayer().firstMove()){
			if(startingAtRightSpot){
				//System.out.println("Started at right spot");
				p.getPlayer().firstMoveComplete();
				return true;
			}
			return false;
		}
		return touchingCorner;
	}



	private boolean touchingCorner(Location loc, Color c) {
		// TODO Auto-generated method stub
		
		for(Location location : loc.getCorners()){
			Block b = arr[location.getX()][location.getY()];
			if(b != null && b.getColor().equals(c))
				return true;
		}
		return false;
	}

	public boolean checkAdjacent(Location loc, Color c) {
		// TODO Auto-generated method stub
		for(Location location : loc.getAdjacents()){
			Block b = arr[location.getX()][location.getY()];
			if(b != null && b.getColor().equals(c))
				return true;
		}
		return false;
			
	}

	//checks if spot is occupied or off the board
	//returns true if occupied or off board
	public boolean checkOccupied(Location loc) {
		if(arr[loc.getX()][loc.getY()]!=null)
			return true;
		else 
			return false;
	
	}

	public void add(Block block) {
		// TODO Auto-generated method stub
		Location loc = new Location(block.getScreenLoc().getX() + Block.SIZE/2,block.getScreenLoc().getY() + Block.SIZE/2).convertToGrid();
		if(onGrid(loc)){
		arr[loc.getX()][loc.getY()] = block;
		}
		block.setScreenLoc(loc.toScreen());
		blokusPanel.repaint();
	}
	
	public boolean onGrid (Location loc){
		if(loc.getX()> 0 && loc.getX()<=sizeOfBoard && loc.getY()>0 && loc.getY()<=sizeOfBoard)
			return true;
		return false;	
	}

	public Block[][] getArray(){
		Block[][] temp = new Block[this.sizeOfBoard+2][this.sizeOfBoard+2];
		for(int r = 1; r < sizeOfBoard+1; r++){
			for(int c = 1; c < sizeOfBoard+1; c++){
				temp[r][c] = arr[r][c];
			}
		}
		return temp;
		
	}

}
