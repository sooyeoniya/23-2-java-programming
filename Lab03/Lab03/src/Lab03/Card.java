package Lab03;

public class Card {

	private final Face face;
	private final Suit suit;

	public Card(Face face, Suit suit) {
		this.face = face;
		this.suit = suit;
	}

	public String toString() {
		return face + " of " + suit;
	}

	// enum은 밖에서도 삭제 가능
	enum Suit {
		DIAMONDS, CLUBS, HEARTS, SPADES
	}

	enum Face {
		DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
	}

	public Face getFace() {
		return face;
	}

	public Suit getSuit() {
		return suit;
	}
}