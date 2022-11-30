public class Card {
//Card has face value and point value
    private int card_value;
    private double point_value;

    public Card(int card_value){
        this.card_value = card_value;

        switch (card_value) {
            case 1:
                this.point_value = 30;
            case 2:
                this.point_value = -10;
            case 3:
                this.point_value = 7.4;
            case 4:
                this.point_value = 5;
            case 5:
                this.point_value = 10;
            case 6:
                this.point_value = 50;
            case 7:
                this.point_value = -11;
            case 8:
                this.point_value = 8; //***0 point value in bank***
            case 9:
                this.point_value = 20;
            case 10:
                this.point_value = 1;
            case 11:
                this.point_value = 0; //WILD card, choose another card to play with it
            case 12:
                this.point_value = 100;
            case 13:
                this.point_value = 123; //INSTANT DEATH
        }
    }

    //gets point value of card
    public double getPoint_value() {
        return point_value;
    }

    //gets card value of card
    public int getCard_value() {
        return card_value;
    }

    public String toString() {
        switch (card_value) {
            case 11: return "Jack : " + this.point_value;
            case 12: return "Queen : " + this.point_value;
            case 13: return "King : INSTANT DEATH";
            default: return card_value + " : " + this.point_value;
        }
    }
}
