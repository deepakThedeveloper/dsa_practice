package recursion;

// unlimited transactions are allowed but with cooldown period. it means today if you have sold the stock then
// tomorrow you can't buy it. you can do next buying dayafter tomorrow
public class StocksBuySell4 {
    public static void main(String[] args) {
        int[] prices = {4,9,0,4,10};
        int maxProfit = maxProfit(0, 1, prices);
        System.out.println("maxProfit recursion:"+maxProfit);
    }

    private static int maxProfit(int idx, int buyOrSell, int[] prices){
        if(idx>=prices.length) return 0;

        int profit = 0;
        if(buyOrSell==1) {// allowed to buy, but I am having liberty to decide whether to buy or sell
            profit+= Math.max(-prices[idx] + maxProfit(idx+1, 0, prices),
                    maxProfit(idx+1,1, prices));
        }
        else{ // else is sell section. if i decide to sell then I am giving liberty to user to buy in idx+1 day.
            //but as this question is about cooldown then we can't do idx+1 but rather next day after idx+1 = idx+2;
            profit+= Math.max(prices[idx] +maxProfit(idx+2, 1, prices),
                    maxProfit(idx+1, 0, prices));
        }
        return profit;
    }
}
