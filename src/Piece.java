import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;


public abstract class Piece {
	List<Block> blockList = new ArrayList<Block>();
	 Color color;
	 int x;
	 int y;
	 Location og;
	 Player player;
	public Piece(Player p,int locX, int locY){
		player = p;
		x = locX;
		y = locY;
		og = new Location(x,y);
		color = p.getColor();
	}
	
	public void flipVertically(){
		for(Block b : blockList){
			b.setRelativeLoc(b.getRelativeLoc().getX(), b.getRelativeLoc().getY()*-1);
		}
		this.resetBlocksLoc();
	}
	public void flipHorizontally(){
		for(Block b : blockList){
			b.setRelativeLoc(b.getRelativeLoc().getX()*-1, b.getRelativeLoc().getY());
		}
		this.resetBlocksLoc();
	}

	public void rotate(){
		for(Block b : blockList){
			int x = b.getRelativeLoc().getX();
			int y = b.getRelativeLoc().getY();
			b.setRelativeLoc(y, -1*x);
		}
	}
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(this.color);
		for(Block b : blockList){
			int xLoc = b.getRelativeLoc().getX()*Block.SIZE + x;
			int yLoc = b.getRelativeLoc().getY()*Block.SIZE + y;
			g.setColor(this.color);
			g.fillRect(xLoc, yLoc, Block.SIZE, Block.SIZE);
			g.setColor(Color.BLACK);
			g.drawRect(xLoc, yLoc, Block.SIZE, Block.SIZE);
		}
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	public Color getColor(){
		return color;
	}
	public void setLoc(int xx, int yy){
		x = xx;
		y = yy;
	}

	public static void fill(List<Piece> list, Player p) {
		// TODO Auto-generated method stub
		list.add(new Corner(p));
		list.add(new ThreeLong(p));
		list.add(new FourLong(p));
		list.add(new OneLong(p));
		list.add(new TwoLong(p));
		list.add(new L4(p));
		list.add(new T4(p));
		list.add(new Square(p));
		list.add(new Z4(p));
		list.add(new FiveLong(p));
		list.add(new L5(p));
		list.add(new N(p));
		list.add(new P(p));
		list.add(new U(p));
		list.add(new Y(p));
		list.add(new T5(p));
		list.add(new V5(p));
		list.add(new W(p));
		list.add(new Z5(p));
		list.add(new F(p));
		list.add(new X(p));
	}

	public List<Block> getBlockList() {
		// TODO Auto-generated method stub
		return blockList;
	}

	public void follow(int xx, int yy) {
		// TODO Auto-generated method stub
		int a = Block.SIZE/2;
		x = xx - a;
		y = yy - a;
		resetBlocksLoc();
	}

	private void resetBlocksLoc() {
		// TODO Auto-generated method stub
		for(Block b: blockList){
			b.setScreenLoc(b.getRelativeLoc().getX()*Block.SIZE + getX(), b.getRelativeLoc().getY()*Block.SIZE + getY());
		}
	}

	public Player getPlayer() {
		// TODO Auto-generated method stub
		return player;
	}

}
