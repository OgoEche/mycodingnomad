package blackjack;

public class Player {
    private final String name;
    private Hand hand;
    private int potValue;
    private String noResponse = "";
    private int betValue;

    public Player(String name, int potValue) {
        this.name = name;
        this.hand = new Hand();
        this.potValue = potValue;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public int getPotValue() {
        return potValue;
    }

    public void setBetValue(int betValue) {
        this.betValue = betValue;
    }

    public int getBetValue() {
        return betValue;
    }

    public void updatePotValue(int val) {
        potValue += val;
    }

    public boolean computerAI(){
        var controlValue = 16;
        return hand.getHandValue() < controlValue;
    }

    public String getNoResponse() {
        return noResponse;
    }

    public void setNoResponse(String noResponse) {
        this.noResponse = noResponse;
    }

    public void resetHand() {
        hand = new Hand();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                ", betValue=" + betValue +
                ", potValue=" + potValue +
                '}';
    }
}
