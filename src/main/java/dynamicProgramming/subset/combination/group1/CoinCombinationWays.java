package dynamicProgramming.subset.combination.group1;

import matrix.Util;

import java.util.Arrays;

public class CoinCombinationWays {
    public static void main(String[] args) {
        int[] denom = {2,3,5};
        int target = 7;

        int[][] dp = Util.getMatrix(denom.length, target+1, -1);
        int coinCombinations = coinCombinationMemoization(denom.length-1, target, denom, dp);
        System.out.println(coinCombinations);

        int coinCombinations1 = coinCombinationTabulation(denom.length, target, denom);
        System.out.println(coinCombinations1);

        boolean canMake = canCoinsMakeTargetDirectTabulationApproach(denom, target);
        System.out.println("tabulation can combination of coins make target:"+canMake);

        int countCoinSubset = countCoinsSubsetThatMakeTargetDirectTabulationApproach(denom, target);
        System.out.println();
        System.out.println("tabulation coin combination count that make target:"+countCoinSubset);
    }


    private static boolean canCoinsMakeTargetDirectTabulationApproach(int[] coins, int target){
        int len = coins.length;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        for(int i=0; i<len; i++){
            for(int j=1; j<=target; j++){
                if(coins[i] > j) continue;
                dp[j] = dp[j] || dp[j-coins[i]];
            }
        }
        return dp[target];
    }

    private static int countCoinsSubsetThatMakeTargetDirectTabulationApproach(int[] coins, int target){
        int len = coins.length;
        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int i=0; i<len; i++){
            for(int j=1; j<=target; j++){
                if(coins[i] > j) continue;
                dp[j] += dp[j-coins[i]];
            }
        }

        Arrays.stream(dp).forEach(v-> System.out.print(v+" "));
        return dp[target];
    }

    private static int coinCombinationMemoization(int n, int k, int[] den, int[][] dp){
        if(n==0){
            if(k==0 || k>=den[0] && k % den[0] == 0) return 1;
            return 0;
        }
        if(dp[n][k]!=-1){
            return dp[n][k];
        }
        int notTake = coinCombinationMemoization(n-1, k, den, dp);
        int take = 0;
        if(k>=den[n]){
            take = coinCombinationMemoization(n, k-den[n], den, dp);
        }
        return dp[n][k] = take+notTake;
    }

    private static int coinCombinationTabulation(int n, int k, int[] den){
        int[][] dp = Util.getMatrix(n, k+1, 0);

        dp[0][0]=1;
        for(int i=1; i<=k; i++){
            if(i>=den[0] && i%den[0]==0) dp[0][i] = 1;
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=k; j++){
                int notTake = dp[i-1][j];
                int take = 0;
                if(j>=den[i]){
                    take = dp[i][j-den[i]];
                }
                dp[i][j] = take+notTake;
            }

        }
        Util.printMatrix(dp);
        return dp[n-1][k];
    }
}
