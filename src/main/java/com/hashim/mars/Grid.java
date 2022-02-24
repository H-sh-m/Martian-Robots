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

    public void addScentToPosition(int previousX, int previousY) {
        scentedCoordinateList.add(new Coordinate(previousX, previousY));
    }
}
