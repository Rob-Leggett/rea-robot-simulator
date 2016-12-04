package com.reagroup.robot.simulator.state.model;

import com.reagroup.robot.simulator.constants.Compass;

/**
 * Immutable class that will store the state that is passed into the constructor.
 */
public class State {

  private boolean active;

  private int x;

  private int y;

  private Compass compass;

  public State(final boolean active) {
    this(active, 0, 0, null);
  }

  public State(final boolean active, final int x, final int y, final Compass compass) {
    this.active = active;
    this.x = x;
    this.y = y;
    this.compass = compass;
  }

  public boolean isActive() {
    return active;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public Compass getCompass() {
    return compass;
  }

  @Override
  public String toString() {
    return "State{" +
        "active=" + active +
        ", x=" + x +
        ", y=" + y +
        ", compass=" + compass +
        '}';
  }
}
