import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class PassButton {
	public static final int SIZE = 50;
	private Location screenLoc;
	public PassButton(int x, int y){
		screenLoc = new Location(x,y);
	}
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle(screenLoc.getX(),screenLoc.getY(),SIZE,SIZE);
		return rect.contains(x, y);	
	}
	public void draw(Graphics g){
		g.setColor(Color.gray);
		g.fillRect(screenLoc.getX(), screenLoc.getY(), SIZE, SIZE);
		g.setColor(Color.BLACK);
		g.drawRect(screenLoc.getX(), screenLoc.getY(), SIZE, SIZE);
		g.drawString("Pass", screenLoc.getX()+(SIZE/4), screenLoc.getY()+(SIZE*3/5));
	}
}
