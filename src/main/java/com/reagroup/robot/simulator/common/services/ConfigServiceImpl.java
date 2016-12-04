package com.reagroup.robot.simulator.common.services;

import com.reagroup.robot.simulator.common.model.Property;
import com.reagroup.robot.simulator.common.utils.ConfigUtils;
import com.reagroup.robot.simulator.constants.Constants;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class will return a List of configuration properties.
 *
 * The base can be used to filter the number of configuration items returned.  If the base is null all
 * configuration items will be returned, otherwise only configuration items that start with the base passed in will be returned.
 */
public class ConfigServiceImpl implements ConfigService {

    private static final String SEPARATOR = "=";

    private ConfigUtils configUtils;

    public ConfigServiceImpl(final ConfigUtils configUtils) {
        this.configUtils = configUtils;
    }

    @Override
    public Map<String, String> getConfiguration(final String base) {
        final List<String> configurations = configUtils.loadConfigurationResource(Constants.CONFIG_FILENAME);

        return configurations
                .stream()
                .filter(line -> (base == null || line.startsWith(base)))
                .map(line -> {
                    String[] token = line.split(SEPARATOR);

                    return new Property(token[0], token[1]);
                })
                .collect(Collectors.toMap(Property::getKey, Property::getValue));
    }
}
