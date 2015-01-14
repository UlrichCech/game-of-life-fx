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
    public void testCell() {
        Cell cell = new Cell();
        assertThat(cell.isAlive(), Is.is(false));
    }
}
