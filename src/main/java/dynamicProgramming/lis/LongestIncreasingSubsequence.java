package dynamicProgramming.lis;

import matrix.Util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};

        int[][] dp = Util.getMatrix(a.length, a.length+1, -1);
        int lis1 = lisMemoizationRevision(0, -1, a, dp);
        System.out.println("memoization lis:"+lis1);

        int lis2 = lisTabulationRevision(a);
        System.out.println("tabulation lis:"+lis2);

        int lis3 = lisTabulationDirect(a);
        System.out.println("tabulation lis direct:"+lis3);
    }

    private static int lisMemoizationRevision(int idx, int prev, int[] a, int[][] dp){
        if(idx==a.length) return 0;

        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
        int notTake = lisMemoizationRevision(idx+1, prev, a, dp);
        int take = Integer.MIN_VALUE;
        if(prev ==-1 || a[idx]>a[prev])
            take = lisMemoizationRevision(idx+1, idx, a, dp) + 1;

        return dp[idx][prev+1] = Math.max(notTake, take);
    }

    private static int lisTabulationRevision(int[] a){
        int n = a.length;
        int[][] dp = Util.getMatrix(n+1, n+1, 0);

        for(int i=n-1; i>=0; i--){
            for(int j=i-1; j>=-1; j--){
                int notTake = dp[i+1][j+1];
                int take = Integer.MIN_VALUE;
                if(j==-1 || a[i]>a[j]) {
                    take = dp[i+1][i+1] + 1;
                }
                dp[i][j+1] = Math.max(notTake, take);
            }
        }
        //Util.printMatrix(dp);
        return dp[0][0];
    }

    // pepcoding dsa 2
    public static int lisTabulationDirect(int[] a){
        int[] dp = new int[a.length];
        dp[0] = 1; // first element will always be greater

        int finalMax = Integer.MIN_VALUE, finalMaxIndex = -1;
        for(int i=1; i<a.length; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if (a[i]>a[j]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            if(dp[i] > finalMax) {
                finalMax = dp[i];
                finalMaxIndex = i;
            }
        }
        Arrays.stream(dp).forEach(v-> System.out.print(v+" "));
        System.out.println();
        printLIS(dp, a, finalMaxIndex);
        return finalMax;
    }

    private static void printLIS(int[] dp, int[] a, int lisIndex) {
        Queue<Triplet> queue = new LinkedList<>();
        queue.add(new Triplet(lisIndex, "" + a[lisIndex]));

        while (!queue.isEmpty()) {
            Triplet trip = queue.poll();
            int idx = trip.idx;
            if(idx == 0){
                System.out.println(trip.psf);
                continue;
            }
            for (int i = trip.idx-1; i >= 0; i--) {
                if(dp[idx] - dp[i] == 1 && a[idx] > a[i]){
                    queue.add(new Triplet(i, a[i]+"->"+trip.psf));
                }
            }
        }
    }

    static class Triplet{
        int idx;
        String psf;

        Triplet(int idx, String psf){
            this.idx = idx;
            this.psf = psf;
        }
    }

    public static Data lisTabulationApproach2ReturnArray(int[] a){
        int[] dp = new int[a.length];
        dp[0] = 1; // first element will always be greater

      //  int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        int finalMax = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i=1; i<a.length; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if (a[i]>a[j]){
                    max = Math.max(max, dp[j]);

                }
            }
            dp[i] = max+1;
            if(dp[i]>finalMax) {
                finalMax = dp[i];
                maxIndex = i;
            }
        }

        return new Data(dp, finalMax, maxIndex);
    }
}
