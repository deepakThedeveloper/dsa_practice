package dynamicProgramming;

import matrix.Util;

public class StocksBuySell3 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,3,5};
        int transactionCap = 2;
        int[][][] dp = Util.get3DMatrix(prices.length, 2, transactionCap+1);
        int maxProfit1 = maxProfitMemoizationRevision(0, 1, prices, transactionCap, dp);
        System.out.println("maxProfit memoization:"+maxProfit1);

        int maxProfit2 = maxProfitTabulationRevision(prices, transactionCap);
        System.out.println("maxProfit tabulation:"+maxProfit2);

        int totalTransaction = 2*transactionCap;
        int[][] dp1 = Util.getMatrix(prices.length, totalTransaction+1,-1);
        int maxProfit3 = maxProfitMemoizationRevisionApproach2(0, totalTransaction, prices, dp1);
        System.out.println("maxProfit memoization approach 2:"+maxProfit3);

        int maxProfit4 = maxProfitTabulationRevision(prices, totalTransaction);
        System.out.println("maxProfit tabulation approach 2:"+maxProfit4);
    }

    private static int maxProfitMemoizationRevision(int idx, int buyOrSell, int[] prices, int cap, int[][][] dp){
        if(idx==prices.length) return 0;
        if(cap==0) return 0;

        if(dp[idx][buyOrSell][cap]!=-1) return dp[idx][buyOrSell][cap];
        int profit = 0;
        if(buyOrSell==1) {// allowed to buy, but I am having liberty to decide whether to buy or sell
            profit+= Math.max(-prices[idx] + maxProfitMemoizationRevision(idx+1, 0, prices, cap, dp),
                    maxProfitMemoizationRevision(idx+1,1, prices, cap, dp));
        }
        else{ // i am allowed to sell
            profit+= Math.max(prices[idx] +maxProfitMemoizationRevision(idx+1, 1, prices, cap-1, dp),
                    maxProfitMemoizationRevision(idx+1, 0, prices, cap, dp));
        }
        return dp[idx][buyOrSell][cap] = profit;
    }

    private static int maxProfitMemoizationRevisionApproach2(int idx, int transactions, int[] prices, int[][] dp){
        if(idx==prices.length) return 0;
        if(transactions==0) return 0;

        if(dp[idx][transactions]!=-1) return dp[idx][transactions];
        int profit = 0;
        if(transactions%2==0) {// allowed to buy, but I am having liberty to decide whether to buy or sell
            profit+= Math.max(-prices[idx] + maxProfitMemoizationRevisionApproach2(idx+1, transactions-1, prices, dp),
                    maxProfitMemoizationRevisionApproach2(idx+1,transactions, prices, dp));
        }
        else{ // i am allowed to sell
            profit+= Math.max(prices[idx] +maxProfitMemoizationRevisionApproach2(idx+1, transactions-1, prices, dp),
                    maxProfitMemoizationRevisionApproach2(idx+1, transactions, prices, dp));
        }
        return dp[idx][transactions] = profit;
    }

    private static int maxProfitTabulationRevision(int[] prices, int cap){
        int n = prices.length;
        int[][][] dp = Util.get3DMatrix(n+1, 2, cap+1, 0);

        for(int i=n-1; i>=0; i--){
            for(int j=1; j>=0; j--){
                for(int c=1; c<=cap; c++) {
                    int profit = 0;
                    if (j == 1) {// allowed to buy, but I am having liberty to decide whether to buy or sell
                        profit += Math.max(-prices[i] + dp[i + 1][0][c], dp[i + 1][1][c]);
                    } else { // i am allowed to sell
                        profit += Math.max(prices[i] + dp[i + 1][1][c-1], dp[i + 1][0][c]);
                    }
                    dp[i][j][c] = profit;
                }
            }
        }
        return dp[0][1][2];
    }

    private static int maxProfitTabulationRevisionApproach2(int[] prices, int transactions){
        int n = prices.length;
        int[][] dp = Util.getMatrix(n+1, transactions+1, 0);

        for(int i=n-1; i>=0; i--){
            for(int j=1; j<=transactions; j++){
                    int profit = 0;
                    if (j%2==0) {// allowed to buy, but I am having liberty to decide whether to buy or sell
                        profit += Math.max(-prices[i] + dp[i + 1][j-1], dp[i + 1][j]);
                    } else { // i am allowed to sell
                        profit += Math.max(prices[i] + dp[i + 1][j-1], dp[i + 1][j]);
                    }
                    dp[i][j] = profit;
                }
            }
        return dp[0][4];
    }
}
