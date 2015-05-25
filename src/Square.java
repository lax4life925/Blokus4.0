public class Square extends Piece{

	public Square(Player p,int x, int y) {
		super(p,x,y);
		// TODO Auto-generated constructor stub
		blockList.add(new Block(this, 0, 0));
		blockList.add(new Block(this, 1, -1));
		blockList.add(new Block(this, 1, 0));
		blockList.add(new Block(this, 0, -1));
	}

	public Square(Player p) {
		// TODO Auto-generated constructor stub
		this(p,BlokusFrame.width-400,BlokusFrame.height-550);
	}

}