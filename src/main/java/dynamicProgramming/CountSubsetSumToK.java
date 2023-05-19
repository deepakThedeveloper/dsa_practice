package dynamicProgramming;

import matrix.Util;

public class CountSubsetSumToK {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int k = 5;

        int count = getCountOfSubsetSumRecursion(a.length-1, k, a);
        System.out.println("recursion:"+count);

        int[][] dp = Util.getMatrix(a.length, k+1, -1);
        int count1 = getCountOfSubsetSumMemoization(a.length-1, k, a, dp);
        System.out.println("memoization:"+count1);

        int count2 = getCountOfSubsetTabulation(a, a.length, k);
        System.out.println("tabulation1::"+count2);

        int count3 = countSubsetWithKTargetRevision(a, k);
        System.out.println("tabulation revision:"+count3);
    }

    private static int getCountOfSubsetSumRecursion(int n, int k, int[] a) {
        if(k==0) return 1;
        if(n==0) return a[0] == k ? 1 : 0;

        int ntc = getCountOfSubsetSumRecursion(n-1, k, a);
        int tc = 0;
        if(a[n]<=k)
        tc = getCountOfSubsetSumRecursion(n-1, k-a[n], a);

        return ntc + tc;
    }

    private static int getCountOfSubsetSumMemoization(int n, int k, int[] a, int[][] dp) {
        if(k==0) return 1;
        if(n==0) return a[0] == k ? 1 : 0;

        if(dp[n][k]!=-1) return dp[n][k];
        int ntc = getCountOfSubsetSumMemoization(n-1, k, a, dp);
        int tc = 0;
        if(a[n]<=k)
        tc = getCountOfSubsetSumMemoization(n-1, k-a[n], a, dp);

        return dp[n][k] = ntc + tc;
    }

    private static int countSubsetWithKTargetRevision(int[] a, int target){
        int n = a.length;
        int[][] dp = new int[n][target+1];
        for(int row = 0; row<n; row++){
            dp[row][0] = 1;
        }
        if(a[0]<=target) dp[0][a[0]] = 1;
        for(int row = 1; row<n; row++){
            for(int j = 1; j<=target; j++){
                int ntc = dp[row-1][j];
                int tc = a[row]<=j ? dp[row-1][j-a[row]]:0;

                dp[row][j] = ntc + tc;
            }
        }
        return dp[n-1][target];
    }

    private static int getCountOfSubsetTabulation(int[]a, int n, int k){
        int[][] dp = new int[n][k+1];
        for(int i=0; i<n; i++){
            dp[i][0] = 1;
        }

        if(a[0] <=k) dp[0][a[0]] = 1;

        for(int i=1; i<n; i++){
            for(int j=1; j<=k; j++){
                int ntc = dp[i-1][j];
                int tc = 0;
                if(a[i]<=j)
                    tc = dp[i-1][j-a[i]];

                dp[i][j] = ntc + tc;
            }
        }
        return dp[n-1][k];
    }
}
