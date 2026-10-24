package com.reagroup.robot.simulator.common.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ConfigUtilsTest {

    private ConfigUtils configUtils;

    @BeforeEach
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
        Assertions.assertNotNull(config);
        Assertions.assertEquals(2, config.size());
    }

    @Test
    public void testLoadConfigurationResourceNotFound() {
        // given
        final String fileName = "mock-configuration.properties";

        // when
        final List<String> config =
                configUtils.loadConfigurationResource(fileName);

        // then
        Assertions.assertNotNull(config);
        Assertions.assertEquals(0, config.size());
    }
}
