public class X extends Piece{

	public X(Player p,int x, int y) {
		super(p,x,y);
		// TODO Auto-generated constructor stub
		blockList.add(new Block(this, 0, 0));
		blockList.add(new Block(this, 1, -1));
		blockList.add(new Block(this, 1, 1));
		blockList.add(new Block(this, 2, 0));
		blockList.add(new Block(this, 1, 0));
	}

	public X(Player p) {
		// TODO Auto-generated constructor stub
		this(p,BlokusFrame.width-(BlokusFrame.width*2/15),BlokusFrame.height-370);
	}

}