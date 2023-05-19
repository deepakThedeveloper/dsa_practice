package dynamicProgramming;

import matrix.Util;

public class MinCostPath {
    public static void main(String[] args) {
        int[][] a = {{1,2}, {3,4}};

        int[][] dp = Util.getMatrix(a.length, a[0].length, -1);
        int minPath = findMinPathMemoization(a, 0, 0, dp);
        printMatrix(dp);
        System.out.println("original memoization:"+minPath);

        int[][] dp1 = Util.getMatrix(a.length, a[0].length, -1);
        int minPath1 = minCostTraversalMemoizationRevision(a, 0, 0, dp1);
        printMatrix(dp1);
        System.out.println("revision memoization:"+minPath1);

        int minPath2 = minCostTraversalTabulationRevision(a);
        System.out.println("revision tabulation:"+minPath2);
    }


    private static int minCostTraversalTabulationRevision(int[][] mat){
        int rlen = mat.length;
        int clen = mat[0].length;
        int[][] dp = Util.getMatrix(rlen, clen, -1);

        dp[rlen-1][clen-1] = mat[rlen-1][clen-1];

        for(int row = rlen-1; row>=0; row--){
            for(int col = clen-1; col>=0; col--){
                if(row == rlen-1 && col == clen-1) continue;
                int rightTraverse = col < clen-1 ? dp[row][col+1] : Integer.MAX_VALUE;
                int downTraverse = row < rlen -1 ? dp[row+1][col] : Integer.MAX_VALUE;

                dp[row][col] = Math.min(rightTraverse, downTraverse)+mat[row][col];
            }
        }

        printMatrix(dp);
        return dp[0][0];
    }

    private static void printMatrix(int[][] dp){
        int r = dp.length;
        int c = dp[0].length;
        for(int i=0; i< r; i++){
            for(int j=0; j<c; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int minCostTraversalMemoizationRevision(int[][] mat, int sr, int sc, int[][] dp) {
        if (sr == mat.length - 1 && sc == mat[0].length - 1) {
            return mat[sr][sc];
        }
        if (sr >= mat.length || sc >= mat[0].length) return Integer.MAX_VALUE;
        if(dp[sr][sc]!=-1) return dp[sr][sc];

        int rightTraverse = minCostTraversalMemoizationRevision(mat, sr, sc + 1, dp);
        int downTraverse = minCostTraversalMemoizationRevision(mat, sr + 1, sc, dp);

        return dp[sr][sc]= Math.min(rightTraverse, downTraverse) +  mat[sr][sc];
    }

    private static int findMinPathMemoization(int[][] a, int r, int c, int[][] dp) {
        if(r==a.length || c==a.length) return (int) 1e9;
        if(r==a.length-1 && c== a.length-1) return a[r][c];

        if(dp[r][c]!=-1) return dp[r][c];
        int right = findMinPathMemoization(a, r, c+1, dp);
        int down = findMinPathMemoization(a, r+1, c, dp);

        right = right == Integer.MAX_VALUE ? right : right+a[r][c];
        down = down == Integer.MAX_VALUE ? down : down+a[r][c];

        return dp[r][c] = Math.min(right, down);
    }
}
