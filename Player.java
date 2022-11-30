import java.util.ArrayList;

public class Player {
    //player has hand of 4 Cards and Bank
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<Card> bank = new ArrayList<>();

    //default constructor
    public Player() {}

    //adds a card to the player bank
    public void addToBank(Card card) {
        bank.add(card);
    }

    //adds card to player hand
    public void addToHand(Card card) {
        //checks if max hand size is reached (4)
        if (hand.size() >= 4){
            System.out.println("Max hand size reached!");
            return;
        }
        hand.add(card);
    }

    public void removeFromHand(Card card) {
        hand.remove(card);
    }

    public ArrayList getHand() {
        return hand;
    }

    //gets players hand after the hidden cards have been chosen
    public void getHiddenHand(int firstHidden, int secondHidden) {
        System.out.println("[");
        for (int i = 0; i < 4; i++) {
            //checks if card was chosen to be hidden, and hides it if it is hidden.
            if (i == firstHidden-1 || i == secondHidden-1) { System.out.println("-"); }
            else { System.out.println(hand.get(i)); }
        }
        System.out.println("]");
    }

    //adds up score from bank to get final score
    public double getScore() {
        double score = 0.0;
        for (int i = 0; i < bank.size(); i++) {
            score += bank.get(i).getPoint_value();
        }

        return score;
    }




}
