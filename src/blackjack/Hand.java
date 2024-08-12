package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards;
    private int handValue;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    public int getScore() {
        handValue = this.cards.stream().mapToInt(Card::getCardValue).sum();
        return handValue;
    }

    public boolean isHandAbove21() {
        int BLACKJACK = 21;
        return handValue > BLACKJACK;
    }

    public void addCard(Card card) {
        this.cards.add(card);
        this.getScore();
    }

    public int getHandValue() {
        return getScore();
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                ", handValue=" + handValue +
                '}';
    }
}
