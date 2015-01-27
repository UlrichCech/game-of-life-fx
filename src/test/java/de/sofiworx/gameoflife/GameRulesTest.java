package de.sofiworx.gameoflife;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

public class GameRulesTest {

    @Test
    public void testGetInstance() {
        GameRules rules = GameRules.getInstance();
        assertSame(rules, GameRules.getInstance());
    }

    @Test
    public void isAliveInNextGeneration() {
        GameRules rules = GameRules.getInstance();
        assertThat(rules.isCellAliveInNextGeneration(true, 0), Is.is(false));
        assertThat(rules.isCellAliveInNextGeneration(true, 1), Is.is(false));
        assertThat(rules.isCellAliveInNextGeneration(true, 2), Is.is(true));
        assertThat(rules.isCellAliveInNextGeneration(true, 3), Is.is(true));
        assertThat(rules.isCellAliveInNextGeneration(false, 3), Is.is(true));
        assertThat(rules.isCellAliveInNextGeneration(true, 4), Is.is(false));
    }
}