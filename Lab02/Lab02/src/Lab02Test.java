
public class Lab02Test {
	public static void main(String[] args) {
		// Select the desired function
		useRational();
		useTime();
		useCraps();
	}

	public static void useRational() {
		Rational r1 = new Rational(3, 6);
		Rational r2 = new Rational(6, 5);
		Rational r3 = new Rational(44, 55);
		Rational r4 = new Rational(12, 6);
		Rational r5 = new Rational();

		System.out.println("[Rational number in the form a / b]");
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		System.out.println(r5);
		System.out.println();

		System.out.println("[Rational number in floating-point format]");
		r1.fpRepresentation();
		r2.fpRepresentation();
		r3.fpRepresentation();
		r4.fpRepresentation();
		r5.fpRepresentation();
		System.out.println();

		System.out.println("[Add two Rational numbers]");
		Rational add1 = r1.add(r2);
		System.out.print(add1 + " = ");
		add1.fpRepresentation();
		Rational add2 = r2.add(r3);
		System.out.print(add2 + " = ");
		add2.fpRepresentation();
		Rational add3 = r3.add(r4);
		System.out.print(add3 + " = ");
		add3.fpRepresentation();
		Rational add4 = r4.add(r5);
		System.out.print(add4 + " = ");
		add4.fpRepresentation();
		System.out.println();

		System.out.println("[Subtract two Rational numbers]");
		Rational sub1 = r1.sub(r2);
		System.out.print(sub1 + " = ");
		sub1.fpRepresentation();
		Rational sub2 = r2.sub(r3);
		System.out.print(sub2 + " = ");
		sub2.fpRepresentation();
		Rational sub3 = r3.sub(r4);
		System.out.print(sub3 + " = ");
		sub3.fpRepresentation();
		Rational sub4 = r4.sub(r5);
		System.out.print(sub4 + " = ");
		sub4.fpRepresentation();
		System.out.println();

		System.out.println("[Multiply two Rational numbers]");
		Rational multiply1 = r1.multiply(r2);
		System.out.print(multiply1 + " = ");
		multiply1.fpRepresentation();
		Rational multiply2 = r2.multiply(r3);
		System.out.print(multiply2 + " = ");
		multiply2.fpRepresentation();
		Rational multiply3 = r3.multiply(r4);
		System.out.print(multiply3 + " = ");
		multiply3.fpRepresentation();
		Rational multiply4 = r4.multiply(r5);
		System.out.print(multiply4 + " = ");
		multiply4.fpRepresentation();
		System.out.println();

		System.out.println("[Divide two Rational numbers]");
		Rational divide1 = r1.divide(r2);
		System.out.print(divide1 + " = ");
		divide1.fpRepresentation();
		Rational divide2 = r2.divide(r3);
		System.out.print(divide2 + " = ");
		divide2.fpRepresentation();
		Rational divide3 = r3.divide(r4);
		System.out.print(divide3 + " = ");
		divide3.fpRepresentation();
		Rational divide4 = r4.divide(r5);
		System.out.print(divide4 + " = ");
		divide4.fpRepresentation();
		System.out.println();
	}

	public static void useTime() {
		Time t1 = new Time();
		Time t2 = new Time(4);
		Time t3 = new Time(5, 8);
		Time t4 = new Time(15, 8, 45);
		Time t5 = new Time(t4);
		Time t6 = new Time(new Time(6, 7, 9));

		int numberOfSeconds = 20; // Number of seconds to output

		for (int i = 0; i < numberOfSeconds; i++) {
			if (i == 0) System.out.println("[Decrease t1 Time]");
			System.out.println(t1);
			t1.tickBack(); // Decrease by 1 second
			try {
				Thread.sleep(1000); // Waiting for 1 second for reality
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < numberOfSeconds; i++) {
			if (i == 0) System.out.println("[Increase t2 Time]");
			System.out.println(t2);
			t2.tick(); // Increase by 1 second
			try {
				Thread.sleep(1000); // Waiting for 1 second for reality
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < numberOfSeconds; i++) {
			if (i == 0) System.out.println("[Decrease t3 Time]");
			System.out.println(t3);
			t3.tickBack(); // Decrease by 1 second
			try {
				Thread.sleep(1000); // Waiting for 1 second for reality
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < numberOfSeconds; i++) {
			if (i == 0) System.out.println("[Increase t4 Time]");
			System.out.println(t4);
			t4.tick(); // Increase by 1 second
			try {
				Thread.sleep(1000); // Waiting for 1 second for reality
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < numberOfSeconds; i++) {
			if (i == 0) System.out.println("[Decrease t5 Time]");
			System.out.println(t5);
			t5.tickBack(); // Decrease by 1 second
			try {
				Thread.sleep(1000); // Waiting for 1 second for reality
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < numberOfSeconds; i++) {
			if (i == 0) System.out.println("[Increase t6 Time]");
			System.out.println(t6);
			t6.tick(); // Increase by 1 second
			try {
				Thread.sleep(1000); // Waiting for 1 second for reality
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void useCraps() {
		Craps c1 = new Craps();
		c1.run(); // with a bet
		//c1.play(); // without a bet
	}
}
