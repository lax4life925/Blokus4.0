public class T4 extends Piece{

	public T4(Player p,int x, int y) {
		super(p,x,y);
		// TODO Auto-generated constructor stub
		blockList.add(new Block(this, 0, 0));
		blockList.add(new Block(this, 1, -1));
		blockList.add(new Block(this, 1, 0));
		blockList.add(new Block(this, 2, 0));
	}

	public T4(Player p) {
		// TODO Auto-generated constructor stub
		this(p,BlokusFrame.width-((BlokusFrame.width*2)/5),BlokusFrame.height-475);
	}

}