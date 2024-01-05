package Lab03;

import java.util.Arrays;

public class DeckOfCards2 {
    public boolean hasPair(Card2[] hand) {
        // Returns true if two cards with the same face exist
        for (int i = 0; i < hand.length - 1; i++)
            for (int j = i + 1; j < hand.length; j++)
                if (hand[i].getFace().equals(hand[j].getFace()))
                    return true;
        return false;
    }

    public boolean hasTwoPairs(Card2[] hand) {
        // Returns true if two pairs of cards with the same face exist
        int count = 0;
        for (int i = 0; i < hand.length - 1; i++)
            for (int j = i + 1; j < hand.length; j++)
                if (hand[i].getFace().equals(hand[j].getFace())) {
                    count++;
                    if (count == 2)
                        return true;
                }
        return false;
    }

    public boolean hasThreeOfAKind(Card2[] hand) {
        // Return true if three identical face cards exist
        for (int i = 0; i < hand.length; i++) {
            int count = 0;
            for (int j = 0; j < hand.length; j++)
                if (hand[i].getFace().equals(hand[j].getFace()))
                    count++;
            if (count == 3)
                return true;
        }
        return false;
    }

    public boolean hasFourOfAKind(Card2[] hand) {
        // Return true if four identical face cards exist
        for (int i = 0; i < hand.length; i++) {
            int count = 0;
            for (int j = 0; j < hand.length; j++)
                if (hand[i].getFace().equals(hand[j].getFace()))
                    count++;
            if (count == 4)
                return true;
        }
        return false;
    }

    public boolean hasFlush(Card2[] hand) {
        // Return true if all cards in your hand are in the same suit
        String suit = hand[0].getSuit(); // Based on the first suit
        for (int i = 1; i < hand.length; i++)
            if (!hand[i].getSuit().equals(suit))
                return false;
        return true;
    }

    public boolean hasStraight(Card2[] hand) {
        // Sort cards by face
        Card2[] sortedHand = Arrays.copyOf(hand, hand.length);
        sortCardsByFace(sortedHand);
        sortCardsByFace(hand);

        // Return true if you have five successive faces on your hand
        for (int i = 0; i < hand.length - 1; i++)
            if (hand[i].getFaceAsInt() != hand[i + 1].getFaceAsInt() - 1)
                return false;
        return true;
    }

    public boolean hasFullHouse(Card2[] hand) {
        // Return true if a full house (i.e., two cards of one face value and three cards of another face value) exists
        boolean hasThree = false;
        boolean hasTwo = false;

        for (int i = 0; i < hand.length; i++) {
            int count = 0;
            for (int j = 0; j < hand.length; j++)
                if (hand[i].getFace().equals(hand[j].getFace()))
                    count++;
            if (count == 3)
                hasThree = true;
            else if (count == 2)
                hasTwo = true;
        }
        return hasThree && hasTwo;
    }

    private void sortCardsByFace(Card2[] hand) {
        // Method that sorts by face
        Arrays.sort(hand, (a, b) -> a.getFaceAsInt() - b.getFaceAsInt());
    }
}
