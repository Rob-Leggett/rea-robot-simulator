package com.reagroup.robot.simulator.table.factory;

import com.reagroup.robot.simulator.common.services.ConfigService;
import com.reagroup.robot.simulator.constants.Constants;
import com.reagroup.robot.simulator.table.model.StandardTable;
import com.reagroup.robot.simulator.table.model.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * This class is a factory to create a table.
 *
 * This class is dependent on retrieving the configuration of the height and width of the table, otherwise null will be returned
 * for the table.
 */
public class TableFactory {

  private static final Logger LOG = LoggerFactory.getLogger(TableFactory.class);

  private ConfigService configService;

  public TableFactory(final ConfigService configService) {
    this.configService = configService;
  }

  public Table createTable() {
    final Map<String, String> config = configService.getConfiguration(Constants.CONFIG_BASE_TABLE);

    LOG.debug("Keys {}", config);

    final String height = config.get(Constants.CONFIG_PROPERTY_TABLE_HEIGHT);
    final String width = config.get(Constants.CONFIG_PROPERTY_TABLE_WIDTH);

    return (null == height || null == width) ?
        null : new StandardTable(Integer.parseInt(height), Integer.parseInt(width));
  }
}
