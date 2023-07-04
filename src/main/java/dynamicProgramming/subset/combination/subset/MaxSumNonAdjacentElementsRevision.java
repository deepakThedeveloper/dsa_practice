package dynamicProgramming.subset.combination.subset;

import java.util.Arrays;

//todo
public class MaxSumNonAdjacentElementsRevision {
    public static void main(String[] args) {
        int[] a = {2,1,4,9};
        //int[] a = {1,2,3,4};

//        findMaxSum(a, 0,0, "");
//        System.out.println("max sum:"+max);
//        System.out.println("finalOP:"+finalOP);

//        findMaxSum(a, 0, 0, 0, "");
//        System.out.println("max sum:"+max);
//        System.out.println("finalOP:"+finalOP);
//
//        int maxValue = findMaxSum1(a, 0, 0, 0);
//        System.out.println("max sum:"+maxValue);

//        int[] dp =  new int[a.length];
//        IntStream.range(0, dp.length).forEach(i->dp[i]=-1);
//        int maxVal = subsetSumAdditionUsinMemoization(a, 0,dp);
//        Arrays.stream(dp).forEach(v->System.out.print(v+" "));
//        int[] dp =  new int[a.length];
//        IntStream.range(0, dp.length).forEach(i->dp[i]=-1);
        int maxVal = findMaxSumBetterApproach(a, 0);
        System.out.println("max val:"+maxVal);
//        int[] dp =  new int[a.length];
//        IntStream.range(0, dp.length).forEach(i->dp[i]=-1);
//        int maxVal = findMaxSumMemoiz(a, 0, dp);
//        Arrays.stream(dp).forEach(v->System.out.print(v+" "));
//        System.out.println("max val:"+maxVal);
//        int max = findMaxSumTabulation(a);
//        System.out.println(max);
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
    private static int findMaxSumTabulation(int[] a) {
        int[] dp = new int[a.length+1];
        dp[a.length] = 0;

        for(int i = a.length-1; i>=0; i--){
            int pick = i+2 > a.length ? a[i] : dp[i+2] + a[i];
            int nonpic = dp[i+1];

            dp[i] = Math.max(pick, nonpic);
        }
        Arrays.stream(dp).forEach(System.out::println);
        return dp[0];
    }
//11,1,9,0
    static int max = Integer.MIN_VALUE;
    static String finalOP = "";
    private static void findMaxSum(int[] a, int sum, int idx, String op) {
        if(idx >= a.length){
            System.out.println("sum:"+sum);
            System.out.println("op:"+op);
            if(max<sum){
                max = sum;
                finalOP = op;
            }
            return;
        }
        for(int i=idx; i<a.length; i=i+1){
            findMaxSum(a, sum+a[i],i+2, op+a[i]);
        }
    }

    private static void findMaxSum1(int[] a, int sum, int idx, int prev, String op) {
        if(idx == a.length){
            if(max<sum){
                max = sum;
                finalOP = op;
            }
            return;
        }
        for(int i=idx; i<a.length; i=i+1){
            if(i-prev == 1) continue;
            findMaxSum1(a, sum+a[i],i+1, i, op+a[i]);
        }
    }

    private static int findMaxSum2(int[] a, int sum, int idx, int prev) {
        if(idx == a.length){
            return sum;
        }
        int max = Integer.MIN_VALUE;
        for(int i=idx; i<a.length; i=i+1){
            if(i-prev == 1) continue;
            max = Math.max(max, findMaxSum2(a, sum+a[i],i+1, i));
        }
        return max;
    }

    private static int subsetSumAdditionUsinMemoization(int[] a, int idx, int[] dp) {
        if(idx == a.length){
            return 0;
        }
        if(idx>a.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        System.out.println("hello:"+idx);
        int picked = subsetSumAdditionUsinMemoization(a, idx + 1, dp) + a[idx];
        int notPicked = subsetSumAdditionUsinMemoization(a, idx + 1, dp);
        dp[idx] = picked;
        return dp[idx];
    }

}
