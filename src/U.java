public class U extends Piece{

	public U(Player p,int x, int y) {
		super(p,x,y);
		// TODO Auto-generated constructor stub
		blockList.add(new Block(this, 0, 0));
		blockList.add(new Block(this, 0, -1));
		blockList.add(new Block(this, 1, -1));
		blockList.add(new Block(this, 2, -1));
		blockList.add(new Block(this, 2, 0));
	}

	public U(Player p) {
		// TODO Auto-generated constructor stub
		this(p,BlokusFrame.width-230,BlokusFrame.height-410);
	}

}