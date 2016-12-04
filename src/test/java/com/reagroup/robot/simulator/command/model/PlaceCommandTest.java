package com.reagroup.robot.simulator.command.model;

import com.reagroup.robot.simulator.constants.Compass;
import com.reagroup.robot.simulator.state.model.State;
import org.junit.Assert;
import org.junit.Test;

public class PlaceCommandTest {

    @Test
    public void testPlaceCommand() {
        // given
        final PlaceCommand placeCommand = new PlaceCommand(new String[]{"3", "4", "WEST"});

        // when
        final State state = placeCommand.execute(null);

        // then
        Assert.assertNotNull(state);
        Assert.assertEquals(true, state.isActive());
        Assert.assertEquals(3, state.getX());
        Assert.assertEquals(4, state.getY());
        Assert.assertEquals(Compass.WEST, state.getCompass());
    }

    @Test
    public void testPlaceCommandWithInvalidParams() {
        // given
        final PlaceCommand placeCommand = new PlaceCommand(new String[]{"a", "b", "WET"});

        // when
        final State state = placeCommand.execute(null);

        // then
        Assert.assertNotNull(state);
        Assert.assertEquals(false, state.isActive());
        Assert.assertEquals(0, state.getX());
        Assert.assertEquals(0, state.getY());
        Assert.assertNull(state.getCompass());
    }
}
