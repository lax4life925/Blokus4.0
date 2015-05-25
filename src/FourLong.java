
public class FourLong extends Piece {

		public FourLong(Player p,int x, int y) {
			super(p,x,y);
			// TODO Auto-generated constructor stub
			blockList.add(new Block(this, 0, 0));
			blockList.add(new Block(this, 1, 0));
			blockList.add(new Block(this, 2, 0));
			blockList.add(new Block(this, 3, 0));
		}
		public FourLong(Player p) {
			// TODO Auto-generated constructor stub
			this(p,BlokusFrame.width-400,BlokusFrame.height-250);
		}

	}
