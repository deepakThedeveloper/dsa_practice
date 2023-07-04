package dynamicProgramming.subset.combination.group2;
/*
0 - 0
1 - 1 (n-1)
2 - 1 {min(dp(n-2), dp(n-1)) + 1}
3 - 1 {min(dp(n-3), dp(n-2), dp(n-1)) + 1}
4 - 2 {min(dp(n-3), dp(n-2), dp(n-1)) + 1}
5 - 2 {min(dp(n-3), dp(n-2), dp(n-1)) + 1}
6 - 2 {min(dp(n-3), dp(n-2), dp(n-1)) + 1}
7 - 3 {min(dp(n-3), dp(n-2), dp(n-1)) + 1}
 */
public class ClimbingStairsWithMinSteps {
    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        getTotalWays(n, k);
        getMinSteps(n, k);
    }


    private static void getMinSteps(int n, int k) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            if(i==2){
                dp[i] = Math.min(dp[n-2], dp[n-1])+1;
            }
            dp[i] = Math.min(dp[n-3], Math.min(dp[n-2], dp[n-1]))+1;
        }

        System.out.println("min moves:"+dp[n]);
    }

    private static void getTotalWays(int n, int k) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            if(i==2){
                dp[i] = dp[i-1] + dp[i-2];
            }
            else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }

        System.out.println("total steps:"+dp[n]);
    }
}
