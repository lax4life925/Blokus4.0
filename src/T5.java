public class T5 extends Piece{

	public T5(Player p,int x, int y) {
		super(p,x,y);
		// TODO Auto-generated constructor stub
		blockList.add(new Block(this, 0, 0));
		blockList.add(new Block(this, 0, -1));
		blockList.add(new Block(this, 0, -2));
		blockList.add(new Block(this, 1, -1));
		blockList.add(new Block(this, 2, -1));
	}

	public T5(Player p) {
		// TODO Auto-generated constructor stub
		this(p,BlokusFrame.width-230,BlokusFrame.height-570);
	}

}