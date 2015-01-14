package de.sofiworx.gameoflife;

/**
 * ${CARET}//TODO add class description here
 *
 * @author Ulrich Cech
 */
public class Grid {

    private int x;
    private int y;

    public Grid(int x, int y) {
        if (x < 0 || y < 0) {
            throw new RuntimeException("X and Y parameters cannot be negative.");
        }
        this.x = x;
        this.y = y;
    }

    public int getNumberOfCells() {
        return x * y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
