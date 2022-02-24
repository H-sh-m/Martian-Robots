package com.hashim.mars;

public class main {
    public static void main(String[] args) {

        Grid grid = new Grid(5,3);

        Robot robot = new Robot(1, 1, "E", "RFRFRFRF", grid);
        robot.followInstructions();
        System.out.println(robot.getResult());

        robot = new Robot(3, 2, "N", "FRRFLLFFRRFLL", grid);
        robot.followInstructions();
        System.out.println(robot.getResult());

        robot = new Robot(0, 3, "W", "LLFFFLFLFL", grid);
        robot.followInstructions();
        System.out.println(robot.getResult());
    }
}
