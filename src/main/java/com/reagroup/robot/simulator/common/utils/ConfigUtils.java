package com.reagroup.robot.simulator.common.utils;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is used to load all configuration items form a file based on the filename passed in and return them as a List.
 */
public class ConfigUtils {

    private static final Logger LOG = LoggerFactory.getLogger(ConfigUtils.class);

    public List<String> loadConfigurationResource(final String fileName) {
        List<String> configurations = new ArrayList<>();

        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;

        try {
            inputStreamReader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream(fileName));
            reader = new BufferedReader(inputStreamReader);

            configurations = reader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Unable to load configuration");
        } finally {
            IOUtils.closeQuietly(inputStreamReader);
            IOUtils.closeQuietly(reader);
        }

        return configurations;
    }
}
