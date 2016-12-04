package com.reagroup.robot.simulator.robot.model;

import com.reagroup.robot.simulator.command.model.Command;
import com.reagroup.robot.simulator.state.model.State;
import com.reagroup.robot.simulator.table.model.Table;

/**
 * This class represents a robot, on construction this it creates an initial inactive state and stores it internally.
 *
 * The state is not settable after construction however it is overridden once a valid execution of a command has occurred.
 */
public class BasicRobot implements Robot {

    private State state;

    public BasicRobot() {
        this.state = new State(false);
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void execute(final Table table, final Command command) {

        final State state = command.execute(this.state);

        // update state only if the command leaves the robot remaining on the table and the state is active
        if (state.isActive() && table.isOn(state.getX(), state.getY())) {
            this.state = state;
        }
    }

    @Override
    public String toString() {
        return "BasicRobot{" +
                "state=" + state +
                '}';
    }
}
