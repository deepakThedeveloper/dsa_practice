package dynamicProgramming.subset.permutation;

import matrix.Util;

import java.util.Arrays;

import static util.GlobalUtil.swap;

public class CoinPermutation {
    public static void main(String[] args) {
        int k = 7;
        int[] coins = {2,3,5};
        int sumInfiniteMemoization = infiniteCoinApproach1Memoization(coins, k, new int[k+1]);
        System.out.println("infinite memoization:"+sumInfiniteMemoization);

        int sumInfiniteTabulation = infiniteCoinApproach1Tabulation(coins, k);
        System.out.println("infinite tabulation:"+sumInfiniteTabulation);

        int sumFiniteMemoization = finiteCoinVisitedApproachMemoization(coins, k, new boolean[coins.length], new int[k+1]);
        System.out.println("finite memoization:"+sumFiniteMemoization);

        int sumFiniteSwapMemoization = finiteCoinSwapApproachMemoization(coins, k, 0, new int[coins.length][k+1]);
        System.out.println("finite memoization swap approach:"+sumFiniteSwapMemoization);

        int sumInfiniteCoin = infiniteCoinToMakeTargetTabulationDirectApproach(coins, k);
        System.out.println("infinite tabulation:"+sumInfiniteCoin);
    }

    private static int infiniteCoinToMakeTargetTabulationDirectApproach(int[] coins, int target){
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for(int i=1; i<=target; i++){
            for(int j=0; j<coins.length; j++){
                if(coins[j] > i) continue;
                dp[i] += dp[i - coins[j]];
            }
        }
        return dp[target];
    }

    private static int finiteCoinSwapApproachMemoization(int[] coins, int target, int level, int[][] dp){
        if(target == 0){
            return 1;
        }
        if(target < 0) return 0;
        if(dp[level][target] != 0) return dp[level][target];
        int totalPermutations = 0;
        for(int i=level; i<coins.length; i++){
            swap(i, level, coins);
            totalPermutations += finiteCoinSwapApproachMemoization(coins, target-coins[level], level+1, dp);
            swap(i, level, coins);
        }

        return dp[level][target] = totalPermutations;
    }

    //todo. not working
    private static int finiteCoinSwapApproachTabulation(int[] coins, int target){
        int level = 0;
        int len = coins.length;
        int[][] dp = new int[len+1][target+1];
        for(int r=0; r<=len; r++){
            dp[r][0] = 1;
        }

        for(int r=1; r<=len; r++){
            for(int c = 1; c<=target; c++){
                int totalPermutations = 0;
                for(int i=r; i<len; i++){
                    swap(i, r, coins);
                    totalPermutations += c-coins[r] < 0 ? 0 : dp[r+1][c-coins[r]];
                    swap(i, r, coins);
                }
                dp[r][c] = totalPermutations;
            }
        }
        Util.printMatrix(dp);
        return dp[len-1][target];
    }

    private static int finiteCoinVisitedApproachMemoization(int[] coins, int target, boolean[] visited, int[] dp){
        if(target == 0) return 1;
        if(target < 0) return 0;
        int totalPermutations = 0;
        if(dp[target]!=0) return dp[target];

        for(int i=0; i<coins.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            totalPermutations += finiteCoinVisitedApproachMemoization(coins, target-coins[i], visited, dp);
            visited[i] = false;
        }

        return dp[target] = totalPermutations;
    }

    private static int infiniteCoinApproach1Memoization(int[] coins, int target, int[] dp){
        if(target == 0) return 1;
        if(target < 0) return 0;
        if(dp[target] != 0) return dp[target];

        int totalPermutations = 0;
        for (int coin : coins) {
            totalPermutations += infiniteCoinApproach1Memoization(coins, target - coin, dp);
        }

        return dp[target] = totalPermutations;
    }

    private static int infiniteCoinApproach1Tabulation(int[] coins, int target){
        int[] dp = new int[target+1];
        dp[0] = 1;

        int totalPermutations;
        for(int i=1; i<=target; i++) {
            totalPermutations = 0;
            for (int coin : coins) {
                totalPermutations += i - coin < 0 ? 0 : dp[i - coin];
            }
            dp[i] = totalPermutations;
        }
        Arrays.stream(dp).forEach(v-> System.out.print(v+" "));
        System.out.println();
        return dp[target];
    }
}
