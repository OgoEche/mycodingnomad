package blackjack;

import java.util.Objects;

public class Card {

    private final char suit;
    private final String face;
    private final int cardValue;

    public Card(char suit, String face, int cardValue) {
        this.suit = suit;
        this.face = face;
        this.cardValue = cardValue;
    }

    public int getCardValue() {
        return cardValue;
    }

    @Override
    public String toString() {
        return "Card{" + suit + face + ':' + cardValue + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && Objects.equals(face, card.face);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, face);
    }
}
