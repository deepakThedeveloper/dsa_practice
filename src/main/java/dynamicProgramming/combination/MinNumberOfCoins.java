package dynamicProgramming.combination;

public class MinNumberOfCoins {
    public static void main(String[] args) {
        int[] denom = {1,2,3};
        int target = 7;

        int minCoins = getMinCoins(denom, target, denom.length-1);
        System.out.println(minCoins);

        int[][] dp = new int[denom.length][target+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<=target; j++){
                dp[i][j] = -1;
            }
        }
        int minCoins1 = getMinCoinsMemoization(denom, target, denom.length-1, dp);
        System.out.println(minCoins1);

        int minCoins2 = getMinCoinsTabulation(denom, target);
        System.out.println(minCoins2);
    }

    private static int getMinCoinsTabulation(int[] denom, int k){
        int n = denom.length;
        int[][] dp = new int[n][k+1];

        for(int i=0; i<=k; i++) {
            if(i%denom[0] == 0)
            dp[0][i] = i/denom[0];
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
    private static int getMinCoins(int[] denom, int k, int n) {
        if(n==0){
            if(k%denom[0] == 0) return k/denom[0];
            return 10 ^ 9;
        }

        int ntc = getMinCoins(denom, k, n-1);
        int tc = Integer.MAX_VALUE;
        if(denom[n]<=k){
            tc = 1+getMinCoins(denom, k-denom[n], n);
        }
        return Math.min(ntc, tc);
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
