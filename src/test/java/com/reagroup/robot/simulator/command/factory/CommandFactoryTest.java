package com.reagroup.robot.simulator.command.factory;

import com.reagroup.robot.simulator.command.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandFactoryTest {

    private CommandFactory commandFactory;

    @Before
    public void setup() {
        commandFactory = new CommandFactory();
    }

    @Test
    public void testCreateCommandInvalid() {
        // given
        final String line = "DANCE";

        // when
        final Command command = commandFactory.createCommand(line);

        //then
        Assert.assertNull(command);
    }

    @Test
    public void testCreateCommandPlace() {
        // given
        final String line = "PLACE 2,3,EAST";

        // when
        final Command command = commandFactory.createCommand(line);

        //then
        Assert.assertNotNull(command);
        Assert.assertSame(PlaceCommand.class, command.getClass());
    }

    @Test
    public void testCreateCommandPlaceInvalidParams() {
        // given
        final String line = "PLACE a,b,EAT";

        // when
        final Command command = commandFactory.createCommand(line);

        //then
        Assert.assertNotNull(command);
        Assert.assertSame(PlaceCommand.class, command.getClass());
    }

    @Test
    public void testCreateCommandMove() {
        // given
        final String line = "MOVE";

        // when
        final Command command = commandFactory.createCommand(line);

        //then
        Assert.assertNotNull(command);
        Assert.assertSame(MoveCommand.class, command.getClass());
    }

    @Test
    public void testCreateCommandRotateLeft() {
        // given
        final String line = "LEFT";

        // when
        final Command command = commandFactory.createCommand(line);

        //then
        Assert.assertNotNull(command);
        Assert.assertSame(RotateCommand.class, command.getClass());
    }

    @Test
    public void testCreateCommandRotateRight() {
        // given
        final String line = "RIGHT";

        // when
        final Command command = commandFactory.createCommand(line);

        //then
        Assert.assertNotNull(command);
        Assert.assertSame(RotateCommand.class, command.getClass());
    }

    @Test
    public void testCreateCommandReport() {
        // given
        final String line = "REPORT";

        // when
        final Command command = commandFactory.createCommand(line);

        //then
        Assert.assertNotNull(command);
        Assert.assertSame(ReportCommand.class, command.getClass());
    }
}
