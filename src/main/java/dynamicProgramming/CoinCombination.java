package dynamicProgramming;

import matrix.Util;

// infinite supply of coin denom is present. a target is given. when we sum up the coins we will reach to target.
// need to find minimum number of coin needed to reach to target.e.g: 1,2,3 - target 5. combination[2,2,1] || [2,3].
// as min coins needed for [2,3] is 2 we need to return 2.
public class CoinCombination {
    public static void main(String[] args) {
        int[] denom = {1,2,3};
        int target = 5;

        int[][] dp = Util.getMatrix(denom.length, target+1, -1);
        int minCoinsNeeded = minCoinsForTargetKMemoizationRevision(denom, denom.length-1, target, dp);
        System.out.println(minCoinsNeeded);

        int minCoinsNeeded1 = minCoinsForTargetKTabulationRevision(denom, target);
        System.out.println(minCoinsNeeded1);
    }

    private static int minCoinsForTargetKMemoizationRevision(int[] denom, int n, int target, int[][] dp){
        if(n==0){
            if(target % denom[0]== 0) return target/denom[0];
            else return Integer.MAX_VALUE;
        }
        if(target<=0) return 0;
        if(dp[n][target]!=-1) return dp[n][target];
        int notPick = minCoinsForTargetKMemoizationRevision(denom, n-1, target, dp);
        int pick = Integer.MAX_VALUE;
        if(denom[n]<=target){
            pick = 1+ minCoinsForTargetKMemoizationRevision(denom, n, target-denom[n], dp);
        }

        return dp[n][target] = Math.min(pick, notPick);
    }

    private static int minCoinsForTargetKTabulationRevision(int[] denom, int target){
        int n = denom.length;
        int[][] dp = Util.getMatrix(n, target+1, 0);

        for(int i=0; i<=target; i++){
            if(i%denom[0]==0) dp[0][i] = i/denom[0];
        }
        for(int de=1; de<n; de++){
            for(int tar=0; tar<=target; tar++){
                int notPick = dp[de-1][tar];
                int pick = Integer.MAX_VALUE;
                if(denom[de]<=tar){
                    pick = 1+ dp[de][tar-denom[de]];
                }

                dp[de][tar] = Math.min(pick, notPick);
            }
        }
        return dp[n-1][target];
    }
}
