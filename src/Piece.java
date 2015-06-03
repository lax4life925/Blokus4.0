import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;


public class Piece {
	List<Block> blockList = new ArrayList<Block>();
	 Color color;
	 int x;
	 int y;
	 Location og;
	 String t;
	 Player player;
	 
	 public Piece(Player p, String type){
			player = p;
			color = p.getColor();
			t = type; 
			makeBlocks(type);
		}
	 
	 private void makeBlocks(String type) {
		 
		 	if (type == "Corner"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 0, 1));
				blockList.add(new Block(this, 1, 0));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-150;
		 	}
			if (type == "T4"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 1, -1));
				blockList.add(new Block(this, 1, 0));
				blockList.add(new Block(this, 2, 0));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-475;
			}
			if (type == "Square"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 1, -1));
				blockList.add(new Block(this, 1, 0));
				blockList.add(new Block(this, 0, -1));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-550;
			}
			if (type == "ThreeLong"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 1, 0));
				blockList.add(new Block(this, 2, 0));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-200;
			}
			if (type == "FourLong"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 1, 0));
				blockList.add(new Block(this, 2, 0));
				blockList.add(new Block(this, 3, 0));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-250;
			}
			if (type == "OneLong"){
				blockList.add(new Block(this, 0, 0));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-300;
			}
			if (type == "TwoLong"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 1, 0));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-350;
			}
			if (type == "L4"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 0, -1));
				blockList.add(new Block(this, 1, 0));
				blockList.add(new Block(this, 2, 0));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-400;
			}
			if (type == "Z4"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 1, 0));
				blockList.add(new Block(this, 1, -1));
				blockList.add(new Block(this, 2, -1));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-625;
			}
			if (type == "FiveLong"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 1, 0));
				blockList.add(new Block(this, 2, 0));
				blockList.add(new Block(this, 3, 0));
				blockList.add(new Block(this, 4, 0));
				x=BlokusFrame.width-(BlokusFrame.width*2/7);
				y=BlokusFrame.height-120;
			}
			if (type == "L5"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 1, 0));
				blockList.add(new Block(this, 2, 0));
				blockList.add(new Block(this, 3, 0));
				blockList.add(new Block(this, 0, -1));
				x=BlokusFrame.width-(BlokusFrame.width*2/7);
				y=BlokusFrame.height-170;
			}
			if (type == "U"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 0, -1));
				blockList.add(new Block(this, 1, -1));
				blockList.add(new Block(this, 2, -1));
				blockList.add(new Block(this, 2, 0));
				x=BlokusFrame.width-(BlokusFrame.width*2/7);
				y=BlokusFrame.height-410;
			}
			if (type == "F"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 0, -1));
				blockList.add(new Block(this, 1, -1));
				blockList.add(new Block(this, 1, -2));
				blockList.add(new Block(this, 2, -1));
				x=BlokusFrame.width-(BlokusFrame.width*2/15);
				y=BlokusFrame.height-230;
			}
			if (type == "P"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 1, 0));
				blockList.add(new Block(this, 2, 0));
				blockList.add(new Block(this, 2, -1));
				blockList.add(new Block(this, 1, -1));
				x=BlokusFrame.width-(BlokusFrame.width*2/7);
				y=BlokusFrame.height-330;
			}
			if (type == "V5"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 0, -1));
				blockList.add(new Block(this, 0, -2));
				blockList.add(new Block(this, 1, 0));
				blockList.add(new Block(this, 2, 0));
				x=BlokusFrame.width-(BlokusFrame.width*2/7);
				y=BlokusFrame.height-680;
			}
			if (type == "W"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 1, -1));
				blockList.add(new Block(this, 1, 0));
				blockList.add(new Block(this, 2, -1));
				blockList.add(new Block(this, 2, -2));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-700;
			}
			if (type == "Y"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 1, -1));
				blockList.add(new Block(this, 1, 0));
				blockList.add(new Block(this, 2, 0));
				blockList.add(new Block(this, 3, 0));
				x=BlokusFrame.width-(BlokusFrame.width*2/7);
				y=BlokusFrame.height-490;
			}
			if (type == "N"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 1, 0));
				blockList.add(new Block(this, 1, -1));
				blockList.add(new Block(this, 2, -1));
				blockList.add(new Block(this, 3, -1));
				x=BlokusFrame.width-(BlokusFrame.width*2/7);
				y=BlokusFrame.height-250;
			}
			if (type == "X"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 1, -1));
				blockList.add(new Block(this, 1, 1));
				blockList.add(new Block(this, 2, 0));
				blockList.add(new Block(this, 1, 0));
				x=BlokusFrame.width-(BlokusFrame.width*2/15);
				y=BlokusFrame.height-370;
			}
			if (type == "Z5"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 1, 0));
				blockList.add(new Block(this, 1, -1));
				blockList.add(new Block(this, 1, -2));
				blockList.add(new Block(this, 2, -2));
				x=BlokusFrame.width-(BlokusFrame.width*2/15);
				y=BlokusFrame.height-120;
			}
			if (type == "T5"){
				blockList.add(new Block(this, 0, 0));
				blockList.add(new Block(this, 0, -1));
				blockList.add(new Block(this, 0, -2));
				blockList.add(new Block(this, 1, -1));
				blockList.add(new Block(this, 2, -1));
				x=BlokusFrame.width-(BlokusFrame.width*2/7);
				y=BlokusFrame.height-570;
			}
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
