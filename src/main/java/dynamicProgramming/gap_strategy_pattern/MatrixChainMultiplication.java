package dynamicProgramming.gap_strategy_pattern;

import matrix.Util;

public class MatrixChainMultiplication {
    public static void main(String[] args){
        int[] dimensions = {10, 20, 30, 40, 50, 60};
        int minOps = minOperationsTabulationDirect(dimensions);
        System.out.println(minOps);
    }

    //refer: /resources/matrix_chain_multiplication.jpg
    private static int minOperationsTabulationDirect(int[] dimensions){
        int n = dimensions.length - 1;
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0, k=i; k<n; j++, k++){
                if(k==0) dp[i][j] = 0;
                else if(k==1)dp[i][j] = dimensions[i] * dimensions[j] * dimensions[j+1];
                else {
                    int min = Integer.MAX_VALUE;
                    for (int m = 0; m < k; m++) {
                        // dp -> j - m = left half, m+1 - k = right half
                        // arr -> j - m+1 = matrix dimension of left half, m+1 - k+1 = matrix dimension right half
                        int sum = dp[j][m] + dp[m + 1][k];
                        int mul = dimensions[j] * dimensions[m+1] * dimensions[k+1];

                        min = Math.min(min, sum + mul);
                    }
                    dp[i][j] = min;
                }
            }
        }

        Util.printMatrix(dp);
        return dp[0][n-1];
    }
}
