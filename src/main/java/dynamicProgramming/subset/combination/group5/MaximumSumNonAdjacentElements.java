package dynamicProgramming.subset.combination.group5;

public class MaximumSumNonAdjacentElements {
    public static void main(String[] args){
        int[] a = {5, 10, 10, 100, 5, 6};
        int maxSum = maximumSumOfNonAdjSubset(a);
        System.out.println("max sum:"+maxSum);
    }

    private static int maximumSumOfNonAdjSubset(int[] a){
        int n = a.length;
        int[][] dp = new int[n][n];
        dp[0][0] = a[0];

        for(int i=1; i<n; i++){
            dp[0][i] = a[i] + dp[1][i-1];
            dp[1][i] = Math.max(dp[0][i-1], dp[1][i-1]);
        }
        return Math.max(dp[0][n-1], dp[1][n-1]);
    }
}
