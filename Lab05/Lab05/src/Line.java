
public class Line extends Point { // Change Superclass from Shape to Point
	private Point v2; // Variable for point v2 is declared internally because multiple inheritances are not possible
	
	public Line(Point v1, Point v2) {
		super(v1.getX(), v1.getY()); // Only values for point v1 are defined as super classes
		this.v2 = v2;
	}

	public double getGradient() {
		// calculate the gradient : y2 - y1 / x2 - x1
		return (v2.getY() - this.getY()) / (v2.getX() - this.getX());
	}

	public Point intersectAt(Line l1) {
		// calculate intersection
		double x1 = this.getX(), y1 = this.getY();
		double x2 = v2.getX(), y2 = v2.getY();
		double lx1 = l1.getX(), ly1 = l1.getY();
		double lx2 = l1.v2.getX(), ly2 = l1.v2.getY();

		double p = (x1 - x2) * (ly1 - ly2) - (y1 - y2) * (lx1 - lx2);
		double px = ((x1 * y2 - y1 * x2) * (lx1 - lx2) - (x1 - x2) * (lx1 * ly2 - ly1 * lx2)) / p;
		double py = ((x1 * y2 - y1 * x2) * (ly1 - ly2) - (y1 - y2) * (lx1 * ly2 - ly1 * lx2)) / p;
		if (p == 0)
			return null;
		else
			return new Point(px, py);
	}

	@Override
	public String toString() {
		return "Line [v1 = (" + this.getX() + ", " + this.getY() + ") , v2 = (" + v2.getX() + ", " + v2.getY() + ")]";
	}

	public Point getCenter() {
		// get the center of a line
		double centerX = (this.getX() + v2.getX()) / 2;
		double centerY = (this.getY() + v2.getY()) / 2;
		return new Point(centerX, centerY);
	}
	
	public double getLength() { // Get this method from Shape class because this class does not inherit Shape class
		// distance between two points
		return Math.sqrt(Math.pow((v2.getX() - this.getX()), 2) + Math.pow((v2.getY() - this.getY()), 2));
	}
}