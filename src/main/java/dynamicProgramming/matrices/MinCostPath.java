package dynamicProgramming.matrices;

import lombok.AllArgsConstructor;
import matrix.Util;

import java.util.LinkedList;
import java.util.Queue;

public class MinCostPath {
    public static void main(String[] args) {
        int[][] a = {
                {0,1,4,2},
                {4,3,6,5},
                {1,2,4,1},
                {2,0,7,3}
        };
        printTraversalPathOfMinCostPath(a);

//        int[][] dp = Util.getMatrix(a.length, a[0].length, -1);
//        int minPath = findMinPathMemoization(a, 0, 0, dp);
//        Util.printMatrix(dp);
//        System.out.println("original memoization:"+minPath);
//
//        int[][] dp1 = Util.getMatrix(a.length, a[0].length, -1);
//        int minPath1 = minCostTraversalMemoizationRevision(a, 0, 0, dp1);
//        Util.printMatrix(dp1);
//        System.out.println("revision memoization:"+minPath1);
//
//        int minPath2 = minCostTraversalTabulationRevision(a);
//        System.out.println("revision tabulation:"+minPath2);
    }


    private static void printTraversalPathOfMinCostPath(int[][] mat){
        int n = mat.length;
        int[][] dp = new int[n][n];
        dp[n-1][n-1] = mat[n-1][n-1];

        for(int c = n-2; c>=0; c--)
            dp[n-1][c] = mat[n-1][c] + dp[n-1][c+1];
        for(int r = n-2; r>=0; r--)
            dp[r][n-1] = mat[r][n-1] + dp[r+1][n-1];

        for(int r = n-2; r>=0; r--){
            for(int c = n-2; c>=0; c--){
                dp[r][c] = Math.min(dp[r][c+1],dp[r+1][c]) + mat[r][c];
            }
        }
        System.out.println("direct tabulation");
        Util.printMatrix(dp);
        System.out.println("min cost:"+dp[0][0]);

        printPath(mat, dp);
    }

    private static void printPath(int[][] mat, int[][] dp){
        int rows = mat.length, cols = mat[0].length;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, "S"));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int r = pair.r, c = pair.c;
            if(r == rows-1 && c == cols-1){
                System.out.println(pair.pos);
                continue;
            }
            if(c+1>=cols){
                queue.add(new Pair(r+1, c, pair.pos +"V"));
            }
            else if(r+1 >= rows){
                queue.add(new Pair(r, c+1, pair.pos +"H"));
            }
            else if(dp[r][c+1] < dp[r+1][c]){
                queue.add(new Pair(r, c+1, pair.pos +"H"));
            }
            else if(dp[r][c+1] > dp[r+1][c]) {
                queue.add(new Pair(r+1, c, pair.pos +"V"));
            }
            else{
                queue.add(new Pair(r, c+1, pair.pos +"H"));
                queue.add(new Pair(r+1, c, pair.pos +"V"));
            }
        }
    }

    @AllArgsConstructor
    static class Pair{
        int r;
        int c;
        String pos;
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

        Util.printMatrix(dp);
        return dp[0][0];
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
