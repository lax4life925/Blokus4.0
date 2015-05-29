
public class OneLong extends Piece {
	public OneLong(Player p,int x, int y) {
		super(p,x,y);
		// TODO Auto-generated constructor stub
		blockList.add(new Block(this, 0, 0));
	}
	public OneLong(Player p) {
		// TODO Auto-generated constructor stub
		this(p,BlokusFrame.width-((BlokusFrame.width*2)/5),BlokusFrame.height-300);
	}
}
