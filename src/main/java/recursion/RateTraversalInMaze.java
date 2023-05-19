package recursion;

import java.util.ArrayList;
import java.util.List;

public class RateTraversalInMaze {
    public static void main(String[] args) {
        int[][] maze = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        List<String> paths = new ArrayList<>();
        int n = maze.length;
        findPaths(maze, paths, "", 0, 0, new boolean[n][n], n);

        System.out.println(paths);
    }

    private static void findPaths(int[][] maze, List<String> paths, String op, int sr, int sc, boolean[][] visited, int n){
        if(sr == n-1 && sc==n-1){
            paths.add(op);
            return;
        }
        if(sr>n-1 || sc>n-1 || sr<0 || sc<0 || maze[sr][sc] == 0 || visited[sr][sc])return;

        visited[sr][sc] = true;
        findPaths(maze, paths, op+"R", sr, sc+1, visited, n);
        findPaths(maze, paths, op+"D", sr+1, sc, visited, n);
        findPaths(maze, paths, op+"L", sr, sc-1, visited, n);
        findPaths(maze, paths, op+"U", sr-1, sc, visited, n);
        visited[sr][sc] = false;
    }
}
