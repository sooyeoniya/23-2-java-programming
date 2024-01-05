
public class Point {
	private double x, y;

	public Point() {
		this.x = 0.0;
		this.y = 0.0;
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public double distance(double x, double y) { 
		// The distance between the current point and the point received by the factor
		return Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2));
	}
	
	public double distance(Point p) {
		// The distance between the current point and the point received by the factor
		return Math.sqrt(Math.pow((this.x - p.x), 2) + Math.pow((this.y - p.y), 2));
	}
}
