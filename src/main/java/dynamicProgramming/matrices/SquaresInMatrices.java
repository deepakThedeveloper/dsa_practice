package dynamicProgramming.matrices;

import matrix.Util;

// use to count total squares in matrix, largest square with 1
public class SquaresInMatrices {
    public static void main(String[] args) {
        int[][] mat = {
                {0,1,0,1,0,1},
                {1,0,1,0,1,0},
                {0,1,1,1,1,0},
                {0,0,1,1,1,0},
                {1,1,1,1,1,1},
        };
        int squareCount = countSquare(mat);
        System.out.println(squareCount);
        int largestSquare = largestSquareWith1sInMatrix(mat);
        System.out.println(largestSquare);
    }

    private static int largestSquareWith1sInMatrix(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++){
            dp[i][0] = mat[i][0];
        }
        for(int i=0; i<m; i++){
            dp[0][i] = mat[0][i];
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(mat[i][j] != 0){
                    int v = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    dp[i][j] = v;
                    max = Math.max(v, max);
                }
            }
        }
        return max;
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
