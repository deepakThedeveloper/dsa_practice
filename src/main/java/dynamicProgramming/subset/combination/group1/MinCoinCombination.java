package dynamicProgramming.subset.combination.group1;

import matrix.Util;

public class MinCoinCombination {
    public static void main(String[] args) {
        int[] denom = {2,3,5};
        int target = 7;

        int[][] dp = Util.getMatrix(denom.length, target+1, -1);
        int minCoins1 = getMinCoinsMemoization(denom, target, denom.length-1, dp);
        System.out.println("memoization:"+minCoins1);

        int minCoins2 = getMinCoinsTabulation(denom, target);
        System.out.println("tabulation:"+minCoins2);
    }

    private static int getMinCoinsTabulationDirectApproach(int[] coins, int k){
        int n = coins.length;
        int[][] dp = Util.getMatrix(n+1, k+1, 10^9);

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=k; j++){
                if(coins[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{

                }
            }
        }
        return dp[n][k];
    }

    private static int getMinCoinsTabulation(int[] denom, int k){
        int n = denom.length;
        int[][] dp = new int[n][k+1];

        for(int i=0; i<=k; i++) {
            dp[0][i] = i%denom[0] == 0 ? i/denom[0] : 10^9;
        }

        for(int i = 1; i<n; i++){
            for(int j = 0; j<=k; j++){
                int ntc = dp[i-1][j];
                int tc = Integer.MAX_VALUE;
                if(denom[i]<=j){
                    tc = 1+dp[i][j-denom[i]];
                }
                dp[i][j] = Math.min(ntc, tc);
            }
        }
        return dp[n-1][k];
    }

    private static int getMinCoinsMemoization(int[] denom, int k, int n, int[][] dp) {
        if(n==0){
            if(k%denom[0] == 0) return k/denom[0];
            return 10 ^ 9;
        }
        if(dp[n][k]!=-1) return dp[n][k];
        int ntc = getMinCoinsMemoization(denom, k, n-1, dp);
        int tc = Integer.MAX_VALUE;
        if(denom[n]<=k){
            tc = 1+getMinCoinsMemoization(denom, k-denom[n], n, dp);
        }
        return dp[n][k] = Math.min(ntc, tc);
    }
}
