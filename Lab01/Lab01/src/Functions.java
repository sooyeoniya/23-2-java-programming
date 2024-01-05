import java.util.stream.IntStream;

public class Functions {
	public void getTriples(int bound) {
		System.out.println("[Pythagorean Triples: below " + bound + "]");
		IntStream.range(1, bound + 1).forEach(side1 -> IntStream.range(side1, bound + 1)
				.forEach(side2 -> IntStream.range(1, bound + 1).forEach(hypotenuse -> {
					if (side1 * side1 + side2 * side2 == hypotenuse * hypotenuse)
						System.out.printf("(%02d, %02d, %02d)%n", side1, side2, hypotenuse);
				})));
		System.out.println();
	}

	public boolean isPalindrome(int input) {
		String strNum = Integer.toString(input);
		for (int i = 0; i < strNum.length(); i++) {
			if (strNum.charAt(i) != strNum.charAt(strNum.length() - i - 1)) {
				System.out.println(strNum + " : false");
				return false;
			}
		}
		System.out.println(strNum + " : true");
		return true;
	}

	public void printTriangles(int size) {
		System.out.println("(a)");
		for (int i = 1; i <= size; i++) {
			for (int j = 0; j < i; j++)
				System.out.print("*");
			System.out.println();
		}

		System.out.println("(b)");
		for (int i = size; i >= 1; i--) {
			for (int j = 0; j < i; j++)
				System.out.print("*");
			System.out.println();
		}

		System.out.println("(c)");
		for (int i = size; i >= 1; i--) {
			for (int k = 0; k < size - i; k++)
				System.out.print(" ");
			for (int j = 0; j < i; j++)
				System.out.print("*");
			System.out.println();
		}

		System.out.println("(d)");
		for (int i = 1; i <= size; i++) {
			for (int k = size - i; k >= 1; k--)
				System.out.print(" ");
			for (int j = 0; j < i; j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
