package dynamicProgramming.subset.permutation.group7_gapstrategy;

import matrix.Util;

public class BalloonBurst {
    public static void main(String[] args){
        int[] balloon = {2, 3, 1, 5, 6, 4};
        int maxProfit = maxProfitTabulationDirect(balloon);
        System.out.println(maxProfit);
    }

    private static int maxProfitTabulationDirect(int[] balloon){
        int n = balloon.length;
        int[][] dp = new int[n][n];

        int maxProfit = Integer.MIN_VALUE;
        for(int g=0; g<n; g++){
            for(int i=0, j=g; j<n; i++, j++){

                int max = Integer.MIN_VALUE;
                for(int k=i; k<=j; k++){
                    int leftBurstProfit = i==k ? 0 : dp[i][k-1];
                    int rightBurstProfit = k == j ? 0 : dp[k+1][j];

                    int currentBurstProfit = (i==0 ? 1 : balloon[i-1]) * balloon[k] * (j == n-1 ? 1 : balloon[j+1]);

                    int total = leftBurstProfit + rightBurstProfit + currentBurstProfit;
                    max = Math.max(max, total);
                }

                dp[i][j] = max;
                maxProfit = Math.max(maxProfit, dp[i][j]);
            }
        }

        Util.printMatrix(dp);
        return dp[0][n-1];
    }
}
