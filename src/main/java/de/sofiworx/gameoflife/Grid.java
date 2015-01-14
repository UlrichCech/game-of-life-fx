package de.sofiworx.gameoflife;

import java.util.Random;

/**
 * Represents the game-field.
 *
 * @author Ulrich Cech
 */
public class Grid {

    private int x;
    private int y;
    private Cell[][] grid;
    private boolean initialized;

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

    public void initialize() {
        grid = new Cell[getY()][getX()];
        initialized = true;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void prepareGeneration0() {
        if (!isInitialized()) {
            initialize();
        }
        Random random = new Random();
        for (int row = 0; row < getY(); row++) {
            for (int col = 0; col < getX(); col++) {
                grid[row][col] = new Cell(col, row, random.nextBoolean());
            }
        }
    }

    public int getNumberOfCellsAlive() {
        int sum = 0;
        for (int row = 0; row < getY(); row++) {
            for (int col = 0; col < getX(); col++) {
                Cell cell = grid[row][col];
                sum += cell.isAlive() ? 1 : 0;
            }
        }
        return sum;
    }

    public int getNumberOfCellsDead() {
        int sum = 0;
        for (int row = 0; row < getY(); row++) {
            for (int col = 0; col < getX(); col++) {
                Cell cell = grid[row][col];
                sum += cell.isAlive() ? 0 : 1;
            }
        }
        return sum;
    }
}
