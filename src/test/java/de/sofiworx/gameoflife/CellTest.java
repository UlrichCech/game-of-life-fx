package de.sofiworx.gameoflife;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

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
    }
}
