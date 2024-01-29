package Meta;
import java.util.*;

//You are controlling a robot that is located somewhere in a room. The room is modeled as an m x n binary grid where 0 represents a wall and 1 represents an empty slot.
//
//The robot starts at an unknown location in the room that is guaranteed to be empty, and you do not have access to the grid, but you can move the robot using the given API Robot.
//You are tasked to use the robot to clean the entire room (i.e., clean every empty cell in the room). The robot with the four given APIs can move forward, turn left, or turn right. Each turn is 90 degrees.
//When the robot tries to move into a wall cell, its bumper sensor detects the obstacle, and it stays on the current cell.
//Design an algorithm to clean the entire room using the following APIs
public class RobotRoomCleaner {
    Robot robot;
    int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    Set<Pair<Integer, Integer>> visited = new HashSet();

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backtrack(0, 0, 0);
    }

    public void backtrack(int row, int col, int d){
        visited.add(new Pair(row, col));
        robot.clean();

        for(int i = 0; i < 4; i++){
            int newD = (d + i) % 4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];
            if(!visited.contains(new Pair(newRow, newCol)) && robot.move()){
                backtrack(newRow, newCol, newD);
                goBack();
            }
            robot.turnRight();
        }
    }
    public void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
