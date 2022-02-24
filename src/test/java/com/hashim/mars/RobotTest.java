package com.hashim.mars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    /**
     * All instruction strings will be less than 100 characters in length.
     */
    @Test
    public void givenInstructionsGreaterThan100_whenConstructRobot_thenThrowException() {
        int initialX = 1, initialY = 1;
        String initialOrientation = "N";
        String instruction = "FRRFLLFFRRFLLLLFFFLFLFLRFRFRFRFFRRFLLFFRRFLLLLFFFLFLFLRFRFRFRFFRRFLLFFRRFLLLLFFFLFLFLRFRFRFRFFRRFLLF";

        IllegalArgumentException thrownException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        });

        assertEquals("Instruction string must be less than 100 characters in length.", thrownException.getMessage());
    }

    /**
     * Initial robot X coordinate cannot be negative.
     */
    @Test
    public void givenNegativeInitialXPosition_whenConstructRobot_thenThrowException() {
        int initialX = -1, initialY = 1;
        String initialOrientation = "N";
        String instruction = "RR";

        IllegalArgumentException thrownException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        });

        assertEquals("Robot position is outside grid bounds.", thrownException.getMessage());
    }

    /**
     * Initial robot Y coordinate cannot be negative.
     */
    @Test
    public void givenNegativeInitialYPosition_whenConstructRobot_thenThrowException() {
        int initialX = 1, initialY = -1;
        String initialOrientation = "N";
        String instruction = "RR";

        IllegalArgumentException thrownException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        });

        assertEquals("Robot position is outside grid bounds.", thrownException.getMessage());
    }

    /**
     * Initial robot X coordinate cannot be greater than grid X limit.
     */
    @Test
    public void givenInitialXPositionGreaterThanGridY_whenConstructRobot_thenThrowException() {
        int initialX = 6, initialY = 1;
        String initialOrientation = "N";
        String instruction = "RR";

        assertTrue(initialX > this.grid.getXLimit());

        IllegalArgumentException thrownException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        });

        assertEquals("Robot position is outside grid bounds.", thrownException.getMessage());
    }

    /**
     * Initial robot Y coordinate cannot be greater than grid Y limit.
     */
    @Test
    public void givenInitialYPositionGreaterThanGridY_whenConstructRobot_thenThrowException() {
        int initialX = 1, initialY = 4;
        String initialOrientation = "N";
        String instruction = "RR";

        assertTrue(initialY > this.grid.getYLimit());

        IllegalArgumentException thrownException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        });

        assertEquals("Robot position is outside grid bounds.", thrownException.getMessage());
    }

}
