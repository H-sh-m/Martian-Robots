package com.hashim.mars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {

    private Grid grid;

    @BeforeEach
    public void init() {
        this.grid = new Grid(25, 25);
    }

    @Test
    public void givenValidCoordinates_whenConstructGrid_thenReturnGrid() {
        assertEquals(grid.getXLimit(), 25);
        assertEquals(grid.getYLimit(), 25);
    }

}
