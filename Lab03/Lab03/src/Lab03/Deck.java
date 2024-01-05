package Lab03;

import java.util.Random;

import Lab03.Card.Face;
import Lab03.Card.Suit;

public class Deck {
	private static final Random randomNumbers = new Random(); // random number generator
	private static final int NUMBER_OF_CARDS = 52; // constant number of cards

	private Card[] deck; // array of Card objects
	private int currentCard; // the index of next Card to be dealt

	public Deck() {
		currentCard = 0;
		deck = new Card[NUMBER_OF_CARDS];
		int i = 0;

		// The way the first conditional statement is simpler, more readable, and
		// preferred over the second conditional statement
		// Create a deck of cards by traversing all values of the Suit enumeration and
		// by traversing all values of the Face enumeration for each Suit value
		for (Suit s : Suit.values()) // array type Suit
			for (Face f : Card.Face.values())
				deck[i++] = new Card(f, s);

		// Access enumeration values for Suit and Face through the index and create a
		// card decks
		/*
		 * for (int s = 0; s < Suit.values().length; s++) // array type Suit for (int f
		 * = 0; f < Face.values().length; f++) deck[i++] = new Card(Face.values()[f],
		 * Suit.values()[s]);
		 */
	}

	public void shuffle() { // only changed type Card2 => Card
		currentCard = 0;
		// for each card, pick another random card and swap them
		for (int first = 0; first < deck.length; first++) {
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
	}

	public void printDeck() {
		for (int i = 0; i < NUMBER_OF_CARDS; i++) {
			if (i % 4 == 0)
				System.out.println();
			System.out.printf(" %-20s", dealCard());
		}
		System.out.println();
	}

	public Card dealCard() {
		// determine whether cards remain to be dealt
		System.out.printf("%2d", currentCard);
		if (currentCard < deck.length)
			return deck[currentCard++]; // return current Card in array
		else
			return null; // return null to indicate that all cards were dealt
	}
	
	/*
	 * public static void main(String[] args) { Deck deck = new Deck();
	 * deck.printDeck(); deck.shuffle(); deck.printDeck(); }
	 */

}