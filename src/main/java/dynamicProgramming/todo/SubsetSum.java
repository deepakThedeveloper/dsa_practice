package dynamicProgramming.todo;

import matrix.Util;

public class SubsetSum {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};

        int target = 4;
        int[][] dp = Util.getMatrix(a.length, target+1, -1);
        int subsetCount = countSubsetSumMemoizationRevision(a, target, a.length-1, dp);
        Util.printMatrix(dp);
        System.out.println("memoization:"+subsetCount);

        int subsetCount1 = countSubsetSumTabulationRevision(a, target);
        System.out.println(subsetCount1);
    }

    private static int countSubsetSumMemoizationRevision(int[] a, int target, int n, int[][] dp){
        if (target == 0) return 1;
        if (target < 0 || n < 0) return 0;
        if(dp[n][target]!=-1) return dp[n][target];

        return dp[n][target] = countSubsetSumMemoizationRevision(a, target-a[n], n-1, dp)
                + countSubsetSumMemoizationRevision(a, target, n-1, dp);
    }

    //todo
    private static int countSubsetSumTabulationRevision(int[] a, int target){
        int[][] dp = Util.getMatrix(a.length, target+1, 0);
        for(int row = 0; row<a.length; row++){
            dp[row][0] = 1;
        }
        dp[0][a[0]] = 1;
        for (int i = 1; i <a.length; i++) {
            for(int j=1; j<=target; j++) {
                dp[i][j] = j-a[i] >= 0 ? dp[i-1][j - a[i]] + dp[i - 1][j] : 0;
            }
        }
        Util.printMatrix(dp);
        return dp[a.length-1][target];
    }
}
