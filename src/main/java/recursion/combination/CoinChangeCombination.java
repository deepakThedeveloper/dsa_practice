package recursion.combination;

public class CoinChangeCombination {
    public static void main(String[] args) {
        int[] denom = {2,3,4,5};
        int target = 7;

        int combinations = totalCoinCombinationWays(denom,  target, 0, "");
        System.out.println("combinations:"+combinations);

        int combinations1 = totalCoinCombinationWaysApproach2(denom.length,  target, denom);
        System.out.println("combinations approach 2:"+combinations);
    }

    private static int totalCoinCombinationWays(int[] denom, int k, int j, String op){
        if(k==0) {
            System.out.println(op);
            return 1;
        }
        if(k<0) return 0;

        int count = 0;
        for(int i=j; i<denom.length; i++){
            count += totalCoinCombinationWays(denom, k-denom[i], i, op+denom[i]);
        }
        return count;
    }

    private static int totalCoinCombinationWaysApproach2(int n, int k, int[] den){
        if(n==0){
            if(k==0 || k>=den[0] && k % den[0] == 0) return 1;
            return 0;
        }
        int notTake = totalCoinCombinationWaysApproach2(n-1, k, den);
        int take = 0;
        if(k>=den[n]){
            take = totalCoinCombinationWaysApproach2(n, k-den[n], den);
        }
        return take+notTake;
    }
}
