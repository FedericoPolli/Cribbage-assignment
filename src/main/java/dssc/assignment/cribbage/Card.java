package dssc.assignment.cribbage;

public class Card {

    private String CardRank;
    private Suite CardSuite;
    private int CardValue;

    public Card(String CardRank, Suite CardSuite) {
        this.CardRank = CardRank;
        this.CardSuite = CardSuite;

        if (CardRank.equals("A")) {
            CardValue = 1;
        }
        else if (this.CardIsPicture()) {
            CardValue = 10;
        }
        else {
            try
            {
                CardValue = Integer.parseInt(CardRank);
            }

            catch (NumberFormatException e)
            {
                System.out.println("Unknown card value");
                CardValue = 0;
            }
        }
    }

    private boolean CardIsPicture() { return (CardRank.equals("J") || CardRank.equals("Q") || CardRank.equals("K")); }

    public String rank() { return CardRank; }

    public Suite suite() { return CardSuite; }

    public int value() {return CardValue;}
}
