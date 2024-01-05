
public class Quadrilateral extends Shape {

	public Quadrilateral(Point v1, Point v2, Point v3, Point v4) {
		super(v1, v2, v3, v4);
	}

	@Override
	public String toString() {
		return "Quadrilateral [v1 = " + this.getV1() + ", v2 = " + this.getV2() + ", v3 = " + this.getV3() + ", v4 = "
				+ this.getV4() + "]";
	}
	@Override
	public String getType() {
		// output the type of a quadrilateral
		if (isRectangle())
			return "It is a rectangle.";
		else if (isSquare())
			return "It is a square.";
		else if (isRhombus())
			return "It is a rhombus.";
		else if (isTrapezoid())
			return "It is a trapezium.";
		else if (isParallelogram())
			return "It is a parallelogram.";
		else
			return "Nothing.";
	}
	@Override
	public double getPerimeter() {
		// get the perimeter of a quadrilateral
		double a = getLength(this.getV1(), this.getV2());
		double b = getLength(this.getV2(), this.getV3());
		double c = getLength(this.getV3(), this.getV4());
		double d = getLength(this.getV4(), this.getV1());
		return a + b + c + d;
	}
	@Override
	public double getArea() {
		double a = getLength(this.getV1(), this.getV2());
		double b = getLength(this.getV2(), this.getV3());
		double c = getLength(this.getV3(), this.getV4());
		double d = getLength(this.getV4(), this.getV1());
		// Bretschneider's formula
		double s = (a + b + c + d) / 2.0;
		double theta = getAngle(this.getV1(), this.getV2(), this.getV3())
				+ getAngle(this.getV1(), this.getV4(), this.getV3());
		return Math.sqrt((s - a) * (s - b) * (s - c) * (s - d) - ((a * b * c * d) * Math.pow(Math.cos(theta / 2), 2)));
	}
	@Override
	public Point getCenter() {
		// get the center of a quadrilateral
		double centerX = (this.getV1().getX() + this.getV2().getX() + this.getV3().getX() + this.getV4().getX()) / 4;
		double centerY = (this.getV1().getY() + this.getV2().getY() + this.getV3().getY() + this.getV4().getY()) / 4;
		return new Point(centerX, centerY);
	}

	private boolean isRectangle() {
		// opposite sides equal and parallel, 4 right angles
		if (isParallel(this.getV1(), this.getV2(), this.getV3(), this.getV4()) == true
				&& isParallel(this.getV1(), this.getV4(), this.getV3(), this.getV2()) == true
				&& (getAngle(this.getV1(), this.getV2(), this.getV3()) == 90)
				&& (getAngle(this.getV2(), this.getV3(), this.getV4()) == 90)
				&& (getAngle(this.getV3(), this.getV4(), this.getV1()) == 90)
				&& (getAngle(this.getV4(), this.getV1(), this.getV2()) == 90)
				&& (getLength(this.getV1(), this.getV2()) == getLength(this.getV3(), this.getV4()))
				&& (getLength(this.getV2(), this.getV3()) == getLength(this.getV4(), this.getV1())))
			return true;
		else
			return false;
	}

	private boolean isSquare() {
		// 4 equal sides, 4 right angles, opposite sides parallel
		if (isRectangle() == true && (getLength(this.getV1(), this.getV2()) == getLength(this.getV2(), this.getV3()))
				&& (getLength(this.getV3(), this.getV4()) == getLength(this.getV4(), this.getV1())))
			return true;
		else
			return false;
	}

	private boolean isTrapezoid() {
		// one pair of parallel sides
		if (isParallel(this.getV1(), this.getV2(), this.getV3(), this.getV4()) == true
				|| isParallel(this.getV1(), this.getV4(), this.getV3(), this.getV2()) == true)
			return true;
		else
			return false;
	}

	private boolean isParallelogram() {
		// opposite sides equal and parallel, opposite angles equal
		if (isTrapezoid() == true 
				&& (getLength(this.getV1(), this.getV2()) == getLength(this.getV3(), this.getV4()))
				&& (getLength(this.getV2(), this.getV3()) == getLength(this.getV4(), this.getV1())))
			return true;
		else
			return false;
	}

	private boolean isRhombus() {
		// 4 equal sides, opposite sides parallel, opposite angles equal
		if (isParallelogram() == true
				&& (getLength(this.getV1(), this.getV2()) == getLength(this.getV2(), this.getV3()))
				&& (getLength(this.getV3(), this.getV4()) == getLength(this.getV4(), this.getV1())))
			return true;
		else
			return false;
	}
}
