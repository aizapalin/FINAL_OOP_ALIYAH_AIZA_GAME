import java.util.ArrayList;
import java.util.List;

// Player.java — Represents a player in the game
public class Player {
    private static int nextId = 1;

    private String id;
    private String name;
    private int wins;
    private int losses;
    private int draws;
    private List<String> history;

    public Player(String name) {
        this.id = String.format("B%02d", nextId++);
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.draws = 0;
        this.history = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getWins() { return wins; }
    public int getLosses() { return losses; }
    public int getDraws() { return draws; }
    public List<String> getHistory() { return history; }

    public void recordResult(int round, String playerChoice, String computerChoice, String result) {
        String playerResult;

        if (result.equalsIgnoreCase("Player")) {
            playerResult = "Win";
            wins++;
        } else if (result.equalsIgnoreCase("Cuties") || result.equalsIgnoreCase("CUTIES")) {
            playerResult = "Lose";
            losses++;
        } else {
            playerResult = "Draw";
            draws++;
        }

        history.add("Round " + round + ": " + name + ": " + playerChoice + " | Computer: " + computerChoice + " | Result: " + playerResult);
    }

    public int getScore() { return wins; }
}
