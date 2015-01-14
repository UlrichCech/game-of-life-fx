package de.sofiworx.gameoflife;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

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

}
