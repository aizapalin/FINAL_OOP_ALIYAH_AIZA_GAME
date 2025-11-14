import java.util.ArrayList;
import java.util.List;

// Scoreboard.java — Tracks all players and lets you view history
public class Scoreboard {
    private List<Player> players = new ArrayList<>();

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void searchPlayer(String id) {
        Player found = null;

        for (Player p : players) {
            if (p.getId().equalsIgnoreCase(id)) {
                found = p;
                break;
            }
        }

        if (found == null) {
            System.out.println("\nNo history found for ID: " + id + "\n");
            return;
        }

        System.out.println("\n----- Player History -----");
        System.out.println("Player ID : " + found.getId());
        System.out.println("Name      : " + found.getName());
        System.out.println("Wins      : " + found.getWins());
        System.out.println("Losses    : " + found.getLosses());
        System.out.println("Draws     : " + found.getDraws());
        System.out.println();
        System.out.println("Detailed Round History:");
        System.out.println("-------------------------");

        for (String h : found.getHistory()) {
            System.out.println(h);
        }

        System.out.println("-------------------------\n");
    }
}
