package dynamicProgramming.subset.combination.group2;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ClimbingStairsPath {
    public static void main(String[] args) {
        int totalStairs = 4;

        int paths = stairsPathMemoization(totalStairs, new int[totalStairs+1]);
        System.out.println("total paths memoization:"+paths);

        int paths1 = stairsPathTabulation(totalStairs);
        System.out.println("total paths tabulation:"+paths1);

        int paths2 = stairsPathTest(totalStairs);
        System.out.println("total paths test:"+paths2);

    }

    private static int stairsPathTest(int n){
        if(n<0) return 0;
        if(n==0) return 1;
        int path =
                stairsPathTest(n-1) + stairsPathTest(n-5);
        return path;
    }

    private static int stairsPathMemoization(int n, int[] dp){
        if(n<0) return 0;
        if(n==0) return 1;
        if(dp[n]!=0) return dp[n];

        int path =
                stairsPathMemoization(n-1, dp) + stairsPathMemoization(n-2, dp) + stairsPathMemoization(n-3, dp);
        return dp[n] = path;
    }

    private static int stairsPathTabulation(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            int p1 = dp[i-1];
            int p2 = i-2 < 0 ? 0 : dp[i-2];
            int p3 = i-3 < 0 ? 0 : dp[i-3];

            int path = p1 + p2 + p3;
            dp[i] = path;
        }
        return dp[n];
    }
}
