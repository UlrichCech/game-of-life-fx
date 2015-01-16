package de.sofiworx.gameoflife;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Test cases for @{@link Cell}.
 *
 * @author Ulrich Cech
 */
public class CellTest {

    @Test
    public void testCellInstantiation() {
        Cell cell = new Cell(null, 1, 1);
        assertThat(cell.isAlive(), is(false));
        assertThat(cell.getX(), is(1));
        assertThat(cell.getY(), is(1));
        try {
            new Cell(null, -1, 0);
            fail("negative x-parameter not recognized.");
        } catch (RuntimeException rt) {}
        try {
            new Cell(null, 0, -1);
            fail("negative y-parameter not recognized.");
        } catch (RuntimeException rt) {}
        cell = new Cell(null, 1, 1, true);
        assertThat(cell.isAlive(), is(true));
    }

    @Test
    public void testGetGeneration() {
        Cell cell = new Cell(null, 1, 1);
        assertThat(cell.getGeneration(), is(0));
        cell.progressGeneration();
        assertThat(cell.getGeneration(), is(1));
    }

    @Test
    public void testCalculateAmountAliveNeighbors() {
        Grid grid = new Grid(3, 3);
        grid.initialize(new boolean[] {false, false, false},
                new boolean[]{false, true, false},
                new boolean[]{false, false, true});
        Cell cell = grid.getCell(1, 1);
        assertThat(cell.calculateAmountAliveNeighbors(), is(1));

        grid.initialize(new boolean[] {false, false, false},
                new boolean[]{true, true, false},
                new boolean[]{false, true, true});
        assertThat(cell.calculateAmountAliveNeighbors(), is(3));
    }

    @Test
    public void testCalculateNextGeneration() {
        Grid grid = new Grid(3, 3);
        grid.initialize(new boolean[] {false, false, false},
                new boolean[]{false, true, false},
                new boolean[]{false, false, true});
        Cell cell = new Cell(grid, 1, 1);
        cell.calculateNextGeneration();
        assertThat(cell.isNextAlive(), is(false));

        grid.initialize(new boolean[] {false, false, false},
                new boolean[]{true, true, false},
                new boolean[]{false, true, true});
        cell = new Cell(grid, 1, 1);
        cell.calculateNextGeneration();
        assertThat(cell.isNextAlive(), is(true));

        grid.initialize(new boolean[] {true, true, true},
                new boolean[]{true, true, true},
                new boolean[]{true, true, true});
        cell = new Cell(grid, 1, 1);
        cell.calculateNextGeneration();
        assertThat(cell.isNextAlive(), is(false));

        grid.initialize(new boolean[] {false, false, false},
                new boolean[]{true, false, false},
                new boolean[]{false, true, true});
        cell = new Cell(grid, 1, 1);
        cell.calculateNextGeneration();
        assertThat(cell.isNextAlive(), is(true));
    }
}
