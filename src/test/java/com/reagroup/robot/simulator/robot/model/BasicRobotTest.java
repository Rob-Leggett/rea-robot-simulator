package com.reagroup.robot.simulator.robot.model;

import com.reagroup.robot.simulator.command.model.Command;
import com.reagroup.robot.simulator.command.model.PlaceCommand;
import com.reagroup.robot.simulator.constants.Compass;
import com.reagroup.robot.simulator.state.model.State;
import com.reagroup.robot.simulator.table.model.StandardTable;
import com.reagroup.robot.simulator.table.model.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BasicRobotTest {

    private Robot robot;

    @BeforeEach
    public void setup() {
        robot = new BasicRobot();
    }

    @Test
    public void testInitialState() {
        // when
        final State state = robot.getState();

        // then
        Assertions.assertNotNull(state);
        Assertions.assertFalse(state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(0, state.getY());
        Assertions.assertNull(state.getCompass());
    }

    @Test
    public void testExecuteCommandPlacingRobotOnTheTable() {
        // given
        final Table table = new StandardTable(5, 5);
        final Command command = new PlaceCommand(new String[]{"2", "2", "NORTH"});

        // when
        robot.execute(table, command);

        // then
        final State state = robot.getState();

        Assertions.assertNotNull(state);
        Assertions.assertTrue(state.isActive());
        Assertions.assertEquals(2, state.getX());
        Assertions.assertEquals(2, state.getY());
        Assertions.assertEquals(Compass.NORTH, state.getCompass());
    }

    @Test
    public void testExecuteCommandPlacingRobotOffTheTable() {
        // given
        final Table table = new StandardTable(5, 5);
        final Command command = new PlaceCommand(new String[]{"6,2,NORTH"});

        // when
        robot.execute(table, command);

        // then
        final State state = robot.getState();

        Assertions.assertNotNull(state);
        Assertions.assertFalse(state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(0, state.getY());
        Assertions.assertNull(state.getCompass());
    }

    @Test
    public void testIsOnTableCalled() {
        // given
        final Table table = Mockito.mock(StandardTable.class);
        final Command command = new PlaceCommand(new String[] {"2","2","NORTH"});

        // when
        robot.execute(table, command);

        // then
        Mockito.verify(table).isOn(2,2);
    }
}
