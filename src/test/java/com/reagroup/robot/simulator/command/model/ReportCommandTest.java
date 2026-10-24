package com.reagroup.robot.simulator.command.model;

import com.reagroup.robot.simulator.constants.Compass;
import com.reagroup.robot.simulator.state.model.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReportCommandTest {

    private ReportCommand reportCommand;

    @BeforeEach
    public void setup() {
        reportCommand = new ReportCommand();
    }

    @Test
    public void testReportCommand() {
        // given
        final State current = new State(true, 2, 3, Compass.WEST);

        // when
        final State state = reportCommand.execute(current);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(true, state.isActive());
        Assertions.assertEquals(2, state.getX());
        Assertions.assertEquals(3, state.getY());
        Assertions.assertEquals(Compass.WEST, state.getCompass());
    }

    @Test
    public void testReportCommandForInactiveState() {
        // given
        final State current = new State(false, 2, 3, Compass.WEST);

        // when
        final State state = reportCommand.execute(current);

        // then
        Assertions.assertNotNull(state);
        Assertions.assertEquals(false, state.isActive());
        Assertions.assertEquals(2, state.getX());
        Assertions.assertEquals(3, state.getY());
        Assertions.assertEquals(Compass.WEST, state.getCompass());
    }
}
