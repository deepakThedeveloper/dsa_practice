package graphs.boundary;

import matrix.Util;

public class Replace0WithX {
    public static void main(String[] args) {
        Character[][] c = {
                {'X','X','X','X','X'},
                {'X','0','0','X','0'},
                {'X','X','0','X','0'},
                {'X','0','X','0','X'},
                {'0','0','X','X','X'}
        };
        Util.printMatrix(c);
        System.out.println("=================================");
        replaceViaDFS(c);
        Util.printMatrix(c);
    }

    private static void replaceViaDFS(Character[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];
        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        for(int j=0; j<m; j++){
            if(visited[0][j] || mat[0][j] == 'X') continue;
            mark(mat, 0, j, visited, row, col);

            if(visited[n-1][j] || mat[n-1][j] == 'X') continue;
            mark(mat, n-1, j, visited, row, col);
        }

        for(int j=0; j<n; j++){
            if(visited[j][0] || mat[j][0] == 'X') continue;
            mark(mat, j, 0, visited, row, col);

            if(visited[j][m-1] || mat[j][m-1] == 'X') continue;
            mark(mat, j, m-1, visited, row, col);
        }

        for(int i=1; i<n-1; i++){
            for(int j=1; j<m-1; j++){
                if(visited[i][j] || mat[i][j] == 'X') continue;
                visited[i][j] = true;
                mat[i][j] = 'X';
            }
        }
    }

    private static void mark(Character[][] mat, int sr, int sc, boolean[][] visited, int[] row, int[] col){
        if(visited[sr][sc] || mat[sr][sc] == 'X'){
            return;
        }

        visited[sr][sc] = true;
        for(int i = 0; i<4; i++){
            int nr = sr+row[i];
            int nc = sc+col[i];
            if(nr<0 || nc<0 || nr>=mat.length || nc>=mat[0].length) continue;
            mark(mat, nr, nc, visited, row, col);

        }
    }
}
