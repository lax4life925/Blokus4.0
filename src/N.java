public class N extends Piece{

	public N(Player p,int x, int y) {
		super(p,x,y);
		// TODO Auto-generated constructor stub
		blockList.add(new Block(this, 0, 0));
		blockList.add(new Block(this, 1, 0));
		blockList.add(new Block(this, 1, -1));
		blockList.add(new Block(this, 2, -1));
		blockList.add(new Block(this, 3, -1));
	}

	public N(Player p) {
		// TODO Auto-generated constructor stub
		this(p,BlokusFrame.width-(BlokusFrame.width*2/7),BlokusFrame.height-250);
	}

}