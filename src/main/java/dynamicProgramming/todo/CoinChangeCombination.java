package dynamicProgramming.todo;

import matrix.Util;

import java.util.HashMap;
import java.util.Map;

public class CoinChangeCombination {
    public static void main(String[] args) {
        int[] denom = {2,3,4,5};
        int target = 7;

        int[][] dp = Util.getMatrix(target+1, denom.length+1, -1);
        int combinations = getCombinationMemoization(denom, target, 0 , dp);
        System.out.println(combinations);
    }

    //todo: dp[][] creation is not correct. need to revisit. control is not going inside if(dp[k][j] != -1){}
    private static int getCombinationMemoization(int[] denom, int k, int j, int[][] dp){
        if(k==0) {
            return 1;
        }
        if(k<0) return 0;
        if(dp[k][j] != -1){
            System.out.println("in dp");
            return dp[k][j];
        }
        System.out.println("in method:"+denom[j]);

        int count = 0;
        for(int i=j; i<denom.length; i++){
            count += getCombinationMemoization(denom, k-denom[i], i, dp);
        }
        dp[k][j] = count;
        return count;
    }
}
