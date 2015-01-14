package de.sofiworx.gameoflife;

import org.hamcrest.core.Is;
import org.junit.Test;

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
        Cell cell = new Cell(1, 1);
        assertThat(cell.isAlive(), Is.is(false));
        assertThat(cell.getX(), Is.is(1));
        assertThat(cell.getY(), Is.is(1));
        try {
            cell = new Cell(-1, 0);
            fail("negative x-parameter not recognized.");
        } catch (RuntimeException rt) {}
        try {
            cell = new Cell(0, -1);
            fail("negative y-parameter not recognized.");
        } catch (RuntimeException rt) {}
        cell = new Cell(1, 1, true);
        assertThat(cell.isAlive(), Is.is(true));
    }

    @Test
    public void testGetGeneration() {
        Cell cell = new Cell(1, 1);
        assertThat(cell.getGeneration(), Is.is(0));
        cell.progressGeneration();
        assertThat(cell.getGeneration(), Is.is(1));
    }

}
