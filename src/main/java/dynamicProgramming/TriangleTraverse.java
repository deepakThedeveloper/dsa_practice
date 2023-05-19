package dynamicProgramming;

import matrix.Util;

public class TriangleTraverse {
    public static void main(String[] args) {
        int[][] mat = {{1},{2,3},{3,6,7},{8,9,6,8}};

        int[][] dp = Util.getTriangleMatrix(mat);
        int minCost = minPathTraversalMemoizationRevision(mat, 0, 0, 0, dp);
        System.out.println("min cost memoization:"+minCost);

        int minCost1 = minPathTraversalTabulationRevision(mat);
        System.out.println("min cost tabulation:"+minCost1);
    }

    private static int minPathTraversalMemoizationRevision(int[][] mat, int sr, int sc, int level, int[][] dp){
        if(sr>=mat.length || sc>=mat[level].length) return Integer.MAX_VALUE;
        if(sr == mat.length-1) return mat[sr][sc];

        if(dp[sr][sc] == -1) return dp[sr][sc];
        int downTraversal = minPathTraversalMemoizationRevision(mat, sr+1, sc, level+1, dp);
        int diagonalTraversal = minPathTraversalMemoizationRevision(mat, sr+1, sc+1, level+1, dp);

        return dp[sr][sc] = Math.min(downTraversal, diagonalTraversal) + mat[sr][sc];
    }

    private static int minPathTraversalTabulationRevision(int[][] mat){
        int rlen = mat.length;
        int clen = mat[rlen-1].length;

        int[][] dp = new int[rlen][clen];
        for(int i=0; i<clen; i++){
            dp[rlen-1][i] = mat[rlen-1][i];
        }

        for(int row = rlen-1; row>=0; row--){
            int colLength = mat[row].length;
            for(int col = colLength-1; col>=0; col--){
                if(row == rlen-1) continue;
                int downTraversal = row < rlen-1 ? dp[row+1][col] : Integer.MAX_VALUE;
                int diagonalTraversal = col < clen-1 ? dp[row+1][col+1] : Integer.MAX_VALUE;

                dp[row][col] = Math.min(downTraversal, diagonalTraversal) + mat[row][col];
            }
        }
        return dp[0][0];
    }
}
