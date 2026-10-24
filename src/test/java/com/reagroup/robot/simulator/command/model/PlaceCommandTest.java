package com.reagroup.robot.simulator.command.model;

import com.reagroup.robot.simulator.constants.Compass;
import com.reagroup.robot.simulator.state.model.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlaceCommandTest {

    @Test
    public void testPlaceCommand() {
        // given
        final PlaceCommand placeCommand = new PlaceCommand(new String[]{"3", "4", "WEST"});

        // when
        final State state = placeCommand.execute(null);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(true, state.isActive());
        Assertions.assertEquals(3, state.getX());
        Assertions.assertEquals(4, state.getY());
        Assertions.assertEquals(Compass.WEST, state.getCompass());
    }

    @Test
    public void testPlaceCommandWithInvalidParams() {
        // given
        final PlaceCommand placeCommand = new PlaceCommand(new String[]{"a", "b", "WET"});

        // when
        final State state = placeCommand.execute(null);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(false, state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(0, state.getY());
        Assertions.assertNull(state.getCompass());
    }
}
