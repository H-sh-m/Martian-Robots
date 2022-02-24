package com.hashim.mars;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Coordinate)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Coordinate c = (Coordinate) o;

        // Compare the data members and return accordingly
        return this.getX() == c.getX() && this.getY() == c.getY();
    }

}
