package com.hashim.mars;

public class Grid {

    private int xLimit;
    private int yLimit;

    public Grid(int xLimit, int yLimit) {
        this.xLimit = xLimit;
        this.yLimit = yLimit;
    }

    public int getXLimit() {
        return xLimit;
    }

    public void setXLimit(int xLimit) {
        this.xLimit = xLimit;
    }

    public int getYLimit() {
        return yLimit;
    }

    public void setYLimit(int yLimit) {
        this.yLimit = yLimit;
    }
}
