package dynamicProgramming.combination;

import java.io.FilterOutputStream;

public class TotalWaysCoinsCanAchieveTarget {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int target = 4;

        int ways = getWaysRecursion(a.length-1, target, a);
        System.out.println(ways);

        int[][] dp = new int[a.length][target+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<=target; j++){
                dp[i][j] = -1;
            }
        }
        int ways1 = getWaysMemoization(a.length-1, target, a, dp);
        System.out.println(ways1);

        int ways2 = getWaysTabulation(target, a);
        System.out.println(ways2);
    }

    private static int getWaysTabulation(int k, int[] a){
        int n = a.length;
        int[][] dp = new int[n][k+1];

        for(int i=0; i<=k; i++){
            if(i%a[0] == 0){
                dp[0][i] = 1;
            }
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=k; j++){
                int ntc = dp[i-1][j];
                int tc = 0;
                if(a[i]<=j){
                    tc = dp[i][j-a[i]];
                }
                dp[i][j] = ntc + tc;
            }
        }

        return dp[n-1][k];
    }
    private static int getWaysMemoization(int n, int k, int[] a, int[][] dp){
        if(n==0){
            if(k%a[0] == 0) return 1;
            return 0;
        }
        if(dp[n][k] != -1) return dp[n][k];

        int ntc = getWaysMemoization(n-1, k, a, dp);
        int tc = 0;
        if(a[n]<=k){
            tc = getWaysMemoization(n, k-a[n], a, dp);
        }

        return dp[n][k] = ntc + tc;
    }
    private static int getWaysRecursion(int n, int k, int[] a){
        if(n==0){
            if(k%a[0] == 0) return 1;
            return 0;
        }

        int ntc = getWaysRecursion(n-1, k, a);
        int tc = 0;
        if(a[n]<=k){
            tc = getWaysRecursion(n, k-a[n], a);
        }

        return ntc + tc;
    }
}
