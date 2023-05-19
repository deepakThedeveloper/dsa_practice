package dynamicProgramming;

import matrix.Util;

public class RodCuttingPblm {
    public static void main(String[] args) {
        int[] price = {2,5,7,8,10};
        int rodLength = 5;

        int[][] dp = Util.getMatrix(price.length, rodLength+1, -1);

        int maxValue1 = getMaxValueMemoization(price.length-1, rodLength, price, dp);
        System.out.println(maxValue1);
        int maxValue2 = getMaxValueTabulation(rodLength, price);

        int idx = rodLength-1;

        int[][] dp1 = Util.getMatrix(rodLength, rodLength+1, -1);
        int maxPrice2 = maxPriceOfRodCuttingMemoizationRevision(idx, rodLength, price, dp1);
        Util.printMatrix(dp1);
        System.out.println();
        System.out.println("memoization:"+maxPrice2);

        int maxPrice3 = maxPriceOfRodCuttingTabulationRevision(price, rodLength);
        System.out.println("tabulationL:"+maxPrice3);
    }

    private static int maxPriceOfRodCuttingMemoizationRevision(int idx, int remainingRodLength, int[] value, int[][] dp){
        if(idx == 0) return remainingRodLength*value[0];

        if(dp[idx][remainingRodLength]!=-1) return dp[remainingRodLength][idx];
        int notCut = maxPriceOfRodCuttingMemoizationRevision(idx-1, remainingRodLength, value, dp);
        int cut = Integer.MIN_VALUE;
        int rodLength = idx+1;
        if(rodLength<=remainingRodLength) {
            cut = maxPriceOfRodCuttingMemoizationRevision(idx, remainingRodLength - rodLength,  value, dp) + value[idx];
        }
        return dp[idx][remainingRodLength] = Math.max(cut, notCut);
    }

    private static int maxPriceOfRodCuttingTabulationRevision(int[] value, int rodlength){
        int idx = rodlength-1;
        int[][] dp = Util.getMatrix(rodlength, rodlength+1, 0);

        for(int i=0; i<=rodlength; i++){
            dp[0][i] = value[0]*i;
        }
        for(int i=1; i<idx; i++){
            for(int j=0; j<=rodlength; j++){
                int notCut = dp[i-1][j];
                int cut = Integer.MIN_VALUE;
                int rodLength = i+1;
                if(rodLength<=j) {
                    cut = dp[i][j-rodLength] + value[i];
                }
                dp[i][j] = Math.max(cut, notCut);
            }
        }
        Util.printMatrix(dp);
        return dp[idx-1][rodlength];
    }

    private static int getMaxValueTabulation(int k, int[] a){
        int n = a.length;
        int[][] dp = new int[n][k+1];

        for(int i=0; i<=k; i++){
            dp[0][i] = i*a[0];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=k; j++){
                int nc = dp[i-1][j];
                int tc = Integer.MIN_VALUE;
                if(i+1<=j)
                    tc = a[i] + dp[i-1][j-(i+1)];

                dp[i][j] = Math.max(nc, tc);
            }
        }

        return dp[n-1][k];
    }

    private static int getMaxValueMemoization(int n, int k, int[] price, int[][] dp){
        if(n==0){
            return k*price[0];
        }

        if(dp[n][k]!=-1) return dp[n][k];
        int nc = getMaxValueMemoization(n-1, k, price, dp);
        int tc = Integer.MIN_VALUE;
        if(n+1<=k)
         tc = price[n] + getMaxValueMemoization(n-1, k-(n+1), price, dp);

        return dp[n][k] = Math.max(nc, tc);
    }
}
