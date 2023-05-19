package recursion;

public class StocksBuySell3 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,3,5};
        int transactionCap = 2;
        int maxProfit = maxProfit(0, 1, prices, transactionCap);
        System.out.println("maxProfit recursion:"+maxProfit);

        int totalTransaction  = transactionCap * 2;//((Buy, Sell, Buy, Sell))
        int maxProfit1 = maxProfitApproach2(0, totalTransaction, prices);
        System.out.println("maxProfit recursion approach 2:"+maxProfit1);
    }

    private static int maxProfit(int idx, int buyOrSell, int[] prices, int cap){
        if(idx==prices.length) return 0;
        if(cap==0) return 0;

        int profit = 0;
        if(buyOrSell==1) {// allowed to buy, but I am having liberty to decide whether to buy or sell
            profit+= Math.max(-prices[idx] + maxProfit(idx+1, 0, prices, cap),
                    maxProfit(idx+1,1, prices, cap));
        }
        else{ // i am allowed to sell
            profit+= Math.max(prices[idx] +maxProfit(idx+1, 1, prices, cap-1),
                    maxProfit(idx+1, 0, prices, cap));
        }
        return profit;
    }

    /**
     * In second approach rather than considering 3 different things, idx * 2(buy/sell) * 2(transaction cap), lets
     * merge last two in one and make it idx * 4;
     */
    private static int maxProfitApproach2(int idx, int transactions, int[] prices){
        if(idx==prices.length) return 0;
        if(transactions==0) return 0;
        int profit = 0;
        if(transactions%2==0) {
            profit+= Math.max(-prices[idx] + maxProfitApproach2(idx+1, transactions-1, prices),
                    maxProfitApproach2(idx+1,transactions, prices));
        }
        else{
            profit+= Math.max(prices[idx] +maxProfitApproach2(idx+1, transactions-1, prices),
                    maxProfitApproach2(idx+1, transactions, prices));
        }
        return profit;
    }
}
