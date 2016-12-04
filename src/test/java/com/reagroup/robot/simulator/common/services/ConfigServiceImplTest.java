package com.reagroup.robot.simulator.common.services;

import com.reagroup.robot.simulator.common.utils.ConfigUtils;
import com.reagroup.robot.simulator.constants.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConfigServiceImplTest {

    private ConfigService configService;

    @Mock
    private ConfigUtils configUtilsMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        configService = new ConfigServiceImpl(configUtilsMock);
    }

    @Test
    public void testGetConfigurationReturnAll() {
        // given
        final String base = null;

        final List<String> configurations = new ArrayList<>();
        configurations.add("test.key=test.value");

        Mockito.when(configUtilsMock.loadConfigurationResource(Constants.CONFIG_FILENAME)).thenReturn(configurations);

        // when
        final Map<String, String> config = configService.getConfiguration(base);

        // then
        Assert.assertNotNull(config);
        Assert.assertEquals(1, config.size());
    }

    @Test
    public void testGetConfigurationReturnPartial() {
        final String base = "test";

        final List<String> configurations = new ArrayList<>();
        configurations.add("test.key=test.value");
        configurations.add("test.key2=test.value2");
        configurations.add("mock.key=mock.value");

        Mockito.when(configUtilsMock.loadConfigurationResource(Constants.CONFIG_FILENAME)).thenReturn(configurations);

        // when
        final Map<String, String> config = configService.getConfiguration(base);

        // then
        Assert.assertNotNull(config);
        Assert.assertEquals(2, config.size());
    }

    @Test
    public void testGetConfigurationReturnNone() {
        final String base = "none";

        final List<String> configurations = new ArrayList<>();
        configurations.add("test.key=test.value");
        configurations.add("test.key2=test.value2");
        configurations.add("mock.key=mock.value");

        Mockito.when(configUtilsMock.loadConfigurationResource(Constants.CONFIG_FILENAME)).thenReturn(configurations);

        // when
        final Map<String, String> config = configService.getConfiguration(base);

        // then
        Assert.assertNotNull(config);
        Assert.assertEquals(0, config.size());
    }
}
