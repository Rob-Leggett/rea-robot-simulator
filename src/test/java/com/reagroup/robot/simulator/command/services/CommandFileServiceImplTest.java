package com.reagroup.robot.simulator.command.services;

import com.reagroup.robot.simulator.command.factory.CommandFactory;
import com.reagroup.robot.simulator.command.model.Command;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class CommandFileServiceImplTest {

    private CommandFileServiceImpl commandFileService;

    @Mock
    private CommandFactory commandFactoryMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        commandFileService = new CommandFileServiceImpl(commandFactoryMock);
    }

    @Test
    public void testProcess() {
        // given
        final String filePath = getClass().getClassLoader().getResource("command/command.txt").getPath();

        // when
        final List<Command> commands = commandFileService.process(filePath);

        // then
        Assert.assertNotNull(commands);
        Assert.assertEquals(0, commands.size());
    }

    @Test
    public void testProcessNoFile() {
        // given
        final String filePath = "mockFilePath";

        // when
        final List<Command> commands = commandFileService.process(filePath);

        // then
        Assert.assertNotNull(commands);
        Assert.assertEquals(0, commands.size());
    }
}
