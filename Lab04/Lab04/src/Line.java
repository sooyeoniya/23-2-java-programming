
public class Line extends Shape {

	public Line(Point v1, Point v2) {
		super(v1, v2);
	}

	public double getGradient() {
		// calculate the gradient : y2 - y1 / x2 - x1
		return (this.getV2().getY() - this.getV1().getY()) / (this.getV2().getX() - this.getV1().getX());
	}

	public Point intersectAt(Line l1) {
		// calculate intersection
		double x1 = this.getV1().getX(), y1 = this.getV1().getY();
		double x2 = this.getV2().getX(), y2 = this.getV2().getY();
		double lx1 = l1.getV1().getX(), ly1 = l1.getV1().getY();
		double lx2 = l1.getV2().getX(), ly2 = l1.getV2().getY();

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
		return "Line [v1 = " + this.getV1() + ", v2 = " + this.getV2() + "]";
	}

	public Point getCenter() {
		// get the center of a line
		double centerX = (this.getV1().getX() + this.getV2().getX()) / 2;
		double centerY = (this.getV1().getY() + this.getV2().getY()) / 2;
		return new Point(centerX, centerY);
	}
}