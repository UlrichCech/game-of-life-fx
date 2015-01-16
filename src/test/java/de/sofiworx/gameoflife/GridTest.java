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

        grid = new Grid(3, 3);
        grid.initialize(null);
        assertThat(grid.getCell(0, 0), nullValue());

        grid.initialize(new boolean[]{false, false, false},
                new boolean[]{false, true, false},
                new boolean[]{false, false, true});
        assertThat(grid.getCell(0, 0).isAlive(), is(false));
        assertThat(grid.getCell(1, 0).isAlive(), is(false));
        assertThat(grid.getCell(2, 0).isAlive(), is(false));
        assertThat(grid.getCell(0, 1).isAlive(), is(false));
        assertThat(grid.getCell(1, 1).isAlive(), is(true));
        assertThat(grid.getCell(2, 1).isAlive(), is(false));
        assertThat(grid.getCell(0, 2).isAlive(), is(false));
        assertThat(grid.getCell(1, 2).isAlive(), is(false));
        assertThat(grid.getCell(2, 2).isAlive(), is(true));
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
    public void testGetCurrentGeneration() {
        Grid grid = new Grid(5, 5);
        grid.prepareGeneration0();
        int currentGeneration = grid.getCurrentGeneration();
        assertThat(currentGeneration, is(0));
    }


    @Test
    public void testCalculateNextGeneration() {
        Grid grid = new Grid(5, 5);
        grid.prepareGeneration0();
        int generation0 = grid.getCurrentGeneration();
        grid.calculateNextGeneration();
        assertThat(grid.getCurrentGeneration(), is(generation0 + 1));
    }

    @Test
    public void testGetCell() {
        Grid grid = new Grid(5, 5);
        grid.prepareGeneration0();
        Cell cell = grid.getCell(1, 1);
        assertThat(cell.getGeneration(), is(0));
    }

    @Test
    public void testPrintTwoGenerations() {
        Grid grid = new Grid(5, 5);
        grid.prepareGeneration0();
        System.out.println("Generation: " + grid.getCurrentGeneration());
        grid.printGrid();
        System.out.println();

        grid.calculateNextGeneration();
        System.out.println("Generation: " + grid.getCurrentGeneration());
        grid.printGrid();
    }

}
