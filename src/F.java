public class F extends Piece{

	public F(Player p,int x, int y) {
		super(p,x,y);
		// TODO Auto-generated constructor stub
		blockList.add(new Block(this, 0, 0));
		blockList.add(new Block(this, 0, -1));
		blockList.add(new Block(this, 1, -1));
		blockList.add(new Block(this, 1, -2));
		blockList.add(new Block(this, 2, -1));
	}

	public F(Player p) {
		// TODO Auto-generated constructor stub
		this(p,BlokusFrame.width-(BlokusFrame.width*2/15),BlokusFrame.height-230);
	}

}