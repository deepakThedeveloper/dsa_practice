package matrix.gold;

public class PathWithMaximumGold {
    public static void main(String[] args){
        int[][] grid = {
                {1, 0, 7},
                {2, 0, 6},
                {3, 4, 5},
                {0, 3, 0},
                {9, 0, 20},
        };
    }

    //leetcode tested: https://leetcode.com/problems/path-with-maximum-gold/description/
    private static int maxGold(int[][] grid){
        int n = grid.length, m = grid[0].length;

        int max = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int total = traverse(i, j, visited, grid);
                max = Math.max(max, total);
            }
        }
        return max;
    }

    private static int traverse(int sr, int sc, boolean[][] visited, int[][] grid){
        if(sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[0].length || visited[sr][sc] || grid[sr][sc] == 0) return 0;

        visited[sr][sc] = true;

        int r = traverse(sr, sc + 1, visited, grid);
        int d = traverse(sr + 1, sc, visited, grid);
        int l = traverse(sr, sc - 1, visited, grid);
        int u = traverse(sr - 1, sc, visited, grid);

        visited[sr][sc] = false;

        return Math.max(r, Math.max(d, Math.max(l, u))) + grid[sr][sc];
    }
}
