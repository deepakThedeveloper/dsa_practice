package dynamicProgramming.partition;

import java.util.Arrays;

public class PartitionArrayForMaxSum {
    public static void main(String[] args) {
        int[] a = {3,15,12,6,7};
        int k=2;
        int[] dp = new int[a.length];
        Arrays.fill(dp, -1);
        int maxSum = maxSumMemoizationRevision(0, k, a, dp);
        System.out.println(maxSum);
        int maxSum1 = maxSumTabulationRevision(a, k);
        System.out.println(maxSum1);
    }

    private static int maxSumMemoizationRevision(int i, int k, int[] a, int[] dp){
        if(i==a.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int len = 0, sum, partitionMax = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        for(int idx = i; idx < Math.min(a.length, i+k); idx++){
            partitionMax = Math.max(partitionMax, a[idx]);
            len++;
            sum = (partitionMax * len) + maxSumMemoizationRevision(idx+1, k, a, dp);
            max = Math.max(max, sum);
        }
        return dp[i] = max;
    }

    private static int maxSumTabulationRevision(int[] a, int k){
        int n = a.length;
        int[] dp = new int[n+1];

        for(int i = n-1; i>=0; i--){
            int len = 0, sum, partitionMax = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
            for(int idx = i; idx < Math.min(n, i+k); idx++){
                partitionMax = Math.max(partitionMax, a[idx]);
                len++;
                sum = (partitionMax * len) + dp[idx+1];
                max = Math.max(max, sum);
            }
            dp[i] = max;
        }
        return dp[0];
    }
}
