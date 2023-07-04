package dynamicProgramming.stocks;

import matrix.Util;

public class StocksBuySell5 {
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int transactionFee = 2;
        int[][] dp = Util.getMatrix(prices.length, 2, -1);
        int maxProfit1 = maxProfitMemoizationRevision(0, 1, prices, dp, transactionFee);
        System.out.println("maxProfit memoization:"+maxProfit1);

        int maxProfit2 = maxProfitTabulationRevision(prices, transactionFee);
        System.out.println("maxProfit tabulation:"+maxProfit2);

        int maxProfit3 = maxProfitTabulationDirect(prices, transactionFee);
        System.out.println("maxProfit tabulation direct:"+maxProfit3);

        int maxProfit4 = maxProfitWithCoolDownTabulationDirect(prices);
        System.out.println("maxProfit with cooldown tabulation direct:"+maxProfit4);
    }

    // include exclude technique
    private static int maxProfitTabulationDirect(int[] prices, int fee){
        int len = prices.length;
        int[][] dp = new int[2][len];

        dp[0][0] = -prices[0];
        for(int i=1; i<len; i++){
            int lastSellPrice = dp[1][i-1];
            int lastBuyPrice = dp[0][i-1];
            dp[0][i] = Math.max(lastSellPrice - prices[i], lastBuyPrice);
            dp[1][i] = Math.max(lastBuyPrice + prices[i] - fee, lastSellPrice);
        }
        return dp[1][len-1];
    }

    // include exclude technique
    private static int maxProfitWithCoolDownTabulationDirect(int[] prices){
        int len = prices.length;
        int[][] dp = new int[3][len];

        dp[0][0] = -prices[0];
        for(int i=1; i<len; i++){
            int lastBuyPrice = dp[0][i-1];
            int lastSellPrice = dp[1][i-1];
            int lastCoolDownPrice = dp[2][i-1];
            dp[0][i] = Math.max(lastCoolDownPrice - prices[i], lastBuyPrice);
            dp[1][i] = Math.max(lastBuyPrice + prices[i], lastSellPrice);
            dp[2][i] = Math.max(lastCoolDownPrice, lastSellPrice);
        }
        return dp[2][len-1];
    }

    private static int maxProfitMemoizationRevision(int idx, int buyOrSell, int[] prices, int[][] dp, int transactionFee){
        if(idx==prices.length) return 0;

        if(dp[idx][buyOrSell]!=-1) return dp[idx][buyOrSell];
        int profit = 0;

        // allowed to buy, but I am having liberty to decide whether to buy or sell
        if(buyOrSell==1) {
            profit+= Math.max(-prices[idx] + maxProfitMemoizationRevision(idx+1, 0, prices,dp, transactionFee),
                    maxProfitMemoizationRevision(idx+1,1, prices, dp, transactionFee));
        }
        else{ // i am allowed to sell
            profit+= Math.max(prices[idx]-transactionFee + maxProfitMemoizationRevision(idx+1, 1, prices, dp, transactionFee),
                    maxProfitMemoizationRevision(idx+1, 0, prices, dp, transactionFee));
        }
        return dp[idx][buyOrSell] = profit;
    }

    private static int maxProfitTabulationRevision(int[] prices, int transactionFee){
        int n = prices.length;
        int[][] dp = Util.getMatrix(n+1, 2, 0);

        for(int i=n-1; i>=0; i--){
            for(int j=1; j>=0; j--){
                int profit = 0;
                if(j==1) {// allowed to buy, but I am having liberty to decide whether to buy or sell
                    profit+= Math.max(-prices[i] + dp[i+1][0],dp[i+1][1]);
                }
                else{ // i am allowed to sell
                    profit+= Math.max(prices[i]-transactionFee + dp[i+1][1],dp[i+1][0]);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][1];
    }
}
