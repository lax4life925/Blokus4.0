import java.util.ArrayList;
import java.util.List;


public class Location {
private int x;
private int y;
public Location(int x, int y){
	this.x=x;
	this.y=y;
}
public int getX(){
	return x;
}
public int getY(){
	return y;
}
public Location convertToGrid() {
	// TODO Auto-generated method stub
	int nx= (x-BlokusBoard.HORIZONTAL_BUFFER)/Block.SIZE;
	int ny= (y-BlokusBoard.VERTICAL_BUFFER)/Block.SIZE;
	
	return new Location (nx,ny);
}
public Location toScreen() {
	// TODO Auto-generated method stub
	int nx = (BlokusBoard.HORIZONTAL_BUFFER) + x*Block.SIZE;
	int ny = (BlokusBoard.VERTICAL_BUFFER) + y*Block.SIZE;
	return new Location(nx,ny);
}
public boolean sameLoc(Location other){
	
	return this.getX() == other.getX() && this.getY() == other.getY();
}
public List<Location> getCorners(){
	List<Location> temp = new ArrayList<Location>();
	temp.add(new Location(this.getX()+1,this.getY()+1));
	temp.add(new Location(this.getX()+1,this.getY()-1));
	temp.add(new Location(this.getX()-1,this.getY()+1));
	temp.add(new Location(this.getX()-1,this.getY()-1));

	return temp;
}
public List<Location> getAdjacents(){
	List<Location> temp = new ArrayList<Location>();
	temp.add(new Location(this.getX()+1,this.getY()));
	temp.add(new Location(this.getX()-1,this.getY()));
	temp.add(new Location(this.getX(),this.getY()+1));
	temp.add(new Location(this.getX(),this.getY()-1));

	return temp;
}
public String toString(){
	return "Location x: " + this.getX() + " Location y: " + this.getY();
	
}
}
