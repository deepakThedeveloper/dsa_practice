package recursion;

public class MazePathWithBlocker {
    public static void main(String[] args) {
        int[][] maze = {{0,1,0,0,0,0,0},
                        {0,1,0,1,1,1,0},
                        {0,0,0,0,0,0,0},
                        {1,0,1,1,0,1,1},
                        {1,0,1,1,0,1,1},
                        {1,0,0,0,0,0,0}};
//        int[][] visited = new int[maze.length][maze[0].length];
        findUniquePath(maze, 0, 0, "", new int[maze.length][maze[0].length]);
    }

    private static void findUniquePath(int[][] maze, int sr, int sc, String path, int[][] visited) {
        if(sr<0 || sr>= maze.length || sc<0 || sc>=maze[0].length || visited[sr][sc] == 1 || maze[sr][sc] == 1){
            return;
        }
        if(sr == maze.length-1 && sc==maze[0].length-1){
            System.out.println(path);
            return;
        }

        visited[sr][sc] = 1;
        findUniquePath(maze, sr, sc+1, path+"r", visited);
        findUniquePath(maze, sr+1, sc, path+"d", visited);
        findUniquePath(maze, sr, sc-1, path+"l", visited);
        findUniquePath(maze, sr-1, sc, path+"u", visited);
        visited[sr][sc] = 0;
    }
}
