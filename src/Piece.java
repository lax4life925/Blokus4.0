import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;


public class Piece implements Comparable{
	List<Block> blockList = new ArrayList<Block>();
	List<Block> cornerList = new ArrayList<Block>();
	 Color color;
	 int x;
	 int y;
	 Location og;
	 String type;
	 Player player;
	 Boolean flippingMatters = true;
	 public Piece(Player p, String t){
			player = p;
			color = p.getColor();
			type = t; 
			makeBlocks(type);
			og = new Location(x,y);
		}
	 
	 private void makeBlocks(String type) {
		 
		 	if (type == "Corner"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 0, 1,true));
				blockList.add(new Block(this, 1, 0,true));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-150;
		 	}
			if (type == "T4"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 1, -1,true));
				blockList.add(new Block(this, 1, 0,false));
				blockList.add(new Block(this, 2, 0,true));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-475;
				flippingMatters = false;
			}
			if (type == "Square"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 1, -1,true));
				blockList.add(new Block(this, 1, 0,true));
				blockList.add(new Block(this, 0, -1,true));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-550;
				flippingMatters = false;
			}
			if (type == "ThreeLong"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 1, 0,false));
				blockList.add(new Block(this, 2, 0,true));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-200;
			}
			if (type == "FourLong"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 1, 0,false));
				blockList.add(new Block(this, 2, 0,false));
				blockList.add(new Block(this, 3, 0,true));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-250;
				flippingMatters = false;
			}
			if (type == "OneLong"){
				blockList.add(new Block(this, 0, 0,true));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-300;
				flippingMatters = false;
			}
			if (type == "TwoLong"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 1, 0,true));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-350;
				flippingMatters = false;
			}
			if (type == "L4"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 0, -1,true));
				blockList.add(new Block(this, 1, 0,false));
				blockList.add(new Block(this, 2, 0,true));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-400;
			}
			if (type == "Z4"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 1, 0,true));
				blockList.add(new Block(this, 1, -1,true));
				blockList.add(new Block(this, 2, -1,true));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-625;
			}
			if (type == "FiveLong"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 1, 0,false));
				blockList.add(new Block(this, 2, 0,false));
				blockList.add(new Block(this, 3, 0,false));
				blockList.add(new Block(this, 4, 0,true));
				x=BlokusFrame.width-(BlokusFrame.width*2/7);
				y=BlokusFrame.height-120;
				flippingMatters = false;
			}
			if (type == "L5"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 1, 0,false));
				blockList.add(new Block(this, 2, 0,false));
				blockList.add(new Block(this, 3, 0,true));
				blockList.add(new Block(this, 0, -1,true));
				x=BlokusFrame.width-(BlokusFrame.width*2/7);
				y=BlokusFrame.height-170;
				og = new Location(x,y);
			}
			if (type == "U"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 0, -1,true));
				blockList.add(new Block(this, 1, -1,false));
				blockList.add(new Block(this, 2, -1,true));
				blockList.add(new Block(this, 2, 0,true));
				x=BlokusFrame.width-(BlokusFrame.width*2/7);
				y=BlokusFrame.height-410;
				flippingMatters = false;
			}
			if (type == "F"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 0, -1,true));
				blockList.add(new Block(this, 1, -1,false));
				blockList.add(new Block(this, 1, -2,true));
				blockList.add(new Block(this, 2, -1,true));
				x=BlokusFrame.width-(BlokusFrame.width*2/15);
				y=BlokusFrame.height-230;
			}
			if (type == "P"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 1, 0,false));
				blockList.add(new Block(this, 2, 0,true));
				blockList.add(new Block(this, 2, -1,true));
				blockList.add(new Block(this, 1, -1,true));
				x=BlokusFrame.width-(BlokusFrame.width*2/7);
				y=BlokusFrame.height-330;
			}
			if (type == "V5"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 0, -1,false));
				blockList.add(new Block(this, 0, -2,true));
				blockList.add(new Block(this, 1, 0,false));
				blockList.add(new Block(this, 2, 0,true));
				x=BlokusFrame.width-(BlokusFrame.width*2/7);
				y=BlokusFrame.height-680;
			}
			if (type == "W"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 1, -1,true));
				blockList.add(new Block(this, 1, 0,true));
				blockList.add(new Block(this, 2, -1,true));
				blockList.add(new Block(this, 2, -2,true));
				x=BlokusFrame.width-((BlokusFrame.width*2)/5);
				y=BlokusFrame.height-700;
			}
			if (type == "Y"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 1, -1,true));
				blockList.add(new Block(this, 1, 0,false));
				blockList.add(new Block(this, 2, 0,false));
				blockList.add(new Block(this, 3, 0,true));
				x=BlokusFrame.width-(BlokusFrame.width*2/7);
				y=BlokusFrame.height-490;
			}
			if (type == "N"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 1, 0,true));
				blockList.add(new Block(this, 1, -1,true));
				blockList.add(new Block(this, 2, -1,false));
				blockList.add(new Block(this, 3, -1,true));
				x=BlokusFrame.width-(BlokusFrame.width*2/7);
				y=BlokusFrame.height-250;
			}
			if (type == "X"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 1, -1,true));
				blockList.add(new Block(this, 1, 1,true));
				blockList.add(new Block(this, 2, 0,true));
				blockList.add(new Block(this, 1, 0,false));
				x=BlokusFrame.width-(BlokusFrame.width*2/15);
				y=BlokusFrame.height-370;
			}
			if (type == "Z5"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 1, 0,true));
				blockList.add(new Block(this, 1, -1,false));
				blockList.add(new Block(this, 1, -2,true));
				blockList.add(new Block(this, 2, -2,true));
				x=BlokusFrame.width-(BlokusFrame.width*2/15);
				y=BlokusFrame.height-120;
			}
			if (type == "T5"){
				blockList.add(new Block(this, 0, 0,true));
				blockList.add(new Block(this, 0, -1,false));
				blockList.add(new Block(this, 0, -2,true));
				blockList.add(new Block(this, 1, -1,false));
				blockList.add(new Block(this, 2, -1,true));
				x=BlokusFrame.width-(BlokusFrame.width*2/7);
				y=BlokusFrame.height-570;
			}
			og = new Location(x,y);
			for(Block b: blockList){
				if(b.isCorner()){
					this.cornerList.add(b);
				}
			}
			
			this.setBlockAsOrigin(this.cornerList.get(0));
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
		this.resetBlocksLoc();
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
		/*for(Block b : cornerList){
			int xLoc = b.getRelativeLoc().getX()*Block.SIZE + x;
			int yLoc = b.getRelativeLoc().getY()*Block.SIZE + y;
			g.drawOval(xLoc, yLoc, Block.SIZE, Block.SIZE);
		}
		*/
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
		x = xx;
		y = yy;
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

	

	public Piece cloneSelf() {
		// TODO Auto-generated method stub
		return new Piece(this.player, this.type);
	}

	public List<Block> getCornerList() {
		// TODO Auto-generated method stub
		return cornerList;
	}

	public void setBlockAsOrigin(Block b) {
		// TODO Auto-generated method stub
		//if component greater than 0, while b has component greater than 0 subtract one from all
		if(b.getRelativeLoc().getX() > 0)
			while(b.getRelativeLoc().getX() > 0)
				for(Block a : this.blockList)
					a.setRelativeLoc(a.getRelativeLoc().getX()-1, a.getRelativeLoc().getY());
		if(b.getRelativeLoc().getX() < 0)
			while(b.getRelativeLoc().getX() < 0)
				for(Block a : this.blockList)
					a.setRelativeLoc(a.getRelativeLoc().getX()+1, a.getRelativeLoc().getY());
		if(b.getRelativeLoc().getY() > 0)
			while(b.getRelativeLoc().getY() > 0){
				for(Block a : this.blockList)
					a.setRelativeLoc(a.getRelativeLoc().getX(), a.getRelativeLoc().getY()-1);
			}

		if(b.getRelativeLoc().getY() < 0)
			while(b.getRelativeLoc().getY() < 0)
				for(Block a : this.blockList)
					a.setRelativeLoc(a.getRelativeLoc().getX(), a.getRelativeLoc().getY()+1);
		this.resetBlocksLoc();
		
	}

	public boolean flippingMatters() {
		// TODO Auto-generated method stub
		return flippingMatters;
	}

	public Piece exactClone() {
		// TODO Auto-generated method stub
		Piece temp = this.cloneSelf();
		for(int i = 0; i < temp.blockList.size();i++){
			Block a = temp.getBlockList().get(i);
			Block b = this.getBlockList().get(i);
			a.setRelativeLoc(b.getRelativeLoc().getX(), b.getRelativeLoc().getY());
		}
		temp.follow(this.getX(), this.getY());
		return temp;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Piece p = (Piece) o;
		return p.getBlockList().size() - getBlockList().size();
	}
}
