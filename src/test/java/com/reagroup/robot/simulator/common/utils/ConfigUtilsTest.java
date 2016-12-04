package com.reagroup.robot.simulator.common.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ConfigUtilsTest {

    private ConfigUtils configUtils;

    @Before
    public void setup() {
        configUtils = new ConfigUtils();
    }

    @Test
    public void testLoadConfigurationResource() {
        // given
        final String fileName = "test-configuration.properties";

        // when
        final List<String> config =
                configUtils.loadConfigurationResource(fileName);

        // then
        Assert.assertNotNull(config);
        Assert.assertEquals(2, config.size());
    }

    @Test
    public void testLoadConfigurationResourceNotFound() {
        // given
        final String fileName = "mock-configuration.properties";

        // when
        final List<String> config =
                configUtils.loadConfigurationResource(fileName);

        // then
        Assert.assertNotNull(config);
        Assert.assertEquals(0, config.size());
    }
}
