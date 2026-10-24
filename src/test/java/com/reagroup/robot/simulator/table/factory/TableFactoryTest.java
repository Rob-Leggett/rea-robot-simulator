package com.reagroup.robot.simulator.table.factory;

import com.reagroup.robot.simulator.common.services.ConfigService;
import com.reagroup.robot.simulator.constants.Constants;
import com.reagroup.robot.simulator.table.model.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

public class TableFactoryTest {

    private TableFactory tableFactory;

    @Mock
    private ConfigService configServiceMock;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        tableFactory = new TableFactory(configServiceMock);
    }

    @Test
    public void testCreateTable() {
        // given
        final Map<String, String> configuration = new HashMap<>();
        configuration.put(Constants.CONFIG_PROPERTY_TABLE_HEIGHT, "4");
        configuration.put(Constants.CONFIG_PROPERTY_TABLE_WIDTH, "2");

        Mockito.when(configServiceMock.getConfiguration(Constants.CONFIG_BASE_TABLE)).thenReturn(configuration);

        // when
        final Table table = tableFactory.createTable();

        // then
        Assertions.assertNotNull(table);
    }

    @Test
    public void testCreateTableWithoutConfiguration() {
        // given
        final Map<String, String> configuration = new HashMap<>();

        Mockito.when(configServiceMock.getConfiguration(Constants.CONFIG_BASE_TABLE)).thenReturn(configuration);

        // when
        final Table table = tableFactory.createTable();

        // then
        Assertions.assertNull(table);
    }
}
