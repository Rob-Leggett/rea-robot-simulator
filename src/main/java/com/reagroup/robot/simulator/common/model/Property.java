package com.reagroup.robot.simulator.common.model;

/**
 * Immutable class that will store the key and value passed into the constructor.
 */
public class Property {

  private String key;
  private String value;

  public Property(String key, String value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }
}
