package dynamicProgramming.subset.combination.group1;

import matrix.Util;

public class BoundedKnapsack {
    public static void main(String[] args) {
        int[] weight = {2, 5, 3, 4}; // 2-5, 2-1-4, 3-4,
        int[] value = {15, 14, 45, 30};
        int k = 7;

        int[][] dp = Util.getMatrix(weight.length, k+1, -1);
        int finalVal1 = maxValueRevisionMemoization(weight, value, k, weight.length-1, dp);
        System.out.println("max value memoization revision:" + finalVal1);

        int finalVal2 = maxValueRevisionTabulation(weight, value, k);
        System.out.println("max value tabulation revision:" + finalVal2);

        int finalVal3 = maxValueTabulationDirect(weight, value, k);
        System.out.println("max value tabulation direct:" + finalVal3);
    }

    private static int maxValueTabulationDirect(int[] wt, int[] value, int sackWt){
        int n = wt.length;
        int[][] dp = new int[n+1][sackWt+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=sackWt; j++){
                if(wt[i-1]>j) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                int notPick = dp[i-1][j];
                int pick = dp[i-1][j-wt[i-1]] + value[i-1];

                dp[i][j] = Math.max(notPick, pick);
            }
        }
        Util.printMatrix(dp);
        return dp[n][sackWt];
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
        for(int i=0; i<=sackWt; i++){
            if(wt[0] <= i){
                dp[0][i] = val[0];
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
}
