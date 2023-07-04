package recursion.subset.permutation;

import util.GlobalUtil;

public class CoinChangePermutation {
    public static void main(String[] args) {
        int[] denom = {2,3,5};
        int target = 7;

        int permutationCountInfiniteSupply = infiniteCoinPermutationApproach1(denom,  target, "");
        System.out.println("infinite supply of coins permutations:"+permutationCountInfiniteSupply);

        int permutationCountFiniteSupply = finiteCoinPermutationVisitedApproach(denom,  target, "", new boolean[denom.length]);
        System.out.println("finite supply of coins permutations1:"+permutationCountFiniteSupply);

        int permutationCountFiniteSupply1 = finiteCoinPermutationSwapApproach(denom,  target, "", 0);
        System.out.println("finite supply of coins permutations2:"+permutationCountFiniteSupply1);
    }

    //refer: /resources/coin_permutations_infinite_supply.jpg
    private static int infiniteCoinPermutationApproach1(int[] coins, int target, String op){
        if(target == 0){
            System.out.println(op);
            return 1;
        }
        if(target < 0) return 0;

        int totalPermutations = 0;
        for(int i=0; i<coins.length; i++){
            totalPermutations += infiniteCoinPermutationApproach1(coins, target-coins[i], op+coins[i]);
        }

        return totalPermutations;
    }

    private static int infiniteCoinPermutationsApproach2(int k, String op) {
        if(k==0){
            System.out.println(op);
            return 1;
        }
        if(k<0){
            return 0;
        }
        return
                infiniteCoinPermutationsApproach2(k-2, op+"2")+
                infiniteCoinPermutationsApproach2(k-3, op+"3")+
                infiniteCoinPermutationsApproach2(k-5, op+"5");
    }

    // refer: /resources/coin_permutation_finite_supply.jpg
    private static int finiteCoinPermutationVisitedApproach(int[] coins, int target, String op, boolean[] visited){
        if(target == 0){
            System.out.println(op);
            return 1;
        }
        if(target < 0) return 0;

        int totalPermutations = 0;
        for(int i=0; i<coins.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            totalPermutations += finiteCoinPermutationVisitedApproach(coins, target-coins[i], op+coins[i], visited);
            visited[i] = false;
        }

        return totalPermutations;
    }

    private static int finiteCoinPermutationSwapApproach(int[] coins, int target, String op, int level){
        if(target == 0){
            System.out.println(op);
            return 1;
        }
        if(target < 0) return 0;

        int totalPermutations = 0;
        for(int i=level; i<coins.length; i++){
            GlobalUtil.swap(i, level, coins);
            totalPermutations += finiteCoinPermutationSwapApproach(coins, target-coins[level], op+coins[level], level+1);
            GlobalUtil.swap(i, level, coins);
        }

        return totalPermutations;
    }
}
