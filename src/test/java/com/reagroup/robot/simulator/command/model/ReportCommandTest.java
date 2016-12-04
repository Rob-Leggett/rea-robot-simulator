package com.reagroup.robot.simulator.command.model;

import com.reagroup.robot.simulator.constants.Compass;
import com.reagroup.robot.simulator.state.model.State;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReportCommandTest {

    private ReportCommand reportCommand;

    @Before
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
        Assert.assertNotNull(state);
        Assert.assertEquals(true, state.isActive());
        Assert.assertEquals(2, state.getX());
        Assert.assertEquals(3, state.getY());
        Assert.assertEquals(Compass.WEST, state.getCompass());
    }

    @Test
    public void testReportCommandForInactiveState() {
        // given
        final State current = new State(false, 2, 3, Compass.WEST);

        // when
        final State state = reportCommand.execute(current);

        // then
        Assert.assertNotNull(state);
        Assert.assertEquals(false, state.isActive());
        Assert.assertEquals(2, state.getX());
        Assert.assertEquals(3, state.getY());
        Assert.assertEquals(Compass.WEST, state.getCompass());
    }
}
