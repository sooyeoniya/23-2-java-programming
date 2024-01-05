import java.util.Random;
import java.util.Scanner;

public class Craps {
	// create secure random number generator for use in method rollDice
	private Random randomNumbers = new Random();

	// enum type with constants that represent the game status
	private enum Status {
		CONTINUE, WON, LOST
	};

	// constants that represent common rolls of the dice
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int YO_LEVEN = 11;
	private static final int BOX_CARS = 12;

	public void run() {
		int bankBalance = 1000;
		int wager;
		Scanner input = new Scanner(System.in);

		do {
			// prompt the user for a wager
			System.out.printf("Current balance is %d\n", bankBalance);
			System.out.print("Enter wager (-1 to quit): ");
			wager = input.nextInt();
			if (wager >= 0) {
				if (wager > bankBalance)
					System.out.println("You don't have enough money!");
				else {
					boolean won = play(); // play a game
					
					// If you win, add a wager
					if(won) bankBalance += wager;
					// If you lose, subtract a wager
					else bankBalance -= wager;

					if (bankBalance <= 0)
						System.out.println("Sorry. You busted!");
					else
						System.out.println(chatter());
				} // end else
					// reset the wager
				wager = 0;
				System.out.println();
			} // end if
				// terminate if the user quits or runs out of money
		} while ((wager != -1) && (bankBalance > 0));
		input.close();
	} // end method bet

	public String chatter() {
		switch (randomNumbers.nextInt(5)) {
		case 0:
			return "Aw c'mon, take a chance!";
		case 1:
			return "Oh, you're going for broke, huh?";
		case 2:
			return "You're up big. Now's the time to cash in your chips!";
		case 3:
			return "Feeling lucky today?";
		default:
			return "Let's see those dice fly!";
		}
	}

	// plays one game of craps
	public boolean play() {
		int myPoint = 0; // point if no win or loss on first roll
		Status gameStatus; // can contain CONTINUE, WON or LOST

		int sumOfDice = rollDice(); // first roll of the dice

		// determine game status and point based on first roll
		switch (sumOfDice) {
		case SEVEN: // win with 7 on first roll
		case YO_LEVEN: // win with 11 on first roll
			gameStatus = Status.WON;
			break;
		case SNAKE_EYES: // lose with 2 on first roll
		case TREY: // lose with 3 on first roll
		case BOX_CARS: // lose with 12 on first roll
			gameStatus = Status.LOST;
			break;
		default: // did not win or lose, so remember point
			gameStatus = Status.CONTINUE; // game is not over
			myPoint = sumOfDice; // remember the point
			System.out.printf("Point is %d%n", myPoint);
			break;
		}

		// while game is not complete
		while (gameStatus == Status.CONTINUE) // not WON or LOST
		{
			sumOfDice = rollDice(); // roll dice again

			// determine game status
			if (sumOfDice == myPoint) // win by making point
				gameStatus = Status.WON;
			else if (sumOfDice == SEVEN) // lose by rolling 7 before point
				gameStatus = Status.LOST;
		}

		// display won or lost message
		if (gameStatus == Status.WON)
			System.out.println("Player wins");
		else
			System.out.println("Player loses");
		return gameStatus == Status.WON;
	}

	// roll dice, calculate sum and display results
	public int rollDice() {
		// pick random die values
		int die1 = 1 + randomNumbers.nextInt(6); // first die roll
		int die2 = 1 + randomNumbers.nextInt(6); // second die roll

		int sum = die1 + die2; // sum of die values

		// display results of this roll
		System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);

		return sum;
	}
}