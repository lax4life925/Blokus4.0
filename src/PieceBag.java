
	import java.util.ArrayList;
	import java.util.List;


	public class PieceBag {
		ArrayList <Piece> pieceBag;
		
		public PieceBag(Player p){
			pieceBag = new ArrayList<Piece>();
			pieceBag.add(new Piece(p, "Corner"));
			pieceBag.add(new Piece(p, "FourLong"));
			pieceBag.add(new Piece(p, "OneLong"));
			pieceBag.add(new Piece(p, "TwoLong"));
			pieceBag.add(new Piece(p, "L4"));
			pieceBag.add(new Piece(p, "T4"));
			pieceBag.add(new Piece(p, "Square"));
			pieceBag.add(new Piece(p, "Z4"));
			pieceBag.add(new Piece(p, "ThreeLong"));
			pieceBag.add(new Piece(p, "FiveLong"));
			pieceBag.add(new Piece(p, "L5"));
			pieceBag.add(new Piece(p, "U"));
			pieceBag.add(new Piece(p, "F"));
			pieceBag.add(new Piece(p, "P"));
			pieceBag.add(new Piece(p, "V5"));
			pieceBag.add(new Piece(p, "W"));
			pieceBag.add(new Piece(p, "Y"));
			pieceBag.add(new Piece(p, "N"));
			pieceBag.add(new Piece(p, "X"));
			pieceBag.add(new Piece(p, "Z5"));
			pieceBag.add(new Piece(p, "T5"));
		}
		
		public ArrayList<Piece> getPieces(){
			return pieceBag;
		}
	}


