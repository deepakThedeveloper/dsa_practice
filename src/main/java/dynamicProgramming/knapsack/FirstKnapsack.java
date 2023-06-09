package dynamicProgramming.knapsack;

import matrix.Util;

public class FirstKnapsack {
    public static void main(String[] args) {
        int[] weight = {2, 5, 3, 4}; // 2-5, 2-1-4, 3-4,
        int[] value = {15, 14, 45, 30};
        int k = 7;

        int finalVal = printMaxValueTabulation(weight, value, k);
        System.out.println("max value tabulation:" + finalVal);

        int[][] dp = Util.getMatrix(weight.length, k+1, -1);
        int finalVal1 = maxValueRevisionMemoization(weight, value, k, weight.length-1, dp);
        System.out.println("max value memoization revision:" + finalVal1);

        int finalVal2 = maxValueRevisionTabulation(weight, value, k);
        System.out.println("max value tabulation revision:" + finalVal2);
;
    }

    private static int maxValueRevisionMemoization(int[] wt, int[] value, int sackWt, int n, int[][] dp){
        if(n==0){
            if(wt[n]<=sackWt) return value[n];
            return 0;
        }
        if(sackWt <= 0) return 0;
        if(dp[n][sackWt]!=-1) {
            return dp[n][sackWt];
        }

        int pick = wt[n]<=sackWt ? maxValueRevisionMemoization(wt, value, sackWt-wt[n], n-1, dp) + value[n]:0;
        int notPick = maxValueRevisionMemoization(wt, value, sackWt, n - 1, dp);

        return dp[n][sackWt] = Math.max(pick, notPick);
    }

    private static int maxValueRevisionTabulation(int[] wt, int[] val, int sackWt){
        int n = wt.length;
        int[][] dp = Util.getMatrix(n, sackWt+1, 0);
        for(int i=0; i<n; i++) {
            for(int j=0; j<=sackWt; j++) {
                if (wt[i] <= j) dp[i][j] = val[i];
            }
        }
        for(int i=1; i<n; i++){
            for(int j=1; j<=sackWt; j++){
                int notPick = dp[i-1][j];
                int pick = wt[i]<=j ? dp[i-1][j-wt[i]] + val[i]:0;

                dp[i][j] = Math.max(pick, notPick);
            }
        }
        Util.printMatrix(dp);
        return dp[n-1][sackWt];
    }

    private static int printMaxValueTabulation(int[] wt, int[] val, int k) {
        int[][] dp = new int[wt.length + 1][k + 1];
        for (int i = 0; i <= k; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= wt.length; i++) {
            dp[i][0] = 0;
        }

        int k1 = 0;
        for (int row = 1; row <= wt.length; row++) {
            for (int col = 1; col <= k; col++) {
                if (col < wt[k1]) {
                    dp[row][col] = dp[row - 1][col];
                } else {
                    int diff = col - wt[k1];
                    int v1 = dp[row - 1][diff];
                    int finalVal = v1 + val[k1];
                    if (finalVal > dp[row - 1][col]) {
                        dp[row][col] = finalVal;
                    } else {
                        dp[row][col] = dp[row - 1][col];
                    }
                }
            }
            k1++;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + ",");
            }
            System.out.println();
        }
        return dp[wt.length][k];
    }
}
