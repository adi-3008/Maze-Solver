package org.example;

import java.util.List;

public class DepthFirst {

    private static int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path){
        if (maze[y][x] == 9){
            path.add(x);
            path.add(y);
            return true;
        }
        if (maze[y][x] == 0){
            maze[y][x] = 2;
            for (int[] dir : directions) {
                int dr = x + dir[0];
                int dc = y + dir[1];
                if (isValid(maze, dr, dc) && searchPath(maze, x + dir[0], y + dir[1], path)){
                    path.add(x);
                    path.add(y);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isValid(int[][] maze, int x, int y){
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length;
    }
}
