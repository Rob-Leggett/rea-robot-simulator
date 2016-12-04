package com.reagroup.robot.simulator;

import com.reagroup.robot.simulator.command.model.Command;
import com.reagroup.robot.simulator.command.model.PlaceCommand;
import com.reagroup.robot.simulator.common.services.FileService;
import com.reagroup.robot.simulator.constants.Compass;
import com.reagroup.robot.simulator.robot.factory.RobotFactory;
import com.reagroup.robot.simulator.robot.model.BasicRobot;
import com.reagroup.robot.simulator.state.model.State;
import com.reagroup.robot.simulator.table.factory.TableFactory;
import com.reagroup.robot.simulator.table.model.StandardTable;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ApplicationTest {

    private Application application;

    @Mock
    private TableFactory tableFactoryMock;

    @Mock
    private RobotFactory robotFactoryMock;

    @Mock
    private FileService<Command> commandFileServiceMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        application = new Application(tableFactoryMock, robotFactoryMock, commandFileServiceMock);
    }

    @Test
    public void testApplicationDependenciesCalled() {
        // given
        final String fileName = "mockFileName";
        final String[] args = new String[]{fileName};

        Mockito.when(tableFactoryMock.createTable()).thenReturn(new StandardTable(5, 5));
        Mockito.when(robotFactoryMock.createRobot()).thenReturn(new BasicRobot());
        Mockito.when(commandFileServiceMock.process(fileName)).thenReturn(new ArrayList<>());

        // when
        application.simulate(args);

        // then
        Mockito.verify(tableFactoryMock).createTable();
        Mockito.verify(robotFactoryMock).createRobot();
        Mockito.verify(commandFileServiceMock).process(fileName);
    }

    @Test
    public void testApplicationDependenciesNotCalled() {
        // given
        final String[] args = new String[]{};

        // when
        application.simulate(args);

        // then
        Mockito.verifyZeroInteractions(tableFactoryMock);
        Mockito.verifyZeroInteractions(robotFactoryMock);
        Mockito.verifyZeroInteractions(commandFileServiceMock);
    }

    @Test
    public void testSimulate() {
        // given
        final String fileName = "mockFileName";
        final String[] args = new String[]{fileName};
        final List<Command> commands = new ArrayList<>();
        commands.add(new PlaceCommand(new String[]{"2", "3", "NORTH"}));

        Mockito.when(tableFactoryMock.createTable()).thenReturn(new StandardTable(5, 5));
        Mockito.when(robotFactoryMock.createRobot()).thenReturn(new BasicRobot());
        Mockito.when(commandFileServiceMock.process(fileName)).thenReturn(commands);

        // when
        final State state = application.simulate(args);

        // then
        Assert.assertNotNull(state);
        Assert.assertTrue(state.isActive());
        Assert.assertEquals(2, state.getX());
        Assert.assertEquals(3, state.getY());
        Assert.assertEquals(Compass.NORTH, state.getCompass());
    }

    @Test
    public void testSimulateWithoutArgs() {
        // given
        final String[] args = new String[]{};

        // when
        final State state = application.simulate(args);

        // then
        Assert.assertNull(state);
    }
}
