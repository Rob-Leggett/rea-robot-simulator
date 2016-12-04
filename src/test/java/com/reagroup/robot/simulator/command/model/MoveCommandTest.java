package com.reagroup.robot.simulator.command.model;

import com.reagroup.robot.simulator.constants.Compass;
import com.reagroup.robot.simulator.state.model.State;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoveCommandTest {

    private MoveCommand moveCommand;

    @Before
    public void setup() {
        moveCommand = new MoveCommand();
    }

    @Test
    public void testMoveCommandEast() {
        // given
        final State current = new State(true, 1, 2, Compass.EAST);

        // when
        final State state = moveCommand.execute(current);

        // then
        Assert.assertNotNull(state);
        Assert.assertEquals(true, state.isActive());
        Assert.assertEquals(2, state.getX());
        Assert.assertEquals(2, state.getY());
        Assert.assertEquals(Compass.EAST, state.getCompass());
    }

    @Test
    public void testMoveCommandWest() {
        // given
        final State current = new State(true, 1, 2, Compass.WEST);

        // when
        final State state = moveCommand.execute(current);

        // then
        Assert.assertNotNull(state);
        Assert.assertEquals(true, state.isActive());
        Assert.assertEquals(0, state.getX());
        Assert.assertEquals(2, state.getY());
        Assert.assertEquals(Compass.WEST, state.getCompass());
    }

    @Test
    public void testMoveCommandNorth() {
        // given
        final State current = new State(true, 1, 2, Compass.NORTH);

        // when
        final State state = moveCommand.execute(current);

        // then
        Assert.assertNotNull(state);
        Assert.assertEquals(true, state.isActive());
        Assert.assertEquals(1, state.getX());
        Assert.assertEquals(3, state.getY());
        Assert.assertEquals(Compass.NORTH, state.getCompass());
    }

    @Test
    public void testMoveCommandSouth() {
        // given
        final State current = new State(true, 1, 2, Compass.SOUTH);

        // when
        final State state = moveCommand.execute(current);

        // then
        Assert.assertNotNull(state);
        Assert.assertEquals(true, state.isActive());
        Assert.assertEquals(1, state.getX());
        Assert.assertEquals(1, state.getY());
        Assert.assertEquals(Compass.SOUTH, state.getCompass());
    }

    @Test
    public void testMoveCommandForInactiveState() {
        // given
        final State current = new State(false, 1, 2, Compass.EAST);

        // when
        final State state = moveCommand.execute(current);

        // then
        Assert.assertNotNull(state);
        Assert.assertEquals(false, state.isActive());
        Assert.assertEquals(1, state.getX());
        Assert.assertEquals(2, state.getY());
        Assert.assertEquals(Compass.EAST, state.getCompass());
    }
}
