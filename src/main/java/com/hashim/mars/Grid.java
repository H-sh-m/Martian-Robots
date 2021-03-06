package com.hashim.mars;

import java.util.ArrayList;

public class Grid {

    private int xLimit;
    private int yLimit;
    private ArrayList<Coordinate> scentedCoordinateList = new ArrayList<Coordinate>();

    public Grid(int xLimit, int yLimit) {
        if (xLimit < 0 || yLimit < 0 || xLimit > 50 || yLimit > 50)
            throw new IllegalArgumentException("Invalid coordinates: The maximum value for any coordinate is 50 and not less than 0.");
        else {
            this.xLimit = xLimit;
            this.yLimit = yLimit;
        }
    }

    public int getXLimit() {
        return xLimit;
    }

    public int getYLimit() {
        return yLimit;
    }

    public boolean hasScentAtPosition(int x, int y) {
        return scentedCoordinateList.contains(new Coordinate(x, y));
    }

    /**
     * Since the grid is rectangular and bounded (...yes Mars is a strange planet), a robot that
     * moves “off” an edge of the grid is lost forever. However, lost robots leave a robot “scent” that
     * prohibits future robots from dropping off the world at the same grid point. The scent is left at
     * the last grid position the robot occupied before disappearing over the edge.
     *
     * @param previousX
     * @param previousY
     */
    public void addScentToPosition(int previousX, int previousY) {
        scentedCoordinateList.add(new Coordinate(previousX, previousY));
    }
}
