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
        // Assert that robot parameters were correctly set:
        assertEquals(robot.getCurrentYPosition(), initialX);
        assertEquals(robot.getCurrentXPosition(), initialY);
        assertEquals(robot.getCurrentOrientation(), initialOrientation);
        assertEquals(robot.getInstructions(), instruction);
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

        // Assert that an exception is thrown
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

        // Assert that an exception is thrown
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

        // Assert that an exception is thrown
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

        // Check that initial robot X position is greater than the grid limit
        assertTrue(initialX > this.grid.getXLimit());

        // Assert that an exception is thrown
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

        // Check that initial robot Y position is greater than the grid limit
        assertTrue(initialY > this.grid.getYLimit());

        // Assert that an exception is thrown
        IllegalArgumentException thrownException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        });

        assertEquals("Robot position is outside grid bounds.", thrownException.getMessage());
    }

    @Test
    public void givenInitialNorthAndForwardInstruction_whenRobotFollowInstructions_thenRobotMovesForward() {
        int initialX = 0, initialY = 0;
        String initialOrientation = "N";
        String instruction = "FFF";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        // Assert that robot has moved North 3 times from initial position
        assertEquals(robot.getCurrentYPosition(), 3);
    }

    @Test
    public void givenInitialSouthAndForwardInstruction_whenRobotFollowInstructions_thenRobotMovesForward() {
        int initialX = 0, initialY = 3;
        String initialOrientation = "S";
        String instruction = "FFF";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        // Assert that robot has moved South 3 times from initial position
        assertEquals(robot.getCurrentYPosition(), 0);
    }

    @Test
    public void givenInitialEastAndForwardInstruction_whenRobotFollowInstructions_thenRobotMovesForward() {
        int initialX = 0, initialY = 0;
        String initialOrientation = "E";
        String instruction = "FFF";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        // Assert that robot has moved East 3 times from initial position
        assertEquals(robot.getCurrentXPosition(), 3);
    }

    @Test
    public void givenInitialWestAndForwardInstruction_whenRobotFollowInstructions_thenRobotMovesForward() {
        int initialX = 4, initialY = 0;
        String initialOrientation = "W";
        String instruction = "FFF";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        // Assert that robot has moved West 3 times from initial position
        assertEquals(robot.getCurrentXPosition(), 1);
    }

    @Test
    public void givenInitialNorthAndTurnLeftInstruction_whenRobotFollowInstruction_thenRobotTurnsLeft() {
        int initialX = 4, initialY = 0;
        String initialOrientation = "N";
        String instruction = "LLL";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        // Assert that robot has moved West 3 times from initial position
        assertEquals(robot.getCurrentOrientation(), "E");
    }

    @Test
    public void givenInitialWestAndTurnLeftInstruction_whenRobotFollowInstruction_thenRobotTurnsLeft() {
        int initialX = 4, initialY = 0;
        String initialOrientation = "W";
        String instruction = "LLL";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        // Assert that robot has moved West 3 times from initial position
        assertEquals(robot.getCurrentOrientation(), "N");
    }

    @Test
    public void givenInitialSouthAndTurnLeftInstruction_whenRobotFollowInstruction_thenRobotTurnsLeft() {
        int initialX = 4, initialY = 0;
        String initialOrientation = "S";
        String instruction = "LLL";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        // Assert that robot has moved West 3 times from initial position
        assertEquals(robot.getCurrentOrientation(), "W");
    }

    @Test
    public void givenInitialEastAndTurnLeftInstruction_whenRobotFollowInstruction_thenRobotTurnsLeft() {
        int initialX = 4, initialY = 0;
        String initialOrientation = "E";
        String instruction = "LLL";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        // Assert that robot has moved West 3 times from initial position
        assertEquals(robot.getCurrentOrientation(), "S");
    }

    @Test
    public void givenInitialNorthAndTurnRightInstruction_whenRobotFollowInstruction_thenRobotTurnsLeft() {
        int initialX = 4, initialY = 0;
        String initialOrientation = "N";
        String instruction = "RRR";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        // Assert that robot has moved West 3 times from initial position
        assertEquals(robot.getCurrentOrientation(), "W");
    }

    @Test
    public void givenInitialEastAndTurnRightInstruction_whenRobotFollowInstruction_thenRobotTurnsLeft() {
        int initialX = 4, initialY = 0;
        String initialOrientation = "E";
        String instruction = "RRR";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        // Assert that robot has moved West 3 times from initial position
        assertEquals(robot.getCurrentOrientation(), "N");
    }

    @Test
    public void givenInitialSouthAndTurnRightInstruction_whenRobotFollowInstruction_thenRobotTurnsLeft() {
        int initialX = 4, initialY = 0;
        String initialOrientation = "S";
        String instruction = "RRR";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        // Assert that robot has moved West 3 times from initial position
        assertEquals(robot.getCurrentOrientation(), "E");
    }

    @Test
    public void givenInitialWestAndTurnRightInstruction_whenRobotFollowInstruction_thenRobotTurnsLeft() {
        int initialX = 4, initialY = 0;
        String initialOrientation = "W";
        String instruction = "RRR";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        // Assert that robot has moved West 3 times from initial position
        assertEquals(robot.getCurrentOrientation(), "S");
    }

    @Test
    public void givenForwardAndLeftAndRightInstruction_whenRobotFollowInstruction_thenRobotMoves() {
        int initialX = 1, initialY = 1;
        String initialOrientation = "N";
        String instruction = "RFRFRFRFLF";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        assertEquals(robot.getCurrentXPosition(), 0);
        assertEquals(robot.getCurrentYPosition(), 1);
        assertEquals(robot.getCurrentOrientation(), "W");
    }

    @Test
    public void givenRobotMovesOffNorthEdge_whenRobotFollowInstruction_thenGridPointHasScent() {
        int initialX = 1, initialY = 1;
        String initialOrientation = "N";
        String instruction = "FFF";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        assertEquals(robot.getCurrentYPosition(), 4);
        assertTrue(4 > this.grid.getYLimit());
        assertTrue(this.grid.hasScentAtPosition(robot.getCurrentXPosition(), robot.getCurrentYPosition()-1));
    }

    @Test
    public void givenRobotMovesOffEastEdge_whenRobotFollowInstruction_thenGridPointHasScent() {
        int initialX = 1, initialY = 1;
        String initialOrientation = "E";
        String instruction = "FFFFF";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        assertEquals(robot.getCurrentXPosition(), 6);
        assertTrue(6 > this.grid.getXLimit());
        assertTrue(this.grid.hasScentAtPosition(robot.getCurrentXPosition()-1, robot.getCurrentYPosition()));
    }

    @Test
    public void givenRobotMovesOffSouthEdge_whenRobotFollowInstruction_thenGridPointHasScent() {
        int initialX = 1, initialY = 1;
        String initialOrientation = "S";
        String instruction = "FF";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        assertEquals(robot.getCurrentYPosition(), -1);
        assertTrue(this.grid.hasScentAtPosition(robot.getCurrentXPosition(), robot.getCurrentYPosition()+1));
    }

    @Test
    public void givenRobotMovesOffWestEdge_whenRobotFollowInstruction_thenGridPointHasScent() {
        int initialX = 1, initialY = 1;
        String initialOrientation = "W";
        String instruction = "FF";

        Robot robot = new Robot(initialX, initialY, initialOrientation, instruction, this.grid);
        robot.followInstructions();

        assertEquals(robot.getCurrentXPosition(), -1);
        assertTrue(this.grid.hasScentAtPosition(robot.getCurrentXPosition()+1, robot.getCurrentYPosition()));
    }


}
