
public class L4 extends Piece{

	public L4(Player p,int x, int y) {
		super(p,x,y);
		// TODO Auto-generated constructor stub
		blockList.add(new Block(this, 0, 0));
		blockList.add(new Block(this, 0, -1));
		blockList.add(new Block(this, 1, 0));
		blockList.add(new Block(this, 2, 0));
	}

	public L4(Player p) {
		// TODO Auto-generated constructor stub
		this(p,BlokusFrame.width-400,BlokusFrame.height-400);
	}

}
