package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private final static char[] SUITS = {'♠', '♦', '♥', '♣'};
    private static final String[] FACES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    private final List<Card> cards;
    private final List<Integer> usedCards;

    private final Random random;

    public Deck() {
        cards = new ArrayList<>();
        usedCards = new ArrayList<>();
        populateCards();
        random = new Random();
    }

    private void populateCards() {
        for (var suit : SUITS) {
            for (var face : FACES) {
                var value = switch (face) {
                    case "A" -> 1;
                    case "J","Q","K" -> 10;
                    default -> Integer.parseInt(face);
                };
                cards.add(new Card(suit, face, value));
            }
        }
    }

    public void dealCard(Player player) {
        Card tempCard = null;
        while (true) {
            var index = random.nextInt(cards.size());
            if (!usedCards.contains(index)){
                tempCard = cards.get(index);
                usedCards.add(index);
                break;
            }
        }
        player.getHand().addCard(tempCard);

    }


}
