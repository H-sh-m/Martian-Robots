package com.hashim.mars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    @Test
    public void givenValidCoordinates_whenConstructGrid_thenReturnGrid() {
        Grid grid = new Grid(25, 25);
        assertEquals(grid.getXLimit(), 25);
        assertEquals(grid.getYLimit(), 25);
    }

    /**
     * The maximum value for any coordinate equal to 50.
     */
    @Test
    public void givenMaxValueCoordinates_whenConstructGrid_thenReturnGrid() {
        Grid grid = new Grid(50, 50);
        assertEquals(grid.getXLimit(), 50);
        assertEquals(grid.getYLimit(), 50);
    }

    /**
     * The maximum value for any coordinate is 50.
     */
    @Test
    public void givenXGreaterThan50_whenConstructGrid_thenThrowException() {
        IllegalArgumentException thrownException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Grid grid = new Grid(51, 25);
        });

        assertEquals("Invalid coordinates: The maximum value for any coordinate is 50 and not less than 0.", thrownException.getMessage());
    }

    /**
     * The maximum value for any coordinate is 50.
     */
    @Test
    public void givenYGreaterThan50_whenConstructGrid_thenThrowException() {
        IllegalArgumentException thrownException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Grid grid = new Grid(25, 51);
        });

        assertEquals("Invalid coordinates: The maximum value for any coordinate is 50 and not less than 0.", thrownException.getMessage());
    }

    /**
     * Grid coordinates cannot be negative
     */
    @Test
    public void givenNegativeXCoordinates_whenConstructGrid_thenThrowException() {
        IllegalArgumentException thrownException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Grid grid = new Grid(-1, 25);
        });

        assertEquals("Invalid coordinates: The maximum value for any coordinate is 50 and not less than 0.", thrownException.getMessage());
    }

    /**
     * Grid coordinates cannot be negative
     */
    @Test
    public void givenNegativeYCoordinates_whenConstructGrid_thenThrowException() {
        IllegalArgumentException thrownException = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Grid grid = new Grid(25, -1);
        });

        assertEquals("Invalid coordinates: The maximum value for any coordinate is 50 and not less than 0.", thrownException.getMessage());
    }

}
