package game;

public class GameResult {
    boolean isOver;
    String winner;

    // contructor name must match class name
    // it can't have return type like void
    public GameResult(boolean isOver, String winner) {
        this.isOver = isOver;
        this.winner = winner;
    }
}
