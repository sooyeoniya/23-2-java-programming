
public class Lab01Test {

	public static void main(String[] args) {
		useFunctions();
		usePoint3D();
	}
	
	public static void useFunctions() {
		Functions f1 = new Functions();
		
		f1.getTriples(50);
		f1.getTriples(30);
		
		System.out.println("[Check Palindrome]");
		f1.isPalindrome(12321); // true
		f1.isPalindrome(55555); // true
		f1.isPalindrome(45554); // true
		f1.isPalindrome(11611); // true
		f1.isPalindrome(16231); // false
		f1.isPalindrome(46765); // false
		System.out.println();
		
		System.out.println("[Print Triangles]");
		f1.printTriangles(10);
		System.out.println();
	}

	public static void usePoint3D() {
		Point3D p1 = new Point3D();
		Point3D p2 = new Point3D();
		
		System.out.println("[Initial Point]");
		p1.displayPoint();
		p2.displayPoint();
		System.out.println();

		//System.out.println(p1);
		//System.out.println(p2);
		
		p1.setCord(5.7, 3.0, 8);
		p2.setCord(1.7, 1.0, 3.5);
		
		//System.out.println(p1);
		//System.out.println(p2);
		
		System.out.println("[Assigned Point]");
		p1.displayPoint();
		p2.displayPoint();
		System.out.println();

		System.out.println("[The Length Two Points]");
		System.out.println("Length of p1 Point = " + p1.getLength());
		System.out.println("Length of p2 Point = " + p2.getLength());
		System.out.println();
		
		System.out.println("[The Distance Between Two Points]");
		System.out.println("Distance between p1 and p2 = " + p1.getDistance(p2));
		System.out.println();

		System.out.println("[Translated Point]");
		p1.translate(1.5, -6.5, 7.0);
		p1.displayPoint();
		System.out.println();
	}
}
