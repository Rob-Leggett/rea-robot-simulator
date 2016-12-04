package com.reagroup.robot.simulator.common.services;

import java.util.List;

public interface FileService<T> {
  List<T> process(final String filePath);
}
