
public class Lab05Test {

	public static void main(String[] args) {
		// useShape();
		// useMovable();
		useCircle();
	}

	public static void useShape() {
		// The four points
		Point v1 = new Point(0, 0);
		Point v2 = new Point(1, 1);
		Point v3 = new Point(2, 0);
		Point v4 = new Point(1, -1);

		// Line
		System.out.println("[Line]");
		Line l1 = new Line(v1, v2);
		System.out.println("1. " + l1);
		System.out.println("Gradient: " + l1.getGradient());
		System.out.println("Center: " + l1.getCenter());
		System.out.println();

		Line l2 = new Line(new Point(3, 3), new Point(1, 5));
		Point intersection1 = l1.intersectAt(l2);
		System.out.println("2. " + l2);

		if (intersection1 != null)
			System.out.println("Intersection between Line 1 and Line 2: " + intersection1);
		else
			System.out.println("Line 1 and Line 2 are parallel.");
		System.out.println();

		Line l3 = new Line(new Point(3, 3), new Point(4, 4));
		Point intersection2 = l1.intersectAt(l3);
		System.out.println("3. " + l3);

		if (intersection2 != null)
			System.out.println("Intersection between Line 1 and Line 3: " + intersection2);
		else
			System.out.println("Line 1 and Line 3 are parallel.");
		System.out.println();

		// Triangle
		System.out.println("[Triangle]");
		Triangle t1 = new Triangle(v1, v2, v3);
		System.out.println(t1);
		System.out.println("Type: " + t1.getType());
		System.out.println("Perimeter: " + t1.getPerimeter());
		System.out.println("Area: " + t1.getArea());
		System.out.println("Center: " + t1.getCenter());
		System.out.println();

		// Quadrilateral
		System.out.println("[Quadrilateral]");
		Quadrilateral q1 = new Quadrilateral(v1, v2, v3, v4);
		System.out.println(q1);
		System.out.println("Type: " + q1.getType());
		System.out.println("Perimeter: " + q1.getPerimeter());
		System.out.println("Area: " + q1.getArea());
		System.out.println("Center: " + q1.getCenter());
		System.out.println();

		// Distance between two points
		System.out.println("[Distance between two points]");
		System.out.println("v1 and v2 = " + v1.distance(v2));
		System.out.println("Line 1's v2 and Line 2's v2 = " + l1.distance(l2));
	}

	public static void useMovable() {
		MovablePoint p1 = new MovablePoint(1, 2, 1, 1);
		System.out.println(p1);
		p1.moveDown();
		System.out.println(p1);
		p1.moveRight();
		System.out.println(p1);
		System.out.println("========================");
	
		// Test Polymorphism
		Movable p2 = new MovablePoint(3, 4, 1, 1); // upcast
		System.out.println(p2);
		p2.moveUp();
		System.out.println(p2);
		MovablePoint p3 = (MovablePoint) p2; // downcast
		System.out.println("downcast!");
		System.out.println(p3);
		System.out.println("========================");
		
		Movable m2 = new MovableCircle(1, 2, 3, 4, 20);  // upcast
		System.out.println(m2);
		m2.moveRight();
		System.out.println(m2);
		m2.moveUp();
		System.out.println(m2);
	}
	
	public static void useCircle() {
		Circle c1 = new Circle(4);
		System.out.println(c1);
		System.out.println("Perimeter: " + c1.getPerimeter());
		System.out.println("Area: " + c1.getArea());
		System.out.println();
		
		Circle c2 = new ResizableCircle(8); // upcast
		System.out.println(c2);
		System.out.println("Perimeter: " + c2.getPerimeter());
		System.out.println("Area: " + c2.getArea());
		System.out.println();
		
		System.out.println("downcast!");
		ResizableCircle c3 = (ResizableCircle) c2; // downcast
		System.out.println(c3);
		System.out.println("Resize!");
		c3.resize(40);
		System.out.println(c3);
		System.out.println();
	}
}
