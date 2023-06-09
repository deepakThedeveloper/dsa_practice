package dynamicProgramming.combination.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumNonAdjacentElementsRoundArray {
    public static void main(String[] args) {
        int[] a = {2,1,4,9};
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        for(int i=0; i<a.length; i++){
            if(i!=0){
                temp1.add(a[i]);
            }
            if(i!=a.length-1){
                temp2.add(a[i]);
            }
        }
        System.out.println(temp1);
        System.out.println(temp2);

        int max = Math.max(findMaxSumTabulation(temp1), findMaxSumTabulation(temp2));
        System.out.println(max);
    }

    private static int findMaxSumBetterApproach(int[] a, int idx) {
        if(idx >= a.length){
            return 0;
        }
        int picked = findMaxSumBetterApproach(a, idx + 2) + a[idx];
        int notPicked = findMaxSumBetterApproach(a, idx+1);

        return Math.max(picked, notPicked);
    }

    private static int findMaxSumMemoiz(int[] a, int idx, int[] dp) {
        if(idx >= a.length){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int picked = findMaxSumMemoiz(a, idx + 2, dp) + a[idx];
        int notPicked = findMaxSumMemoiz(a, idx+1, dp);

        return dp[idx] = Math.max(picked, notPicked);
    }
    private static int findMaxSumTabulation(List<Integer> a) {
        int n = a.size();
        int[] dp = new int[n+1];
        dp[n] = 0;

        for(int i = n-1; i>=0; i--){
            int pick = i+2 > n ? a.get(i) : dp[i+2] + a.get(i);
            int nonpic = dp[i+1];

            dp[i] = Math.max(pick, nonpic);
        }
        Arrays.stream(dp).forEach(System.out::println);
        return dp[0];
    }
}
