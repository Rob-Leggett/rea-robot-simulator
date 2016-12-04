package com.reagroup.robot.simulator.table.model;

import org.junit.Assert;
import org.junit.Test;

public class StandardTableTest {

    @Test
    public void testTableInitialised() {
        // when
        final Table table = new StandardTable(5, 5);

        // then
        Assert.assertEquals(5, table.getHeight());
        Assert.assertEquals(5, table.getWidth());
    }

    @Test
    public void testIsOnTable() {
        // given
        final Table table = new StandardTable(4, 6);

        // when
        final boolean isOn = table.isOn(3, 2);

        // then
        Assert.assertTrue(isOn);
    }

    @Test
    public void testIsOffTableWithHeight() {
        // given
        final Table table = new StandardTable(4, 6);

        // when
        final boolean isOn = table.isOn(1, 5);

        // then
        Assert.assertFalse(isOn);
    }

    @Test
    public void testIsOffTableWithWidth() {
        // given
        final Table table = new StandardTable(2, 3);

        // when
        final boolean isOn = table.isOn(4, 1);

        // then
        Assert.assertFalse(isOn);
    }
}
