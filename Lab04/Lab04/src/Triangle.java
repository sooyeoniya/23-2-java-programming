
public class Triangle extends Shape {

	public Triangle(Point v1, Point v2, Point v3) {
		super(v1, v2, v3);
	}

	@Override
	public String toString() {
		return "Triangle [v1 = " + this.getV1() + ", v2 = " + this.getV2() + ", v3 = " + this.getV3() + "]";
	}

	public String getType() {
		// output the type of a triangle
		if (isRightTriangle())
			return "It is a right-angled triangle.";
		else if (isEquilateralTriangle())
			return "It is a equilateral triangle.";
		else if (isAcuteTriangle())
			return "It is a acute-angled triangle.";
		else
			return "Nothing.";
	}

	public double getPerimeter() {
		// get the perimeter of a triangle
		double a = getLength(this.getV1(), this.getV2());
		double b = getLength(this.getV2(), this.getV3());
		double c = getLength(this.getV3(), this.getV1());
		return a + b + c;
	}

	public double getArea() {
		double a = getLength(this.getV1(), this.getV2());
		double b = getLength(this.getV2(), this.getV3());
		double c = getLength(this.getV3(), this.getV1());
		// Triangle by Heron’s formula
		double s = (a + b + c) / 2.0;
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	public Point getCenter() {
		// get the center of a triangle
		double centerX = (this.getV1().getX() + this.getV2().getX() + this.getV3().getX()) / 3;
		double centerY = (this.getV1().getY() + this.getV2().getY() + this.getV3().getY()) / 3;
		return new Point(centerX, centerY);
	}

	private boolean isRightTriangle() {
		// one angle of 90 degrees
		if ((getAngle(this.getV1(), this.getV2(), this.getV3()) == 90)
				|| (getAngle(this.getV2(), this.getV3(), this.getV1()) == 90)
				|| (getAngle(this.getV3(), this.getV1(), this.getV2()) == 90))
			return true;
		else
			return false;
	}

	private boolean isEquilateralTriangle() {
		// 3 equal sides & 3 equal angles
		if ((getAngle(this.getV1(), this.getV2(), this.getV3()) == 60)
				&& (getAngle(this.getV2(), this.getV3(), this.getV1()) == 60)
				&& (getAngle(this.getV3(), this.getV1(), this.getV2()) == 60)
				&& (getLength(this.getV1(), this.getV2()) == getLength(this.getV2(), this.getV3()))
				&& (getLength(this.getV2(), this.getV3()) == getLength(this.getV3(), this.getV1())))
			return true;
		else
			return false;
	}

	private boolean isAcuteTriangle() {
		// 3 angles all less than 90 degrees
		if ((getAngle(this.getV1(), this.getV2(), this.getV3()) < 90)
				&& (getAngle(this.getV2(), this.getV3(), this.getV1()) < 90)
				&& (getAngle(this.getV3(), this.getV1(), this.getV2()) < 90))
			return true;
		else
			return false;
	}
}
