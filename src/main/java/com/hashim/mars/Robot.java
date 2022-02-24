package com.hashim.mars;

public class Robot {

    private int currentXPosition, currentYPosition;
    private String currentOrientation;
    private String instruction;
    private Grid grid;

    public Robot(int currentXPosition, int currentYPosition, String currentOrientation, String instruction, Grid grid) {
        this.currentXPosition = currentXPosition;
        this.currentYPosition = currentYPosition;
        this.currentOrientation = currentOrientation;
        this.instruction = instruction;
        this.grid = grid;
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
