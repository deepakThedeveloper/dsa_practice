package dynamicProgramming.stocks;

import matrix.Util;

public class StocksBuySell2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        int[][] dp = Util.getMatrix(prices.length, 2, -1);
        int maxProfit1 = maxProfitMemoizationRevision(0, 1, prices, dp);
        System.out.println("maxProfit memoization:"+maxProfit1);

        int maxProfit2 = maxProfitTabulationRevision(prices);
        System.out.println("maxProfit tabulation:"+maxProfit2);
    }

    private static int maxProfitMemoizationRevision(int idx, int buyOrSell, int[] prices, int[][] dp){
        if(idx==prices.length) return 0;

        if(dp[idx][buyOrSell]!=-1) return dp[idx][buyOrSell];
        int profit = 0;
        if(buyOrSell==1) {// allowed to buy, but I am having liberty to decide whether to buy or sell
            profit+= Math.max(-prices[idx] + maxProfitMemoizationRevision(idx+1, 0, prices,dp),
                    maxProfitMemoizationRevision(idx+1,1, prices, dp));
        }
        else{ // i am allowed to sell
            profit+= Math.max(prices[idx] +maxProfitMemoizationRevision(idx+1, 1, prices, dp),
                    maxProfitMemoizationRevision(idx+1, 0, prices, dp));
        }
        return dp[idx][buyOrSell ] = profit;
    }

    private static int maxProfitTabulationRevision(int[] prices){
        int n = prices.length;
        int[][] dp = Util.getMatrix(n+1, 2, 0);

        for(int i=n-1; i>=0; i--){
            for(int j=1; j>=0; j--){
                int profit = 0;
                if(j==1) {// allowed to buy, but I am having liberty to decide whether to buy or sell
                    profit+= Math.max(-prices[i] + dp[i+1][0],dp[i+1][1]);
                }
                else{ // i am allowed to sell
                    profit+= Math.max(prices[i] +dp[i+1][1],dp[i+1][0]);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][1];
    }
}
