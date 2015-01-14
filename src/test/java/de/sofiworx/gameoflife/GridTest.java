package de.sofiworx.gameoflife;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Test cases for @{@link Grid}
 *
 * @author Ulrich Cech
 */
public class GridTest {

    @Test
    public void testGridInstantiation() {
        Grid grid = new Grid(10, 10);
        assertThat(grid.getNumberOfCells(), Is.is(100));
        try {
            new Grid(-10, 10);
            fail("negative X parameter not recognized.");
        } catch (RuntimeException rt) {}
        try {
            new Grid(10, -10);
            fail("negative X parameter not recognized.");
        } catch (RuntimeException rt) {}
    }

    @Test
    public void testInitializeGrid() {
        Grid grid = new Grid(10, 10);
        grid.initialize();
        assertThat(grid.isInitialized(), Is.is(true));
    }

    @Test
    public void testPrepareGeneration0() {
        Grid grid = new Grid(10, 10);
        grid.prepareGeneration0();
        assertThat(grid.getNumberOfCellsAlive(), greaterThan(0));
        assertThat(grid.getNumberOfCellsDead(), greaterThan(0));
    }

    @Test
    public void testPrintGrid() {
        Grid grid = new Grid(5, 5);
        grid.prepareGeneration0();
        grid.printGrid();
    }

    @Test
    public void testCalculateNextGeneration() {
        Grid grid = new Grid(5, 5);
        grid.prepareGeneration0();
        int currentGeneration = grid.getCurrentGeneration();
        assertThat(currentGeneration, is(0));
    }
}
