package recursion;

// unlimited transaction can be done but with every transaction a fee needs to be paid
public class StocksBuySell5 {
    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int transactionfee = 2;
        int maxProfit = maxProfit(0, 1, prices, transactionfee);
        System.out.println("maxProfit recursion:"+maxProfit);
    }

    private static int maxProfit(int idx, int buyOrSell, int[] prices, int fee){
        if(idx==prices.length) return 0;

        int profit = 0;
        if(buyOrSell==1) {// allowed to buy, but I am having liberty to decide whether to buy or sell
            profit+= Math.max(-prices[idx] + maxProfit(idx+1, 0, prices, fee),
                    maxProfit(idx+1,1, prices, fee));
        }
        else{ // i am allowed to sell
            profit+= Math.max(prices[idx]-fee +maxProfit(idx+1, 1, prices, fee),
                    maxProfit(idx+1, 0, prices, fee));
        }
        return profit;
    }
}
