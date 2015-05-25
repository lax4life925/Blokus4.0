public class Z4 extends Piece{

	public Z4(Player p,int x, int y) {
		super(p,x,y);
		// TODO Auto-generated constructor stub
		blockList.add(new Block(this, 0, 0));
		blockList.add(new Block(this, 1, 0));
		blockList.add(new Block(this, 1, -1));
		blockList.add(new Block(this, 2, -1));
	}

	public Z4(Player p) {
		// TODO Auto-generated constructor stub
		this(p,BlokusFrame.width-400,BlokusFrame.height-625);
	}

}