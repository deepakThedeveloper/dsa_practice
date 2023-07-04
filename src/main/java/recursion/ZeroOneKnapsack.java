package recursion;

import matrix.Util;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] wt = {4,4,5};
        int[] val = {50, 60, 100};
        int sackWt = 8;
//        int[] wt = {2,5,1,3,4};
//        int[] val = {15,14,10,45,30};
//        int sackWt = 7;

        int maxValue = maxValueRevisionApproach1(wt, val, sackWt, wt.length-1);
        System.out.println("maxValue:"+maxValue);

        int maxValue1 = maxValueRevision1(wt, val, sackWt, wt.length-1,0);
        System.out.println("maxValue1:"+maxValue1);

        int[][] dp = Util.getMatrix(wt.length, sackWt+1, -1);
        int maxValue2 = maxValueRevision1Memoization(wt, val, sackWt, wt.length-1,0, dp);
        System.out.println("maxValue2:"+maxValue2);
    }

    private static int maxValueRevision1(int[] wt, int[] value, int sackWt, int n, int sum){
        if(n==0){
            if(wt[n]<=sackWt) return value[n] + sum;
            return sum;
        }
        if(sackWt <= 0) return sum;

        int pick = Integer.MIN_VALUE;
        if(wt[n] <= sackWt) {
            pick = maxValueRevision1(wt, value, sackWt - wt[n], n - 1, sum + value[n]);
        }
        int notPick = maxValueRevision1(wt, value, sackWt, n - 1, sum);

        return Math.max(pick, notPick);
    }

    // this code is working but coverting it to tabulation is difficult task as 3 parameters are changing
    // sackWt, n, sum so 3D dp array needs to be created in tabulation i guess. Tried writing tabulation code with 2D array
    // bur didn't worked. will use Approach1.
    private static int maxValueRevision1Memoization(int[] wt, int[] value, int sackWt, int n, int sum, int[][] dp){
        if(n==0){
            if(wt[n]<=sackWt) return value[n] + sum;
            return sum;
        }
        if(sackWt <= 0) return sum;
        if(dp[n][sackWt] != -1) return dp[n][sackWt];
        int pick = Integer.MIN_VALUE;
        if(wt[n] <= sackWt) {
            pick = maxValueRevision1(wt, value, sackWt - wt[n], n - 1, sum + value[n]);
        }
        int notPick = maxValueRevision1(wt, value, sackWt, n - 1, sum);

        return dp[n][sackWt] = Math.max(pick, notPick);
    }

    private static int maxValueRevisionApproach1(int[] wt, int[] value, int sackWt, int n){
        if(n==0){
            if(wt[n]<=sackWt) return value[n];
            return 0;
        }
        if(sackWt <= 0) return 0;

        int pick = wt[n]<=sackWt ? maxValueRevisionApproach1(wt, value, sackWt-wt[n], n-1) + value[n]:0;
        int notPick = maxValueRevisionApproach1(wt, value, sackWt, n - 1);

        return Math.max(pick, notPick);
    }
}
