package dynamicProgramming.lis;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a = {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};

        int mis = misTabulationDirect(a);
        System.out.println("tabulation is direct:"+mis);
    }

    // pepcoding dsa 2
    public static int misTabulationDirect(int[] a){
        int[] dp = new int[a.length];
        dp[0] = 1; // first element will always be greater

        int finalMax = Integer.MIN_VALUE;
        for(int i=1; i<a.length; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if (a[i]>a[j]){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + a[i];
            if(dp[i] > finalMax) {
                finalMax = dp[i];
            }
        }
        Arrays.stream(dp).forEach(v-> System.out.print(v+" "));
        System.out.println();
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
