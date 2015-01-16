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
    private int currentGeneration;

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

    void initialize(boolean[]... rows) {
        if (rows == null || rows.length == 0) {
            initialize();
            return;
        }
        grid = new Cell[getY()][getX()];
        for (int row = 0; row < rows.length; row++) {
            grid[row] = new Cell[getY()];
            for (int col = 0; col < rows[row].length; col++) {
                grid[row][col] = new Cell(this, col, row, rows[row][col]);
            }
        }
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
                grid[row][col] = new Cell(this, col, row, random.nextBoolean());
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

    public void printGrid() {
        for (int row = 0; row < getY(); row++) {
            for (int col = 0; col < getX(); col++) {
                Cell cell = grid[row][col];
                System.out.print(cell.isAlive() ? "X " : ". ");
            }
            System.out.println();
        }
    }

    public int getCurrentGeneration() {
        return currentGeneration;
    }

    public Cell getCell(final int colIndex, final int rowIndex) {
        return grid[rowIndex][colIndex];
    }

    public void calculateNextGeneration() {
        for (int row = 0; row < getY(); row++) {
            for (int col = 0; col < getX(); col++) {
                Cell cell = grid[row][col];
                cell.calculateNextGeneration();
            }
        }
        for (int row = 0; row < getY(); row++) {
            for (int col = 0; col < getX(); col++) {
                Cell cell = grid[row][col];
                cell.progressGeneration();
            }
        }
        currentGeneration++;
    }
}
