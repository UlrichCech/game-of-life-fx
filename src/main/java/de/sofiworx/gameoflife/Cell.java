package de.sofiworx.gameoflife;

/**
 * Represents a single cell on the game-grid.
 *
 * @author Ulrich Cech
 */
public class Cell {

    private boolean alive;
    private int x;
    private int y;
    private int generation;
    private boolean nextAlive;


    public Cell(final int x, final int y) {
        if (x < 0 || y < 0) {
            throw new RuntimeException("X and Y cannot be negative.");
        }
        this.x = x;
        this.y = y;
    }

    public Cell(int x, int y, boolean alive) {
        this(x, y);
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

    public void calculateNextGeneration(final Grid grid) {
        // nextAlive = ???
    }

    public void progressGeneration() {
        this.alive = nextAlive;
        generation++;
    }
}
