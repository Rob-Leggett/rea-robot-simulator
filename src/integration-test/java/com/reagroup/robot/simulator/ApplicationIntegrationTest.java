package com.reagroup.robot.simulator;

import com.reagroup.robot.simulator.command.factory.CommandFactory;
import com.reagroup.robot.simulator.command.model.Command;
import com.reagroup.robot.simulator.command.services.CommandFileServiceImpl;
import com.reagroup.robot.simulator.common.services.ConfigServiceImpl;
import com.reagroup.robot.simulator.common.services.FileService;
import com.reagroup.robot.simulator.common.utils.ConfigUtils;
import com.reagroup.robot.simulator.constants.Compass;
import com.reagroup.robot.simulator.robot.factory.RobotFactory;
import com.reagroup.robot.simulator.state.model.State;
import com.reagroup.robot.simulator.table.factory.TableFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ApplicationIntegrationTest {

    private Application application;

    @Before
    public void setup() {
        final TableFactory tableFactory = new TableFactory(new ConfigServiceImpl(new ConfigUtils()));
        final RobotFactory robotFactory = new RobotFactory();
        final FileService<Command> commandFileService = new CommandFileServiceImpl(new CommandFactory());

        application = new Application(tableFactory, robotFactory, commandFileService);
    }

    /**
     * Run the simulation with all valid commands passed in.
     */
    @Test
    public void testSimulateWithValidCommand() {
        // given
        final String path = getClass().getClassLoader().getResource("command/command.txt").getPath();

        final String[] args = new String[]{path};

        // when
        final State state = application.simulate(args);

        // then
        Assert.assertNotNull(state);
        Assert.assertTrue(state.isActive());
        Assert.assertEquals(0, state.getX());
        Assert.assertEquals(1, state.getY());
        Assert.assertEquals(Compass.NORTH, state.getCompass());
    }

    /**
     * Run the simulation with all valid commands passed it, but also multiple place commands.
     */
    @Test
    public void testSimulateWithMultiplePlaceCommands() {
        // given
        final String path = getClass().getClassLoader().getResource("command/command-multiple-place.txt").getPath();

        final String[] args = new String[]{path};

        // when
        final State state = application.simulate(args);

        // then
        Assert.assertNotNull(state);
        Assert.assertTrue(state.isActive());
        Assert.assertEquals(4, state.getX());
        Assert.assertEquals(1, state.getY());
        Assert.assertEquals(Compass.EAST, state.getCompass());
    }

    /**
     * Run the simulation with a combination of valid commands and an invalid command passed in.
     */
    @Test
    public void testSimulateWithInvalidCommand() {
        // given
        final String path = getClass().getClassLoader().getResource("command/command-invalid.txt").getPath();

        final String[] args = new String[]{path};

        // when
        final State state = application.simulate(args);

        // then
        Assert.assertNotNull(state);
        Assert.assertTrue(state.isActive());
        Assert.assertEquals(2, state.getX());
        Assert.assertEquals(3, state.getY());
        Assert.assertEquals(Compass.NORTH, state.getCompass());
    }

    /**
     * Run the simulation with valid commands but invalid data passed along with the command.
     */
    @Test
    public void testSimulateWithInvalidCommandData() {
        // given
        final String path = getClass().getClassLoader().getResource("command/command-invalid-data.txt").getPath();

        final String[] args = new String[]{path};

        // when
        final State state = application.simulate(args);

        // then
        Assert.assertNotNull(state);
        Assert.assertFalse(state.isActive());
        Assert.assertEquals(0, state.getX());
        Assert.assertEquals(0, state.getY());
        Assert.assertNull(state.getCompass());
    }

    /**
     * Run the simulation with an empty command list passed in.
     */
    @Test
    public void testSimulateWithNoCommandData() {
        // given
        final String path = getClass().getClassLoader().getResource("command/command-no-data.txt").getPath();

        final String[] args = new String[]{path};

        // when
        final State state = application.simulate(args);

        // then
        Assert.assertNotNull(state);
        Assert.assertFalse(state.isActive());
        Assert.assertEquals(0, state.getX());
        Assert.assertEquals(0, state.getY());
        Assert.assertNull(state.getCompass());
    }

    /**
     * Run the simulation with no file to process to get the commands to pass in.
     */
    @Test
    public void testSimulateWithNoFile() {
        // given
        final String[] args = new String[]{};

        // when
        final State state = application.simulate(args);

        // then
        Assert.assertNull(state);
    }
}
