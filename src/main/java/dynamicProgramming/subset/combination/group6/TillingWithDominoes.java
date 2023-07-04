package dynamicProgramming.subset.combination.group6;

/*
there is a floor 2*n and there are n number of tiles with dimensions 2*1.
need to find total number of ways the tiles can be fitted in floor
 */
public class TillingWithDominoes {
    public static void main(String[] args) {
        int fb = 4; // floor = 2*4
        findTillingWaysDPDirect(fb);
        findTillingWaysDPMyByN(fb, 3);
    }

    private static void findTillingWaysDPDirect(int fb) {
        int[] dp = new int[fb+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=fb; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.println(dp[fb]);
    }

    private static void findTillingWaysDPMyByN(int fb, int m) {
        int[] dp = new int[fb+1];

        for(int i=1 ; i<=fb; i++){
            if(i<m){
                dp[i] = 1;
            }
            else if(i==m){
                dp[i] = 2;
            }
            else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        System.out.println(dp[fb]);
    }
}
