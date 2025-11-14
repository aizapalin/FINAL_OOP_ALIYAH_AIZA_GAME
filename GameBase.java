import java.util.Random;

// GameBase.java — Core logic superclass
public class GameBase {
    protected String[] choices = {"Rock", "Paper", "Scissors"};
    protected Random random = new Random();

    // Method for computer to pick a random choice
    public String cutiesChoice() {
        int index = random.nextInt(choices.length);
        return choices[index];
    }

    // Method to determine winner — can be overridden
    public String checkWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equalsIgnoreCase(computerChoice)) {
            return "Draw";
        } else if (
            (playerChoice.equalsIgnoreCase("Rock") && computerChoice.equalsIgnoreCase("Scissors")) ||
            (playerChoice.equalsIgnoreCase("Paper") && computerChoice.equalsIgnoreCase("Rock")) ||
            (playerChoice.equalsIgnoreCase("Scissors") && computerChoice.equalsIgnoreCase("Paper"))
        ) {
            return "Player";
        } else {
            return "Computer";
        }
    }
}
