package dynamicProgramming;

import java.util.Arrays;

public class CoinPermutation {
    public static void main(String[] args) {
        int k = 7;
        //coinPermutations(k, "");
        /*int sum = coinPermutationsSum(k);
        System.out.println(sum);*/
        //coinCombinations(k, "", 2);

        /*int sum = coinCombinationsSum(k,2,"",0);
        System.out.println(sum);*/
        /*int sum = coinCombinationsSumDP(k);
        System.out.println(sum);*/

        int sum = coinPermutationSumDP(k);
        System.out.println();
        System.out.println(sum);
    }

    private static int coinPermutationSumDP(int k) {
        int[] dp = new int[k+1];
        dp[0] = 1;

        int[] coins = {2,3,5};
        for(int i=1; i<=k; i++){
            for(int j=0; j<coins.length; j++){
                if(i<coins[j]) continue;
                int v = i-coins[j];
                dp[i] = dp[i]+dp[v];
            }
        }
        Arrays.stream(dp).forEach(v-> System.out.print(v+" "));
        return dp[k];
    }

    private static int coinCombinationsSumDP(int k) {
        int[] dp = new int[k];
        int[] j = {2,3,5};
        for(int i=0; i<3; i++){
            for(int l = 0; l<k; l++){
                if(l==j[i] || l==0){
                    dp[l] = 1;
                }
                else if (l>j[i]){
                    if(dp[l-j[i]] != 0){
                        dp[l] +=1;
                    }
                }
            }

        }
        Arrays.stream(dp).forEach(v-> System.out.print(v+" "));
        return dp[k-1];
    }

    //permutation means all possible values like 223, 322, 232...
    private static void coinPermutations(int k, String op) {

        if(k==0){
            System.out.println(op);
            return;
        }
        if(k<0){
            return;
        }
        coinPermutations(k-2, op+"2");
        coinPermutations(k-3, op+"3");
        coinPermutations(k-5, op+"5");
    }

    //permutation means all possible values like 223, 322, 232...
    private static int coinPermutationsSum(int k) {

        if(k==0){
            return 1;
        }
        if(k<0){
            return 0;
        }
        return coinPermutationsSum(k-2)
        + coinPermutationsSum(k-3)
        + coinPermutationsSum(k-5);
    }

    //permutation means only distinct values like 223
    private static void coinCombinations(int k, String op, int val) {

        if(k==0){
            System.out.println(op);
            return;
        }
        if(k<0){
            return;
        }
        if(val==2)
            coinCombinations(k-2, op+"2", 2);
        if(val == 2 || val == 3)
            coinCombinations(k-3, op+"3", 3);
            coinCombinations(k-5, op+"5", 5);
    }

    private static int coinCombinationsSum(int k, int val, String op, int sum) {

        if(k==0){
            return 1;
        }
        if(k<0){
            return 0;
        }
        int ret = 0, ret1 = 0, ret2 = 0;
        if(val==2) {
            ret = coinCombinationsSum(k - 2, 2, op + "2", sum);
        }
        if(val ==2 || val == 3) {
            ret1 = coinCombinationsSum(k - 3, 3, op + "3", sum);
        }
        ret2 = coinCombinationsSum(k-5, 5, op+"5", sum);

        return ret+ret1+ret2;
    }
}
