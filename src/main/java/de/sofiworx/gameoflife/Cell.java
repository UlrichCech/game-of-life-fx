package de.sofiworx.gameoflife;

/**
 * Represents a single cell on the game-grid.
 *
 * @author Ulrich Cech
 */
public class Cell {

    private Grid grid;
    private boolean alive;
    private int x;
    private int y;
    private int generation;
    private boolean nextAlive;
    private final GameRules rules = GameRules.getInstance();


    public Cell(Grid grid, final int x, final int y) {
        if (x < 0 || y < 0) {
            throw new RuntimeException("X and Y cannot be negative.");
        }
        this.grid = grid;
        this.x = x;
        this.y = y;
    }

    public Cell(Grid grid, int x, int y, boolean alive) {
        this(grid, x, y);
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getGeneration() {
        return generation;
    }

    public void calculateNextGeneration() {
        setNextAlive(rules.isCellAliveInNextGeneration(isAlive(), calculateAmountAliveNeighbors()));
    }

    int calculateAmountAliveNeighbors() {
        int sum = 0;
        for (int row = -1; row < 2; row++) {
            int y = getY() + row;
            if ((y >= 0) && (y < grid.getDimensionY())) { // check top and bottom border
                for (int col = -1; col < 2; col++) {
                    int x = getX() + col;
                    if (x >= 0 && x < grid.getDimensionX()) { // check left and right border
                        if (!(x == getX() && (y == getY()))) {
                            sum += grid.getCell(x, y).isAlive() ? 1 : 0;
                        }
                    }
                }
            }
        }
        return sum;
    }

    public void progressGeneration() {
        this.alive = isNextAlive();
        generation++;
    }

    private void setNextAlive(final boolean nextAlive) {
        this.nextAlive = nextAlive;
    }

    public boolean isNextAlive() {
        return nextAlive;
    }
}
