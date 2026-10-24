package com.reagroup.robot.simulator.command.model;

import com.reagroup.robot.simulator.constants.CommandID;
import com.reagroup.robot.simulator.constants.Compass;
import com.reagroup.robot.simulator.state.model.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RotateCommandTest {

    @Test
    public void testRotateCommandLeftFromNorth() {
        // given
        final RotateCommand rotateCommand = new RotateCommand(CommandID.LEFT);
        final State current = new State(true, 0, 0, Compass.NORTH);

        // when
        final State state = rotateCommand.execute(current);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(true, state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(0, state.getY());
        Assertions.assertEquals(Compass.WEST, state.getCompass());
    }

    @Test
    public void testRotateCommandLeftFromSouth() {
        // given
        final RotateCommand rotateCommand = new RotateCommand(CommandID.LEFT);
        final State current = new State(true, 0, 0, Compass.SOUTH);

        // when
        final State state = rotateCommand.execute(current);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(true, state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(0, state.getY());
        Assertions.assertEquals(Compass.EAST, state.getCompass());
    }

    @Test
    public void testRotateCommandLeftFromEast() {
        // given
        final RotateCommand rotateCommand = new RotateCommand(CommandID.LEFT);
        final State current = new State(true, 0, 0, Compass.EAST);

        // when
        final State state = rotateCommand.execute(current);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(true, state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(0, state.getY());
        Assertions.assertEquals(Compass.NORTH, state.getCompass());
    }

    @Test
    public void testRotateCommandLeftFromWest() {
        // given
        final RotateCommand rotateCommand = new RotateCommand(CommandID.LEFT);
        final State current = new State(true, 0, 0, Compass.WEST);

        // when
        final State state = rotateCommand.execute(current);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(true, state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(0, state.getY());
        Assertions.assertEquals(Compass.SOUTH, state.getCompass());
    }

    @Test
    public void testRotateCommandRightFromNorth() {
        // given
        final RotateCommand rotateCommand = new RotateCommand(CommandID.RIGHT);
        final State current = new State(true, 0, 0, Compass.NORTH);

        // when
        final State state = rotateCommand.execute(current);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(true, state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(0, state.getY());
        Assertions.assertEquals(Compass.EAST, state.getCompass());
    }

    @Test
    public void testRotateCommandRightFromSouth() {
        // given
        final RotateCommand rotateCommand = new RotateCommand(CommandID.RIGHT);
        final State current = new State(true, 0, 0, Compass.SOUTH);

        // when
        final State state = rotateCommand.execute(current);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(true, state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(0, state.getY());
        Assertions.assertEquals(Compass.WEST, state.getCompass());
    }

    @Test
    public void testRotateCommandRightFromEast() {
        // given
        final RotateCommand rotateCommand = new RotateCommand(CommandID.RIGHT);
        final State current = new State(true, 0, 0, Compass.EAST);

        // when
        final State state = rotateCommand.execute(current);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(true, state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(0, state.getY());
        Assertions.assertEquals(Compass.SOUTH, state.getCompass());
    }

    @Test
    public void testRotateCommandRightFromWest() {
        // given
        final RotateCommand rotateCommand = new RotateCommand(CommandID.RIGHT);
        final State current = new State(true, 0, 0, Compass.WEST);

        // when
        final State state = rotateCommand.execute(current);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(true, state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(0, state.getY());
        Assertions.assertEquals(Compass.NORTH, state.getCompass());
    }

    @Test
    public void testRotateCommandForInactiveState() {
        // given
        final RotateCommand rotateCommand = new RotateCommand(CommandID.LEFT);
        final State current = new State(false);

        // when
        final State state = rotateCommand.execute(current);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(false, state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(0, state.getY());
        Assertions.assertNull(state.getCompass());
    }

    @Test
    public void testRotateCommandWithInvalidParams() {
        // given
        final RotateCommand rotateCommand = new RotateCommand(CommandID.REPORT);
        final State current = new State(true);

        // when
        final State state = rotateCommand.execute(current);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(true, state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(0, state.getY());
        Assertions.assertNull(state.getCompass());
    }
}
