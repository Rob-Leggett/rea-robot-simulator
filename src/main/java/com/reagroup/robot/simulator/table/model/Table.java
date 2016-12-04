package com.reagroup.robot.simulator.table.model;

public interface Table {

  int getHeight();

  int getWidth();

  boolean isOn(final int x, final int y);
}
