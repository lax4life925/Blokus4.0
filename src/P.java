public class P extends Piece{

	public P(Player p,int x, int y) {
		super(p,x,y);
		// TODO Auto-generated constructor stub
		blockList.add(new Block(this, 0, 0));
		blockList.add(new Block(this, 1, 0));
		blockList.add(new Block(this, 2, 0));
		blockList.add(new Block(this, 2, -1));
		blockList.add(new Block(this, 1, -1));
	}

	public P(Player p) {
		// TODO Auto-generated constructor stub
		this(p,BlokusFrame.width-230,BlokusFrame.height-330);
	}

}