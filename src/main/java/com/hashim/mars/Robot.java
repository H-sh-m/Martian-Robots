package com.hashim.mars;

public class Robot {

    private int currentXPosition, currentYPosition;
    private String currentOrientation;
    private String instructions;
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
            this.instructions = instruction;
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

    public String getInstructions() {
        return instructions;
    }

    public Grid getGrid() {
        return grid;
    }

    public void followInstructions() {
        // for each character in the instruction string
        for (int i = 0; i < this.instructions.length(); i++){
            char instruction = instructions.charAt(i);
            //Process the action
            //A robot instruction is a string of the letters “L”, “R”, and “F”
            switch (instruction) {
                case 'F': // forward
                    moveForwardOne();
                    break;
                case 'L': // left
                    turnLeft();
                    break;
                default:
                    throw new UnsupportedOperationException("Instruction not recognised: " + instruction);
            }
        }
    }

    /**
     * The robot turns left 90 degrees and remains on the current grid point.
     */
    private void turnLeft() {
        switch (this.currentOrientation) {
            case "N":
                this.currentOrientation = "W";
                break;
            case "W":
                this.currentOrientation = "S";
                break;
            case "S":
                this.currentOrientation = "E";
                break;
            case "E":
                this.currentOrientation = "N";
                break;
            default:
                throw new RuntimeException("Orientation not recognised");
        }
    }

    /**
     * The robot moves forward one grid point in the direction of the current
     * orientation and maintains the same orientation.
     */
    private void moveForwardOne() {
        switch (this.currentOrientation) {
            case "N":
                this.currentYPosition += 1;
                break;
            case "S":
                this.currentYPosition -= 1;
                break;
            case "E":
                this.currentXPosition += 1;
                break;
            case "W":
                this.currentXPosition -= 1;
                break;
            default:
                throw new RuntimeException("Orientation not recognised");
        }
    }
}
