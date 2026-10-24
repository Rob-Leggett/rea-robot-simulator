package com.reagroup.robot.simulator.command.model;

import com.reagroup.robot.simulator.constants.Compass;
import com.reagroup.robot.simulator.state.model.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoveCommandTest {

    private MoveCommand moveCommand;

    @BeforeEach
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
        Assertions.assertNotNull(state);
        Assertions.assertEquals(true, state.isActive());
        Assertions.assertEquals(2, state.getX());
        Assertions.assertEquals(2, state.getY());
        Assertions.assertEquals(Compass.EAST, state.getCompass());
    }

    @Test
    public void testMoveCommandWest() {
        // given
        final State current = new State(true, 1, 2, Compass.WEST);

        // when
        final State state = moveCommand.execute(current);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(true, state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(2, state.getY());
        Assertions.assertEquals(Compass.WEST, state.getCompass());
    }

    @Test
    public void testMoveCommandNorth() {
        // given
        final State current = new State(true, 1, 2, Compass.NORTH);

        // when
        final State state = moveCommand.execute(current);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(true, state.isActive());
        Assertions.assertEquals(1, state.getX());
        Assertions.assertEquals(3, state.getY());
        Assertions.assertEquals(Compass.NORTH, state.getCompass());
    }

    @Test
    public void testMoveCommandSouth() {
        // given
        final State current = new State(true, 1, 2, Compass.SOUTH);

        // when
        final State state = moveCommand.execute(current);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(true, state.isActive());
        Assertions.assertEquals(1, state.getX());
        Assertions.assertEquals(1, state.getY());
        Assertions.assertEquals(Compass.SOUTH, state.getCompass());
    }

    @Test
    public void testMoveCommandForInactiveState() {
        // given
        final State current = new State(false, 1, 2, Compass.EAST);

        // when
        final State state = moveCommand.execute(current);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(false, state.isActive());
        Assertions.assertEquals(1, state.getX());
        Assertions.assertEquals(2, state.getY());
        Assertions.assertEquals(Compass.EAST, state.getCompass());
    }
}
