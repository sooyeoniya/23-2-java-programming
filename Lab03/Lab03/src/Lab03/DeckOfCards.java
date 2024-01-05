package Lab03;

import java.util.Arrays;

public class DeckOfCards {
	public boolean hasPair(Card[] hand) {
		// Returns true if two cards with the same face exist
		for (int i = 0; i < hand.length - 1; i++)
			for (int j = i + 1; j < hand.length; j++)
				if (hand[i].getFace() == hand[j].getFace())
					return true;
		return false;
	}

	public boolean hasTwoPairs(Card[] hand) {
		// Returns true if two pairs of cards with the same face exist
		int count = 0;
		for (int i = 0; i < hand.length - 1; i++)
			for (int j = i + 1; j < hand.length; j++)
				if (hand[i].getFace() == hand[j].getFace()) {
					count++;
					if (count == 2) return true;
				}
		return false;
	}

	public boolean hasThreeOfAKind(Card[] hand) {
		// Return true if three identical face cards exist
		for (int i = 0; i < hand.length; i++) {
			int count = 0;
			for (int j = 0; j < hand.length; j++)
				if (hand[i].getFace() == hand[j].getFace()) count++;
			if (count == 3) return true;
		}
		return false;
	}

	public boolean hasFourOfAKind(Card[] hand) {
		//Return true if four identical face cards exist
		for (int i = 0; i < hand.length; i++) {
			int count = 0;
			for (int j = 0; j < hand.length; j++)
				if (hand[i].getFace() == hand[j].getFace()) count++;
			if (count == 4) return true;
		}
		return false;
	}

	public boolean hasFlush(Card[] hand) {
		// Return true if all cards in your hand are in the same suit
		Card.Suit suit = hand[0].getSuit(); // Based on the first suit
		for (int i = 1; i < hand.length; i++)
			if (hand[i].getSuit() != suit) return false;
		return true;
	}

	public boolean hasStraight(Card[] hand) {
		// Sort cards by face
		Card[] sortedHand = Arrays.copyOf(hand, hand.length);
		sortCardsByFace(sortedHand);
		sortCardsByFace(hand);
		
		// Return true if you have five successive faces on your hand
		for (int i = 0; i < hand.length - 1; i++)
			if (hand[i].getFace().ordinal() != hand[i + 1].getFace().ordinal() - 1)
				return false;
		return true;
	}

	public boolean hasFullHouse(Card[] hand) {
		// Return true if full house(i.e., two cards of one face value and three cards of another face value)
		boolean hasThree = false;
		boolean hasTwo = false;
		
		for (int i = 0; i < hand.length; i++) {
			int count = 0;
			for (int j = 0; j < hand.length; j++)
				if (hand[i].getFace() == hand[j].getFace())count++;
			if (count == 3) hasThree = true;
			else if (count == 2) hasTwo = true;
		}
		return hasThree && hasTwo;
	}

	private void sortCardsByFace(Card[] hand) {
		// Method that sort by face
		for (int i = 0; i < hand.length - 1; i++) {
			for (int j = 0; j < hand.length - i - 1; j++) {
				if (hand[j].getFace().ordinal() > hand[j + 1].getFace().ordinal()) {
					Card temp = hand[j];
					hand[j] = hand[j + 1];
					hand[j + 1] = temp;
				}
			}
		}
	}
}
