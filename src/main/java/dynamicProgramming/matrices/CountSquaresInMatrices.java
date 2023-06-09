package dynamicProgramming.matrices;

import matrix.Util;

import java.util.Arrays;

public class CountSquaresInMatrices {
    public static void main(String[] args) {
        int[][] mat = {{1,1,1},{1,1,1},{1,1,1}};
        int squareCount = countSquare(mat);
        System.out.println(squareCount);
    }
    private static int countSquare(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            dp[i][0] = mat[i][0];
        }
        for(int i=0; i<m; i++){
            dp[0][i] = mat[0][i];
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(mat[i][j] != 0){
                    int v = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    dp[i][j] = v;
                }
            }
        }
        int sum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                sum += dp[i][j];
            }
        }
        Util.printMatrix(dp);
        return sum;
    }
}
