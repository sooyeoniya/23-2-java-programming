
public class Circle implements GeometricObject {
	protected double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public String toString() {
		return "Circle[raduis=" + this.radius + "]";
	}

	// Implement methods defined in the interface GeometricObject
	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}
}