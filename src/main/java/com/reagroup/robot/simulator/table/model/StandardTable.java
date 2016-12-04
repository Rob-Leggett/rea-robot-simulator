package com.reagroup.robot.simulator.table.model;

/**
 * This class is immutable.
 *
 * This class represents a table, on construction this sets the height and width of the table.
 *
 * The class is used to determine based on the position if it is on the table of not which is returned via a boolean.
 */
public class StandardTable implements Table {

  private int height;
  private int width;

  public StandardTable(final int height, final int width) {
    this.height = height;
    this.width = width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public boolean isOn(int x, int y) {
    return (x >= 0 && x < width) && (y >= 0 && y < height);
  }

  @Override
  public String toString() {
    return "StandardTable{" +
        "height=" + height +
        ", width=" + width +
        '}';
  }
}
