// Game.java — Main controller demonstrating polymorphism
public class Game {
    public static void main(String[] args) {
        GameBase game = new RockPaperScissors(); // Upcasting for polymorphism
        ((RockPaperScissors) game).startGame();  // Downcast to start game
    }
}

