package Lab03;

public class Lab03Test {

	public static void main(String[] args) {
		// useTicTacToe();
		// useDeck();
		// useDeck2();
		// useCard2();
		 useRoll36();
	}

	public static void useRoll36() {
		Roll36 r = new Roll36();
		r.rollDice36();
	}

	public static void useDeck() {
		DeckOfCards deck = new DeckOfCards();
		Deck d = new Deck();

		d.printDeck();
		d.shuffle();
		
		// 5 cards out of 52 mixed cards
		System.out.println();
		Card[] hand = new Card[5];
        for (int i = 0; i < 5; i++) {
            hand[i] = d.dealCard();
            System.out.println(" " + hand[i]);
        }
		System.out.println();

		// Check 5 cards per method
		boolean hasPair = deck.hasPair(hand);
		boolean hasTwoPairs = deck.hasTwoPairs(hand);
		boolean hasThreeOfAKind = deck.hasThreeOfAKind(hand);
		boolean hasFourOfAKind = deck.hasFourOfAKind(hand);
		boolean hasFlush = deck.hasFlush(hand);
		boolean hasStraight = deck.hasStraight(hand);
		boolean hasFullHouse = deck.hasFullHouse(hand);

		System.out.println("Has Pair: " + hasPair);
		System.out.println("Has Two Pairs: " + hasTwoPairs);
		System.out.println("Has Three of a Kind: " + hasThreeOfAKind);
		System.out.println("Has Four of a Kind: " + hasFourOfAKind);
		System.out.println("Has Flush: " + hasFlush);
		System.out.println("Has Straight: " + hasStraight);
		System.out.println("Has Full House: " + hasFullHouse);
		d.printDeck();
	}

	public static void useDeck2() {
		DeckOfCards2 deck2 = new DeckOfCards2();
		Deck2 d2 = new Deck2();
		d2.printDeck();
		d2.shuffle();
		
		// 5 cards out of 52 mixed cards
		System.out.println();
		Card2[] hand = new Card2[5];
        for (int i = 0; i < 5; i++) {
            hand[i] = d2.dealCard();
            System.out.println(hand[i]);
        }
		System.out.println();

		// Check 5 cards per method
		boolean hasPair = deck2.hasPair(hand);
		boolean hasTwoPairs = deck2.hasTwoPairs(hand);
		boolean hasThreeOfAKind = deck2.hasThreeOfAKind(hand);
		boolean hasFourOfAKind = deck2.hasFourOfAKind(hand);
		boolean hasFlush = deck2.hasFlush(hand);
		boolean hasStraight = deck2.hasStraight(hand);
		boolean hasFullHouse = deck2.hasFullHouse(hand);

		System.out.println("Has Pair: " + hasPair);
		System.out.println("Has Two Pairs: " + hasTwoPairs);
		System.out.println("Has Three of a Kind: " + hasThreeOfAKind);
		System.out.println("Has Four of a Kind: " + hasFourOfAKind);
		System.out.println("Has Flush: " + hasFlush);
		System.out.println("Has Straight: " + hasStraight);
		System.out.println("Has Full House: " + hasFullHouse);
		d2.printDeck();
	}

	/*
	 * public static void useCard2() { Card2 c = new Card2("face", "suit");
	 * System.out.println(c); }
	 */

	public static void useTicTacToe() {
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.play();
	}
}