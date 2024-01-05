package Lab03;

import java.util.Random;

public class Roll36 {
	// Create an instance of Random Class
	private Random randomNumbers = new Random(); 
	// Create an array to store the sum of the two values from the two dies
	private int[] totals = new int[13];

	public void rollDice36() {
		// Initialize values for all arrays to zero
		for (int i = 0; i < totals.length; i++)
			totals[i] = 0;
		// Create an array to store the sum of the two values from the two dies
		for (int roll = 1; roll < 36000000; roll++) {
			totals[roll2()]++;
		}
		for (int k = 2; k < totals.length; k++) {
			System.out.printf("%3d, %10d, %.2f%% \n", k, totals[k], ((double)totals[k] / 36000000) * 100);
		}
	}

	public int roll2() {
		// Output random dies' value
		int die1 = 1 + randomNumbers.nextInt(6); // The first die
		int die2 = 1 + randomNumbers.nextInt(6); // The second die

		int sum = die1 + die2; // The sum of the two values

		// Show die1, die2, sum of the dies
		//System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);

		return sum;
	}
}