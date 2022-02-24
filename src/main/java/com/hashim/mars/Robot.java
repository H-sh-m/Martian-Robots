package com.hashim.mars;

public class Robot {

    private int currentXPosition, currentYPosition;
    private String currentOrientation;
    private String instruction;
    private Grid grid;

    public Robot(int currentXPosition, int currentYPosition, String currentOrientation, String instruction, Grid grid) {
        if(instruction.length() >= 100) {
            throw new IllegalArgumentException("Instruction string must be less than 100 characters in length.");
        }
        else if(currentXPosition > grid.getXLimit() || currentYPosition > grid.getYLimit() || currentXPosition < 0 || currentYPosition < 0) {
            throw new IllegalArgumentException("Robot position is outside grid bounds.");
        }
        else {
            this.currentXPosition = currentXPosition;
            this.currentYPosition = currentYPosition;
            this.currentOrientation = currentOrientation;
            this.instruction = instruction;
            this.grid = grid;
        }
    }

    public int getCurrentXPosition() {
        return currentXPosition;
    }

    public int getCurrentYPosition() {
        return currentYPosition;
    }

    public String getCurrentOrientation() {
        return currentOrientation;
    }

    public String getInstruction() {
        return instruction;
    }

    public Grid getGrid() {
        return grid;
    }
}
