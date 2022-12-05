import java.util.Scanner;

public class Jeff {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        DrawDeck deck = new DrawDeck();

        //draw 4
        for (int i = 0; i < 4; i++) {
            player1.addToHand(deck.draw());
            player2.addToHand((deck.draw()));
        }

        System.out.println(player1.getHand());
        System.out.println(player2.getHand());
        System.out.println("");

        //PLAYER 1 choose opponents 2 cards
        Scanner getChoice = new Scanner(System.in);

        System.out.println("HIDE CARDS PHASE");
        System.out.println("Player 1, please choose first card to hide (1, 2, 3, 4)");
        int firstHidden1 = getChoice.nextInt();

        System.out.println("Please choose second card to hide (1, 2, 3, 4)");
        int secondHidden1 = getChoice.nextInt();

        player2.getHiddenHand(firstHidden1, secondHidden1);

        //PLAYER 2 choose opponents 2 cards
        System.out.println("Player 2, please choose first card to hide (1, 2, 3, 4)");
        int firstHidden2 = getChoice.nextInt();

        System.out.println("Please choose second card to hide (1, 2, 3, 4)");
        int secondHidden2 = getChoice.nextInt();

        player1.getHiddenHand(firstHidden2, secondHidden2);


        while (deck.getSize() > 0) {

            //battle phase
            System.out.println("BATTLE PHASE");
            System.out.println("Player 1, choose a card to play (1, 2, 3, 4)");
            player1.getHiddenHand(firstHidden2, secondHidden2);
            int cardChoice1 = getChoice.nextInt();

            System.out.println("Player 2, choose a card to play (1, 2, 3, 4)");
            player2.getHiddenHand(firstHidden1, secondHidden1);
            int cardChoice2 = getChoice.nextInt();

            //compare cards, see which one wins
            Card p1BattleCard = (Card) player1.getHand().get(cardChoice2 - 1);
            player1.removeFromHand((Card) player1.getHand().get(cardChoice2 - 1));

            Card p2BattleCard = (Card) player2.getHand().get(cardChoice1 - 1);
            player2.removeFromHand((Card) player2.getHand().get(cardChoice1 - 1));

            //add cards to bank
            if (p1BattleCard.getPoint_value() >= p2BattleCard.getPoint_value()) {
                System.out.println("Player One Wins!!");
                player1.addToBank(p2BattleCard);
            } else {
                System.out.println("Player Two Wins!!");
                player2.addToBank(p1BattleCard);
            }

            //draw if not enough cards
            if (player1.getHand().size() == 0) {
                for (int i = 0; i < 4; i++) {
                    if (deck.getSize() > 0) {
                        player1.addToHand(deck.draw());
                    } else {
                        break;
                    }
                }
            }

        }
        //repeat until deck is finished

        //count points in bank and declare winner
        double score1 = player1.getScore();
        double score2 = player2.getScore();
    }
}


