import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Block {
//test
	public static final int SIZE = 30;
	private Color color;
	private Location relativeLoc;
	private Location screenLoc;
	private Piece piece;
	private boolean corner = false;
	
	public Block(Color c){
		color = c;
	}
	
	public Block(Piece p, int relX, int relY, boolean c) {
		// TODO Auto-generated constructor stub
		piece = p;
		color = p.getColor();
		relativeLoc = new Location(relX,relY);
		screenLoc = new Location(relX*Block.SIZE + p.getX(), relY*Block.SIZE + p.getY());
		corner = c;
	}

	public Color getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	//relative to piece
	public void setRelativeLoc(int x, int y){
		relativeLoc = new Location(x,y);
	}
	//on screen, top left corner
	public void setScreenLoc(int x, int y){
		screenLoc = new Location(x,y);
	}
	
	public Location getScreenLoc(){
		return new Location(getRelativeLoc().getX()*Block.SIZE + piece.getX(),getRelativeLoc().getY()*Block.SIZE + piece.getY());
	}
	
	public Location getRelativeLoc(){
		return relativeLoc;
	}

	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle(getRelativeLoc().getX()*Block.SIZE + piece.getX(),getRelativeLoc().getY()*Block.SIZE + piece.getY(),SIZE,SIZE);
		//System.out.println("Testing: "+getRelativeLoc().getX()*Block.SIZE + piece.getX()+" "+getRelativeLoc().getY()*Block.SIZE + piece.getY()+" "+SIZE);
		return rect.contains(x, y);
	}


	public void setScreenLoc(Location screen) {
		// TODO Auto-generated method stub
		screenLoc = screen;
	}
	
	public boolean isCorner(){
		return corner;
	}
	
}
