package blackjack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class BlackjackController {
    private final Scanner sc = new Scanner(System.in);
    private final Deck deck = new Deck();
    private final Random rand = new Random();

    public static void main(String[] args) {
        new BlackjackController().playBlackJack();
    }

    public void playBlackJack(){
        var name = interactWithUser("What is your name?");
        var bet = interactWithUser("Do you want to bet?");
        var initialSum = bet.equals("yes") ? rand.nextInt(2,10) : 0;

        Player playerUser = new Player(name, initialSum);
        Player playerComp = new Player("computer", initialSum);
        Player[] players = {playerUser, playerComp};

        do {
            //Deal players two cards from the deck
            deal2Cards(players);
            //Take actual bets.
            takeBets(players);

            //enter play loop
            do {
                play(players);

            } while (!checkPlay(players));

            //reset hand
            Arrays.stream(players).forEach(Player::resetHand);
            //Consistently print out the current amount of money both the user and computer have after each game.
            Arrays.stream(players).forEach(System.out::println);

            //If either user runs out of money, stop the game.
        } while (!checkPots(players));

    }

    private void deal2Cards(Player... players) {
        for (int i = 0; i< 2; i++) {
            for(var player : players) {
                deck.dealCard(player);
            }
        }
    }

    private void play(Player... players){
        for (var player : players) {

            if (!player.getName().equals("computer")) {
                System.out.println(player);
                if (interactWithUser("Do you want another card?").equals("yes")) {
                    deck.dealCard(player);
                    System.out.println(player);
                } else {
                    player.setNoResponse("no");
                }
            }

            if (player.getName().equals("computer")) {
                if (player.computerAI()) {
                    deck.dealCard(player);
                    System.out.println(player.getName() + " took another card!");
                } else {
                    System.out.println(player.getName() + " did not take another card!");
                    player.setNoResponse("no");
                }
            }
        }
    }


    private boolean checkPlay(Player... players) {
        var status = false;
        var noResponse = Arrays.stream(players).allMatch(p -> p.getNoResponse().equals("no"));
        var busted = Arrays.stream(players).allMatch(p -> p.getHand().isHandAbove21());

        if (noResponse || busted) {
            for (var player: players) {
                System.out.println(player.getName() + " -> " + player.getHand().getHandValue());
            }

            if (busted) {
                System.out.println("Busted! Both lost");
            } else {
                var winner = Arrays.stream(players)
                        .filter(p -> !p.getHand().isHandAbove21())
                        .max(Comparator.comparingInt(p -> p.getHand().getHandValue()))
                        .orElseThrow();
                updatePotValues(winner, players);
                System.out.println(winner);
            }
            status = true;

        }
        return status;
    }


    private void takeBets(Player... players) {
        //calculated based on the minimum potValue available to limit player betting big against a small value.
        var minPot = Arrays.stream(players)
                .map(Player::getPotValue)
                .min(Integer::compareTo)
                .orElse(0);

        var bet = rand.nextInt(1, minPot);
        Arrays.stream(players).forEach(p -> p.setBetValue(bet));
        Arrays.stream(players).forEach(p -> System.out.println(p.getName() + ": betting -> " + p.getBetValue()));
    }

    private boolean checkPots(Player... players) {
        return Arrays.stream(players).anyMatch(p -> p.getPotValue() < 1);
    }

    private void updatePotValues(Player winner, Player... players) {
        var loser = Arrays.stream(players)
                .filter(p -> !p.equals(winner))
                .findFirst()
                .orElseThrow();

        winner.updatePotValue(loser.getBetValue());
        loser.updatePotValue(-loser.getBetValue());
    }

    private String interactWithUser(String prompt){
        System.out.println(prompt);
        var response = sc.nextLine();
        return response;
    }
}
