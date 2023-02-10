package DesignPatterns.Strategy;
public class Point implements Comparable<Point>{
	private final double x,y;
	public Point (double x1, double y1){
		x = x1;
		y = y1;
	}
	public Point (){
		x = 0;
		y = 0;
	}
 // ********** public methods *********
	public double getX() {
		return x;
	}	
	public double getY() {
		return y;
	}
	public double distance() {
		return Math.sqrt(this.x*this.x + this.y*this.y);
	}

	@Override
	public int compareTo(Point p) {
		int cmp = 0;
		if (this.distance() < p.distance()) cmp = -1;
		else if (this.distance() > p.distance()) cmp = 1;
		return cmp;
	}
}
