
public class Point3D {
	private double x = 0.0;
	private double y = 0.0;
	private double z = 0.0;

	public void displayPoint() {
		System.out.println("(" + x + ", " + y + ", " + z + ")");
	}
	
	public void setCord(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getLength() {
		return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}

	public double getDistance(Point3D p) {
		return Math.sqrt(((x - p.x) * (x - p.x)) + ((y - p.y) * (y - p.y)) + ((z - p.z) * (z - p.z)));
	}

	// public double getDistance(Point3D p1, Point3D p2) {return 0.0;}

	public void translate(double a, double b, double c) {
		this.x += a;
		this.y += b;
		this.z += c;
	}
}
