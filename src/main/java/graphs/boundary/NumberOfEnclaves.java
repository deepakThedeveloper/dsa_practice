package graphs.boundary;

import java.util.GregorianCalendar;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int[][] mat = {
                {0,0,0,1},
                {0,1,1,0},
                {0,1,1,0},
                {0,0,0,1},
                {0,1,1,0}
        };

        int count = find1sFromWhichOuterMovementNotPossible(mat);
        System.out.println("total island from which escape is not possible:"+count);
    }

    /**
     * intution: traverse all boundary first and if 1 found on boundary apply dfs and move inside and mark visited all the
     * 1s connected with boundary.
     * in next step, just traverse whole matrix and see which 1s are not visited and count them. These inner 1s are
     * the one whom are not connected to 1 which is at boundary because if they were connected then it would have been
     * marked visited.
     */
    private static int find1sFromWhichOuterMovementNotPossible(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];
        int[] row = {-1, 0, 1, 0}; // up, down
        int[] col = {0, 1, 0, -1}; // right, left
        // checking for first and last row
        for(int c=0; c<m; c++){
            if(!visited[0][c] && mat[0][c]==1){
                mark(mat, 0, c, visited, row, col);
            }

            if(!visited[n-1][c] && mat[n-1][c]==1){
                mark(mat, n-1, c, visited, row, col);
            }
        }
        // checking for first and last col
        for(int r=0; r<n; r++){
            if(!visited[r][0] && mat[r][0]==1){
                mark(mat, r, 0, visited, row, col);
            }

            if(!visited[r][m-1] && mat[r][m-1]==1){
                mark(mat, r, m-1, visited, row, col);
            }
        }

        int count = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<m-1; j++){
                if(!visited[i][j] && mat[i][j]==1) {
                    visited[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    private static void mark(int[][] mat, int sr, int sc, boolean[][] visited, int[] row, int[] col){
        visited[sr][sc] = true;

        for(int i=0; i<4; i++){ // moving in 4 direction. up, down, left, right
            int nr = sr+row[i];
            int nc = sc+col[i];

            if(nr>=0 && nc>=0 && nr<mat.length && nc<mat[0].length && !visited[nr][nc] && mat[nr][nc] == 1){
                mark(mat, nr, nc, visited, row, col);
            }
        }
    }
}
