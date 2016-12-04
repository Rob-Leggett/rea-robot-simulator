package com.reagroup.robot.simulator.common.services;

import java.util.Map;

public interface ConfigService {
  Map<String, String> getConfiguration(final String base);
}
