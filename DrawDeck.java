import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class DrawDeck {
    //deck has all number cards (including ace) and only 4 randomly chosen face cards
    ArrayList<Card> deck = new ArrayList<>();

    public DrawDeck() {
        //chooses 4 random face cards
        for (int i = 0; i <4; i++) {
            Random random = new Random();
            int rand_face = random.nextInt(3);
            switch (rand_face) {
                case 0: deck.add(new Card(11));
                case 1: deck.add(new Card(12));
                case 2: deck.add(new Card(13));
            }
        }

        //adds every number card to the deck
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 4; j++) {
                deck.add(new Card(i));
            }
        }

        Collections.shuffle(deck);
    }

    //gets last card and then removes it from the draw deck
    public Card draw() {
        Card last_card = (Card)deck.get(deck.size() - 1);
        deck.remove(deck.size() - 1);

        return last_card;
    }

    public int getSize() { return deck.size(); }
}
