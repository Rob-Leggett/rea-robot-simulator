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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApplicationIntegrationTest {

    private Application application;

    @BeforeEach
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
        Assertions.assertNotNull(state);
        Assertions.assertTrue(state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(1, state.getY());
        Assertions.assertEquals(Compass.NORTH, state.getCompass());
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
        Assertions.assertNotNull(state);
        Assertions.assertTrue(state.isActive());
        Assertions.assertEquals(4, state.getX());
        Assertions.assertEquals(1, state.getY());
        Assertions.assertEquals(Compass.EAST, state.getCompass());
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
        Assertions.assertNotNull(state);
        Assertions.assertTrue(state.isActive());
        Assertions.assertEquals(2, state.getX());
        Assertions.assertEquals(3, state.getY());
        Assertions.assertEquals(Compass.NORTH, state.getCompass());
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
        Assertions.assertNotNull(state);
        Assertions.assertFalse(state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(0, state.getY());
        Assertions.assertNull(state.getCompass());
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
        Assertions.assertNotNull(state);
        Assertions.assertFalse(state.isActive());
        Assertions.assertEquals(0, state.getX());
        Assertions.assertEquals(0, state.getY());
        Assertions.assertNull(state.getCompass());
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
        Assertions.assertNull(state);
    }
}
