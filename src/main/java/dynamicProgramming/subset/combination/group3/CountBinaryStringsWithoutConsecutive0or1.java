package dynamicProgramming.subset.combination.group3;

import matrix.Util;

public class CountBinaryStringsWithoutConsecutive0or1 {
    public static void main(String[] args) {
        int n=3;
        int[][] dp = Util.getMatrix(2, n+1, 0);
        int sum = countBSMemoization(n,  -1, dp);
        System.out.println("memoization:"+sum);

        int sum1 = countBSTabulationDirect(n);
        System.out.println("tabulation:"+sum1);
    }

    private static int countBSTabulationDirect(int n){
        int[][] dp = new int[2][n+1];
        dp[0][1] = dp[1][1] = 1;

        for(int c=2; c<=n; c++){
            dp[0][c] = dp[1][c-1];
            dp[1][c] = dp[0][c-1] + dp[1][c-1];
        }
        Util.printMatrix(dp);
        return dp[0][n] + dp[1][n];
    }

    private static int countBSMemoization(int n, int prevChar, int[][] dp) {
        if(n==0){
            return 1;
        }
        if(prevChar != -1 && dp[prevChar][n] != 0) {
            return dp[prevChar][n];
        }
        int take = 0;
        if(prevChar != 0)
            take = countBSMemoization(n-1, 0, dp);
        int notTake = countBSMemoization(n-1, 1, dp);

        int total = take + notTake;
        if(prevChar != -1) dp[prevChar][n] = total;
        return total;
    }
}
