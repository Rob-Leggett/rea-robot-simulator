package com.reagroup.robot.simulator.command.factory;

import com.reagroup.robot.simulator.command.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandFactoryTest {

    private CommandFactory commandFactory;

    @BeforeEach
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
        Assertions.assertNull(command);
    }

    @Test
    public void testCreateCommandPlace() {
        // given
        final String line = "PLACE 2,3,EAST";

        // when
        final Command command = commandFactory.createCommand(line);

        //then
        Assertions.assertNotNull(command);
        Assertions.assertSame(PlaceCommand.class, command.getClass());
    }

    @Test
    public void testCreateCommandPlaceInvalidParams() {
        // given
        final String line = "PLACE a,b,EAT";

        // when
        final Command command = commandFactory.createCommand(line);

        //then
        Assertions.assertNotNull(command);
        Assertions.assertSame(PlaceCommand.class, command.getClass());
    }

    @Test
    public void testCreateCommandMove() {
        // given
        final String line = "MOVE";

        // when
        final Command command = commandFactory.createCommand(line);

        //then
        Assertions.assertNotNull(command);
        Assertions.assertSame(MoveCommand.class, command.getClass());
    }

    @Test
    public void testCreateCommandRotateLeft() {
        // given
        final String line = "LEFT";

        // when
        final Command command = commandFactory.createCommand(line);

        //then
        Assertions.assertNotNull(command);
        Assertions.assertSame(RotateCommand.class, command.getClass());
    }

    @Test
    public void testCreateCommandRotateRight() {
        // given
        final String line = "RIGHT";

        // when
        final Command command = commandFactory.createCommand(line);

        //then
        Assertions.assertNotNull(command);
        Assertions.assertSame(RotateCommand.class, command.getClass());
    }

    @Test
    public void testCreateCommandReport() {
        // given
        final String line = "REPORT";

        // when
        final Command command = commandFactory.createCommand(line);

        //then
        Assertions.assertNotNull(command);
        Assertions.assertSame(ReportCommand.class, command.getClass());
    }
}
