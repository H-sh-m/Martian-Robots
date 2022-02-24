package com.hashim.mars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {

    private Grid grid;

    @BeforeEach
    public void init() {
        this.grid = new Grid(5, 3);
    }

    @Test
    public void givenValidConstructArgs_whenConstructRobot_thenReturnRobotWithSetValues() {
        int initialX = 1, initialY = 1;
        String initialOrientation = "N";
        String instruction = "RR";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        assertEquals(robot.getCurrentYPosition(), initialX);
        assertEquals(robot.getCurrentXPosition(), initialY);
        assertEquals(robot.getCurrentOrientation(), initialOrientation);
        assertEquals(robot.getInstruction(), instruction);
        assertEquals(robot.getGrid().getXLimit(), 5);
    }
}
