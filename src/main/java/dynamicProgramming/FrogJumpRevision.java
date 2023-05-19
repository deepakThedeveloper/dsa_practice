package dynamicProgramming;

import java.util.Arrays;

public class FrogJumpRevision {
    public static void main(String[] args) {
        int[] ht = {7,4,4,2,6,6,3,4};
        Arrays.stream(ht).forEach(v-> System.out.print(v+" "));
        System.out.println();

        int[] dp = new int[ht.length];
        Arrays.fill(dp, -1);

        int minEnergy = minEnergyJumpsMemoization(ht, ht.length-1, dp);
        Arrays.stream(dp).forEach(v-> System.out.print(v+" "));
        System.out.println();
        System.out.println("memoization:"+minEnergy);

        int minEnergy1 = minEnergyJumpTabulation(ht);
        System.out.println("tabulation:"+minEnergy1);

        int minEnergy2 = minEnergyJumpTabulationOptimization(ht);
        System.out.println("tabulation optimization:"+minEnergy2);
    }

    private static int minEnergyJumpsMemoization(int[] a, int n, int[] dp){
        if(n==0) return 0;

        if(dp[n]!=-1) return dp[n];
        int left = minEnergyJumpsMemoization(a, n - 1, dp) +Math.abs(a[n] - a[n - 1]);
        int right = n-2 >=0 ? minEnergyJumpsMemoization(a, n-2, dp) + Math.abs(a[n] - a[n-2]) : Integer.MAX_VALUE;

        return dp[n] = Math.min(left, right);
    }

    private static int minEnergyJumpTabulation(int[] a){
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i=1; i<=n-1; i++) {
            int left = dp[i - 1] +Math.abs(a[i] - a[i - 1]);
            int right = i-2 >= 0 ? dp[i-2] + Math.abs(a[i] - a[i-2]) : Integer.MAX_VALUE;

            dp[i] = Math.min(left, right);
        }
        Arrays.stream(dp).forEach(v-> System.out.print(v+" "));
        System.out.println();

        return dp[a.length-1];
    }

    private static int minEnergyJumpTabulationOptimization(int[] a){
        int n = a.length;
        int dp = 0, dp1=0;
        for(int i=1; i<=n-1; i++) {
            int left = dp +Math.abs(a[i] - a[i - 1]);
            int right = i-2 >= 0 ? dp1 + Math.abs(a[i] - a[i-2]) : Integer.MAX_VALUE;

            dp1 = dp;
            dp = Math.min(left, right);

        }
        System.out.println();
        return dp;
    }
}
