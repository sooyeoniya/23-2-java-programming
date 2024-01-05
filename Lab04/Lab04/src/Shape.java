
public class Shape {
	private Point v1, v2, v3, v4;

	// Definition Shape constructors
	public Shape() {
		this.v1 = new Point();
		this.v2 = new Point();
		this.v3 = new Point();
		this.v4 = new Point();
	}

	public Shape(Point v1) {
		this.v1 = v1;
		this.v2 = new Point();
		this.v3 = new Point();
		this.v4 = new Point();
	}

	public Shape(Point v1, Point v2) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = new Point();
		this.v4 = new Point();
	}

	public Shape(Point v1, Point v2, Point v3) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = new Point();
	}

	public Shape(Point v1, Point v2, Point v3, Point v4) {
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
		this.v4 = v4;
	}

	public Point getV1() {
		return v1;
	}

	public void setV1(Point v1) {
		this.v1 = v1;
	}

	public Point getV2() {
		return v2;
	}

	public void setV2(Point v2) {
		this.v2 = v2;
	}

	public Point getV3() {
		return v3;
	}

	public void setV3(Point v3) {
		this.v3 = v3;
	}

	public Point getV4() {
		return v4;
	}

	public void setV4(Point v4) {
		this.v4 = v4;
	}

	@Override
	public String toString() {
		return "Shape [v1 = " + v1 + ", v2 = " + v2 + ", v3 = " + v3 + ", v4 = " + v4 + "]";
	}

	public double getLength(Point v1, Point v2) {
		// distance between two points
		return Math.sqrt(Math.pow((v2.getX() - v1.getX()), 2) + Math.pow((v2.getY() - v1.getY()), 2));
	}

	public double getAngle(Point v1, Point v2, Point v3) {
		// compute angle between two lines
		double m1 = (v2.getY() - v1.getY()) / (v2.getX() - v1.getX());
		double m2 = (v3.getY() - v2.getY()) / (v3.getX() - v2.getX());
		return Math.atan(Math.abs((m2 - m1) / (1 + m1 * m2))); // find Point v2's angle
	}

	public boolean isParallel(Point v1, Point v2, Point v3, Point v4) {
		// whether the two lines are parallel
		// Same slope and different y-intercept
		double x1 = v1.getX(), y1 = v1.getY();
		double x2 = v2.getX(), y2 = v2.getY();
		double x3 = v3.getX(), y3 = v3.getY();
		double x4 = v4.getX(), y4 = v4.getY();

		double m12 = (y2 - y1) / (x2 - x1);
		double m34 = (y4 - y3) / (x4 - x3);

		double y12 = y1 - (m12 * x1);
		double y34 = y3 - (m34 * x3);

		double p = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

		if (m12 == m34 && y12 != y34 && p == 0)
			return true;
		else
			return false;
	}

	public Point intersectAt(Point v1, Point v2, Point v3, Point v4) {
		// calculate intersection
		double x1 = v1.getX(), y1 = v1.getY();
		double x2 = v2.getX(), y2 = v2.getY();
		double x3 = v3.getX(), y3 = v3.getY();
		double x4 = v4.getX(), y4 = v4.getY();

		double p = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
		double px = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / p;
		double py = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / p;

		if (p == 0) {
			System.out.println("parallel");
			return null;
		} else
			return new Point(px, py);
	}
}
