package dynamicProgramming;

import matrix.Util;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};

        int[][] dp = Util.getMatrix(a.length, a.length+1, -1);
        int lis1 = lisMemoizationRevision(0, -1, a, dp);
        System.out.println("memoization lis:"+lis1);

        int lis2 = lisTabulationRevision(a);
        System.out.println("tabulation lis:"+lis2);
    }

    private static int lisMemoizationRevision(int idx, int prev, int[] a, int[][] dp){
        if(idx==a.length) return 0;

        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
        int notTake = lisMemoizationRevision(idx+1, prev, a, dp);
        int take = Integer.MIN_VALUE;
        if(prev ==-1 || a[idx]>a[prev])
            take = lisMemoizationRevision(idx+1, idx, a, dp) + 1;

        return dp[idx][prev+1] = Math.max(notTake, take);
    }

    private static int lisTabulationRevision(int[] a){
        int n = a.length;
        int[][] dp = Util.getMatrix(n+1, n+1, 0);

        for(int i=n-1; i>=0; i--){
            for(int j=i-1; j>=-1; j--){
                int notTake = dp[i+1][j+1];
                int take = Integer.MIN_VALUE;
                if(j==-1 || a[i]>a[j]) {
                    take = dp[i+1][i+1] + 1;
                }
                dp[i][j+1] = Math.max(notTake, take);
            }
        }
        Util.printMatrix(dp);
        return dp[0][0];
    }
}
