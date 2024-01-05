package Lab03;

public class Card2 {

	private final String face; // face of card ("Ace", "Deuce", ...)
	private final String suit; // suit of card ("Hearts", "Diamonds", ...)

	// two-argument constructor initializes card's face and suit
	public Card2(String face, String suit) {
		this.face = face;
		this.suit = suit;
	}

	// return String representation of Card
	public String toString() {
		return face + " of " + suit;
	}

	public String getFace() {
		return face;
	}

	public String getSuit() {
		return suit;
	}
	
	public int getFaceAsInt() {
        // Map face values to integers
        switch (face) {
            case "Ace":
                return 1;
            case "Deuce":
                return 2;
            case "Three":
                return 3;
            case "Four":
                return 4;
            case "Five":
                return 5;
            case "Six":
                return 6;
            case "Seven":
                return 7;
            case "Eight":
                return 8;
            case "Nine":
                return 9;
            case "Ten":
                return 10;
            case "Jack":
                return 11;
            case "Queen":
                return 12;
            case "King":
                return 13;
            default:
                // Handle invalid face values
                throw new IllegalArgumentException("Invalid face value: " + face);
        }
    }
}