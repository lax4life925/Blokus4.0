public class Y extends Piece{

	public Y(Player p,int x, int y) {
		super(p,x,y);
		// TODO Auto-generated constructor stub
		blockList.add(new Block(this, 0, 0));
		blockList.add(new Block(this, 1, -1));
		blockList.add(new Block(this, 1, 0));
		blockList.add(new Block(this, 2, 0));
		blockList.add(new Block(this, 3, 0));
	}

	public Y(Player p) {
		// TODO Auto-generated constructor stub
		this(p,BlokusFrame.width-230,BlokusFrame.height-490);
	}

}