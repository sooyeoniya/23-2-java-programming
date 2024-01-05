
public class Lab04Test {

	public static void main(String[] args) {
		// useShape();
		useEmployee();
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
		System.out.println("Line 1's v2 and Line 2's v2 = " + l1.getV2().distance(l2.getV2()));
	}

	public static void useEmployee() {
		// Employee
		System.out.println("[Employee]");
		Employee e1 = new Employee();
		System.out.println(e1);
		System.out.println();
		System.out.println("Set employee's info!");
		e1.setfName("GILDONG");
		e1.setlName("HONG");
		e1.setSSN("2020123456");
		System.out.println(e1);
		System.out.println();
		
		// SalariedEmployee
		System.out.println("[SalariedEmployee]");
		SalariedEmployee se = new SalariedEmployee("SOOYEON", "CHOI", "2020136129", 200.00);
		System.out.println(se);
		System.out.println();
		System.out.println("Changed weekly salary!");
		se.setWeeklySalary(500.00);
		System.out.println(se);
		System.out.println("Earnings: " + se.earnings());
		System.out.println();
		
		// HourlyEmployee
		System.out.println("[HourlyEmployee]");
		HourlyEmployee he = new HourlyEmployee("SOOYEON", "CHOI", "2020136129", 9620 , 20);
		System.out.println(he);
		System.out.println("Earnings: " + he.earnings());
		System.out.println();
		System.out.println("Changed hours!");
		he.setHours(40);
		System.out.println(he);
		System.out.println("Earnings: " + he.earnings());
		System.out.println();
		
		// CommissionEmployee
		System.out.println("[CommissionEmployee]");
		CommissionEmployee ce = new CommissionEmployee("SOOYEON", "CHOI", "2020136129", 100000 , 10);
		System.out.println(ce);
		System.out.println("Earnings: " + ce.earnings());
		System.out.println();
		System.out.println("Changed grossSales and cRate!");
		ce.setGrossSales(200000);
		ce.setcRate(15);
		System.out.println(ce);
		System.out.println("Earnings: " + ce.earnings());
		System.out.println();
		
		// BasePlusCommissionEmployee
		System.out.println("[BasePlusCommissionEmployee]");
		BasePlusCommissionEmployee be = new BasePlusCommissionEmployee("SOOYEON", "CHOI", "2020136129", 100000 , 10, 300000);
		System.out.println(be);
		System.out.println("Earnings: " + be.earnings());
		System.out.println();
		System.out.println("Changed grossSales and cRate!");
		be.setGrossSales(200000);
		be.setcRate(15);
		System.out.println(be);
		System.out.println("Earnings: " + be.earnings());
		System.out.println();
		System.out.println("Changed base salary!");
		be.setBaseSalary(1000000);
		System.out.println(be);
		System.out.println("Earnings: " + be.earnings());
		System.out.println();
		
	}
}