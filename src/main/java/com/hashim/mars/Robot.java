package com.hashim.mars;

public class Robot {

    private int currentXPosition, currentYPosition;
    private String currentOrientation;
    private String instructions;
    private Grid grid;
    private boolean isLost;

    public Robot(int currentXPosition, int currentYPosition, String currentOrientation, String instruction, Grid grid) {
        this.currentXPosition = currentXPosition;
        this.currentYPosition = currentYPosition;
        this.currentOrientation = currentOrientation;
        this.instructions = instruction;
        this.grid = grid;
        this.isLost = false;

        if(instruction.length() >= 100) {
            throw new IllegalArgumentException("Instruction string must be less than 100 characters in length.");
        }
        if(isPositionOffGrid(currentXPosition, currentYPosition)) {
            throw new IllegalArgumentException("Robot position is outside grid bounds.");
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
                case 'R': // right
                    turnRight();
                    break;
                default:
                    throw new UnsupportedOperationException("Instruction not recognised: " + instruction);
            }
        }
    }

    /**
     * The robot turns right 90 degrees and remains on the current grid point.
     */
    private void turnRight() {
        switch (this.currentOrientation) {
            case "N":
                this.currentOrientation = "E";
                break;
            case "E":
                this.currentOrientation = "S";
                break;
            case "S":
                this.currentOrientation = "W";
                break;
            case "W":
                this.currentOrientation = "N";
                break;
            default:
                throw new RuntimeException("Orientation not recognised");
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
        boolean isScented = grid.hasScentAtPosition(currentXPosition, currentYPosition);

        // save previous positions before they are changed
        int previousX = this.currentXPosition;
        int previousY = this.currentYPosition;

        // move only if the location isn't scented
        switch (this.currentOrientation) {
            case "N":
                if (!((isScented) && (this.currentYPosition + 1 > this.grid.getYLimit())))
                    this.currentYPosition += 1;
                break;
            case "S":
                if (!((isScented) && (this.currentYPosition - 1 < 0)))
                    this.currentYPosition -= 1;
                break;
            case "E":
                if (!((isScented) && (this.currentXPosition + 1 > this.grid.getXLimit())))
                    this.currentXPosition += 1;
                break;
            case "W":
                if (!((isScented) && (this.currentXPosition - 1 < 0)))
                    this.currentXPosition -= 1;
                break;
            default:
                throw new RuntimeException("Orientation not recognised");
        }

        // Check if robot has fallen off grid
        if(isPositionOffGrid(currentXPosition, currentYPosition)) {
            // The scent is left at the last grid position the robot occupied before disappearing over the edge.
            grid.addScentToPosition(previousX,previousY);
            this.isLost = true;
        }
    }

    /**
     *
     * @return true if the position is off the grid, false if the position is on the grid.
     */
    private boolean isPositionOffGrid(int x, int y) {
        return x > grid.getXLimit() || y > grid.getYLimit() || x < 0 || y < 0;
    }

    public String getResult() {
        return "" + this.currentXPosition + " " + this.currentYPosition + " " + this.currentOrientation + getLostStr();
    }

    public String getLostStr() {
        if (isLost)
            return " LOST";
        return "";
    }
}
