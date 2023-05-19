package dynamicProgramming;

/*
there is a floor 2*n and there are n number of tiles with dimensions 2*1.
need to find total number of ways the tiles can be fitted in floor
 */
public class TillingWithDominoes {
    public static void main(String[] args) {
        int fb = 4; // floor = 2*6
//        findTillingWays(fb,"");
//        findTillingWaysDP(fb);

        findTillingWaysMbyN(fb,"",2);
        findTillingWaysDPMyByN(fb, 2);
    }

    private static void findTillingWaysDP(int fb) {
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

    private static void findTillingWays(int fb, String op) {
        if(fb<0){
            return;
        }
        if(fb==0){
            System.out.println(op);
            return;
        }
        findTillingWays(fb-2, op+"h");
        findTillingWays(fb-1, op+"v");
    }

    private static void findTillingWaysMbyN(int fb, String op, int m) {
        if(fb<0){
            return;
        }
        if(fb==0){
            System.out.println(op);
            return;
        }
        findTillingWays(fb-m, op+"h");
        findTillingWays(fb-1, op+"v");
    }
}
