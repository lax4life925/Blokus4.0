public class W extends Piece{

	public W(Player p,int x, int y) {
		super(p,x,y);
		// TODO Auto-generated constructor stub
		blockList.add(new Block(this, 0, 0));
		blockList.add(new Block(this, 1, -1));
		blockList.add(new Block(this, 1, 0));
		blockList.add(new Block(this, 2, -1));
		blockList.add(new Block(this, 2, -2));
	}

	public W(Player p) {
		// TODO Auto-generated constructor stub
		this(p,BlokusFrame.width-400,BlokusFrame.height-700);
	}

}