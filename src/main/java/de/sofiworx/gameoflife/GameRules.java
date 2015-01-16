package de.sofiworx.gameoflife;

/**
 * Represents the rules of the game.
 *
 * @author Ulrich Cech
 */
public class GameRules {

    private static final GameRules instance = new GameRules();

    private GameRules() {}


    public static GameRules getInstance() {
        return instance;
    }


    public boolean isCellAliveInNextGeneration(final boolean currentAlive, final int amountAliveNeighbors) {
        if ((amountAliveNeighbors == 1) || (amountAliveNeighbors > 3)) {
            return false;
        } else if (amountAliveNeighbors == 3) {
            return true;
        } else {
            return currentAlive;
        }
    }
}
