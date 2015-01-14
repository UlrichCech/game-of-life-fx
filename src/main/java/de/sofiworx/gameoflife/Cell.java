package de.sofiworx.gameoflife;

import com.sun.tools.javac.code.Type;

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

    public Cell(int x, int y) {
        if (x < 0 || y < 0) {
            throw new RuntimeException("X and Y cannot be negative.");
        }
        this.x = x;
        this.y = y;
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

    public void progressGeneration() {
        generation++;
    }
}
