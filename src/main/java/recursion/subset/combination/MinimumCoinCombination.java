package recursion.subset.combination;

import matrix.Util;

public class MinimumCoinCombination {
    public static void main(String[] args) {
        int[] denom = {2,3,5};
        int target = 7;

        int minCoins = getMinCoins(denom, target, denom.length-1);
        System.out.println(minCoins);
    }

    private static int getMinCoins(int[] denom, int k, int n) {
        if(n==0){
            if(k%denom[0] == 0) return k/denom[0];
            return 10 ^ 9;
        }

        int tc = Integer.MAX_VALUE;
        if(denom[n]<=k){
            tc = 1+getMinCoins(denom, k-denom[n], n);
        }
        int ntc = getMinCoins(denom, k, n-1);
        return Math.min(ntc, tc);
    }
}
