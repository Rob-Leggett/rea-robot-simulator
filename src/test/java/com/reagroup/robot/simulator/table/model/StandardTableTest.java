package com.reagroup.robot.simulator.table.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StandardTableTest {

    @Test
    public void testTableInitialised() {
        // when
        final Table table = new StandardTable(5, 5);

        // then
        Assertions.assertEquals(5, table.getHeight());
        Assertions.assertEquals(5, table.getWidth());
    }

    @Test
    public void testIsOnTable() {
        // given
        final Table table = new StandardTable(4, 6);

        // when
        final boolean isOn = table.isOn(3, 2);

        // then
        Assertions.assertTrue(isOn);
    }

    @Test
    public void testIsOffTableWithHeight() {
        // given
        final Table table = new StandardTable(4, 6);

        // when
        final boolean isOn = table.isOn(1, 5);

        // then
        Assertions.assertFalse(isOn);
    }

    @Test
    public void testIsOffTableWithWidth() {
        // given
        final Table table = new StandardTable(2, 3);

        // when
        final boolean isOn = table.isOn(4, 1);

        // then
        Assertions.assertFalse(isOn);
    }
}
