package dynamicProgramming.subset.combination.group2;

public class ClimbingStairsWithMinCost {
    public static void main(String[] args) {
        int[] cost = {0,3,2,4,6,1,1,5,3};
        int n = 9;

        findMinCostToClimbStairs(cost, n);
    }

    // climbing at most 2 steps.
    private static void findMinCostToClimbStairs(int[] cost, int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = cost[1];

        for(int i=2; i<n; i++){
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        System.out.println("min cost to reach at n:"+n+" is:"+dp[n-1]);
    }
}
