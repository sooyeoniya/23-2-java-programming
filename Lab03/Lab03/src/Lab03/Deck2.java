package Lab03;

import java.util.Random;

public class Deck2 {

	private static final String[] faces = { "Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Jack", "Queen", "King" };

	private static final String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
	private static final Random randomNumbers = new Random(); // random number generator
	private static final int NUMBER_OF_CARDS = 52; // constant number of cards

	private Card2[] deck; // array of Card objects
	private int currentCard; // the index of next Card to be dealt

	// constructor fills deck of cards
	public Deck2() {
		deck = new Card2[NUMBER_OF_CARDS]; // create array of Card objects
		currentCard = 0; // initialize currentCard

		for (int count = 0; count < deck.length; count++) // populate deck with Card objects
			deck[count] = new Card2(faces[count % 13], suits[count / 13]);
	}

	// shuffle deck of cards with one-pass algorithm
	public void shuffle() {
		currentCard = 0; // reinitialize currentCard

		// for each card, pick another random card and swap them
		for (int first = 0; first < deck.length; first++) {
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			Card2 temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}

	// deal one card
	public Card2 dealCard() {
		// determine whether cards remain to be dealt
		if (currentCard < deck.length)
			return deck[currentCard++]; // return current Card in array
		else
			return null; // return null to indicate that all cards were dealt
	}

	public void printDeck() {
		for (int i = 0; i < NUMBER_OF_CARDS; i++) {
			if (i % 4 == 0)
				System.out.println();
			System.out.printf("%-20s", dealCard());
		}
		System.out.println();
	}
}