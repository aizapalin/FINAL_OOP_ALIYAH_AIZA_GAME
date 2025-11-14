import java.util.Random;
import java.util.Scanner;

// RockPaperScissors.java — Subclass demonstrating overriding
public class RockPaperScissors extends GameBase {
    private Scoreboard scoreboard = new Scoreboard();
    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();

    // Overridden checkWinner method (polymorphism demonstration)
    @Override
    public String checkWinner(String playerChoice, String computerChoice) {
        // Simply call parent method to keep output format exactly the same
        return super.checkWinner(playerChoice, computerChoice);
    }

    // Main menu loop
    public void startGame() {
        while (true) {
            System.out.println("======================================");
            System.out.println("---- Rock Paper Scissors Game ----");
            System.out.println("======================================");
            System.out.println("1. Play Game");
            System.out.println("2. History");
            System.out.println("3. Exit");
            System.out.println("======================================");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1": play(); break;
                case "2": viewPlayerHistoryById(); break;
                case "3":
                    System.out.println("Goodbye! Thanks for playing!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }
    }

    // View history
    private void viewPlayerHistoryById() {
        System.out.print("\nEnter your Player ID (e.g., B01): ");
        String playerId = sc.nextLine().trim();
        scoreboard.searchPlayer(playerId);
    }

    // Play rounds
    private void play() {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        Player player = new Player(name);

        int rounds = 0;
        while (true) {
            System.out.print("How many rounds do you want to play? ");
            String input = sc.nextLine();
            try {
                rounds = Integer.parseInt(input);
                if (rounds <= 0) { 
                    System.out.println("Please enter a positive number."); 
                    continue; 
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Please enter a valid number.\n");
            }
        }

        System.out.println("\nWelcome, " + player.getName() + "! Your Player ID is " + player.getId());
        System.out.println("Type 'exit' anytime to stop the game.\n");

        for (int r = 1; r <= rounds; r++) {
            System.out.println("ROUND " + r);
            System.out.print("Choose [Rock / Paper / Scissors] : ");
            String playerChoice = sc.nextLine().trim();

            if (playerChoice.equalsIgnoreCase("exit")) {
                System.out.println("You exited early. Returning to main menu.\n");
                break;
            }

            if (!playerChoice.equalsIgnoreCase("Rock") &&
                !playerChoice.equalsIgnoreCase("Paper") &&
                !playerChoice.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid choice! Please enter Rock, Paper, or Scissors.\n");
                r--;
                continue;
            }

            String compChoice = cutiesChoice();
            System.out.println("Computer choice: " + compChoice);

            String result = checkWinner(playerChoice, compChoice);
            player.recordResult(r, playerChoice, compChoice, result);

            // Display messages exactly like original
            switch (result) {
                case "Player":
                    String[] winMsgs = {
                        "Nice one! You won this round!",
                        "That was smooth~~~ you beat the cutie coders!",
                        "VICTORYYYYY!",
                        "You're on fire! Well played!"
                    };
                    System.out.println(winMsgs[random.nextInt(winMsgs.length)]);
                    break;
                case "Computer":
                    String[] loseMsgs = {
                        "OH! Better luck next time!",
                        "The cuties strikes back!",
                        "You lost this round, but keep going!"
                    };
                    System.out.println(loseMsgs[random.nextInt(loseMsgs.length)]);
                    break;
                case "Draw":
                    String[] drawMsgs = {
                        "It’s a tie! Great minds think alike.",
                        "Same choice like TWINS!"
                    };
                    System.out.println(drawMsgs[random.nextInt(drawMsgs.length)]);
                    break;
            }

            System.out.println("Current Score: " + player.getWins() + "/" + r + "\n");
        }

        System.out.println("Game Over, " + player.getName() + "! Final Score: " +
                player.getWins() + "/" + rounds);

        scoreboard.addPlayer(player);
    }
}
