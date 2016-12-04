package com.reagroup.robot.simulator.command.services;

import com.reagroup.robot.simulator.command.factory.CommandFactory;
import com.reagroup.robot.simulator.command.model.Command;
import com.reagroup.robot.simulator.common.services.FileService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class receives a file path, which then reads the data from the file and produces a list of commands.
 *
 * If the file cannot be found it will return an empty list of commands and log the error.
 */
public class CommandFileServiceImpl implements FileService<Command> {

  private static final Logger LOG = LoggerFactory.getLogger(CommandFileServiceImpl.class);

  private CommandFactory commandFactory;

  public CommandFileServiceImpl(final CommandFactory commandFactory) {
    this.commandFactory = commandFactory;
  }

  @Override
  public List<Command> process(String filePath) {

    final List<Command> commands = new ArrayList<>();

    FileInputStream fileInputStream = null;
    InputStreamReader inputStreamReader = null;
    BufferedReader reader = null;

    try {
      fileInputStream = new FileInputStream(new File(filePath));
      inputStreamReader = new InputStreamReader(fileInputStream);
      reader = new BufferedReader(inputStreamReader);

      reader.lines().forEach(line -> {
        final Command command = commandFactory.createCommand(line);

        // if the command is recognised then add it to the list of commands
        if (null != command) {
          commands.add(command);
        }
      });
    } catch (FileNotFoundException e) {
      LOG.error("Unable to process commands");
    } finally {
      IOUtils.closeQuietly(reader);
      IOUtils.closeQuietly(inputStreamReader);
      IOUtils.closeQuietly(fileInputStream);
    }

    return commands;
  }
}
