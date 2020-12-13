package dssc.assignment.cribbage;

public class Main {
    public static void main(String args[]) {
        if (args.length > 0) {
            try {
                CribbageHand HandOne = new CribbageHand(args[0]);
                CribbageHand HandTwo = new CribbageHand(args[1]);
                int scoreOne = new CribbageScoreCalculator(HandOne).getCribbageScore();
                int scoreTwo = new CribbageScoreCalculator(HandTwo).getCribbageScore();
                System.out.println("Score player one: " + scoreOne);
                System.out.println("Score player two: " + scoreTwo);
            } catch (IllegalArgumentException e) {
                System.err.println("There was an error with the hand. ");
                System.err.println(e);
            } catch (Exception any) {
                System.err.println("Unknown error: aborting...");
                System.err.println(any);

            }
        }
        else {
            System.out.println("Wrong input:");
            System.out.println("Two 10-character strings are needed to represent a Cribbage Hand");
        }
    }
}
