package recursion;

import matrix.Util;

public class StocksBuySell2 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = maxProfit(0, 1, prices);
        System.out.println("maxProfit recursion:"+maxProfit);
    }

    private static int maxProfit(int idx, int buyOrSell, int[] prices){
        if(idx==prices.length) return 0;

        int profit = 0;
        if(buyOrSell==1) {// allowed to buy, but I am having liberty to decide whether to buy or sell
            profit+= Math.max(-prices[idx] + maxProfit(idx+1, 0, prices),
                    maxProfit(idx+1,1, prices));
        }
        else{ // i am allowed to sell
            profit+= Math.max(prices[idx] +maxProfit(idx+1, 1, prices),
                    maxProfit(idx+1, 0, prices));
        }
        return profit;
    }
}
