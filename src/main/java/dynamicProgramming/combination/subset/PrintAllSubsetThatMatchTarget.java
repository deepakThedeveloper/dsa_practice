package dynamicProgramming.combination.subset;

import lombok.AllArgsConstructor;
import matrix.Util;

import java.util.LinkedList;
import java.util.Queue;

public class PrintAllSubsetThatMatchTarget {
    public static void main(String[] args) {
        int[] a = {4,2,7,1,3};
        int k = 10;
        printSubsetThatMatchesK(a, k);
    }

    //todo: summit malick dsa 2
    private static void printSubsetThatMatchesK(int[] a, int k){
        boolean[][] dp = getMatrix(a, k);
        int n = dp.length;
        int m = dp[0].length;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(n, k, ""));

        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            boolean exclude = dp[cur.i-1][cur.target];
            if(exclude){
                queue.add(new Pair(cur.i - 1, cur.target, cur.psf));
            }
            if(cur.target >= a[cur.i-1]) {
                boolean include = dp[cur.i - 1][cur.target - a[cur.i - 1]];
                if(include){
                    // this line needs to be worked on. adding path in psf.
                    queue.add(new Pair(cur.i - 1, cur.target - a[cur.i - 1], cur.psf + (-1)));
                }
            }
        }
    }

    private static boolean[][] getMatrix(int[] a, int k){
        int n = a.length;
        boolean[][] dp = new boolean[n+1][k+1];
        for(int r=0; r<=n; r++){
            dp[r][0] = true;
        }
        for(int r = 1; r <= n; r++) {
            for (int c = 1; c <= k; c++) {
                boolean notTake = dp[r - 1][c];
                boolean take = c - a[r-1] >= 0 && dp[r - 1][c - a[r-1]];
                dp[r][c] = notTake || take;
            }
        }
        Util.printMatrix(dp);
        return dp;
    }

    @AllArgsConstructor
    static class Pair{
        int i;
        int target;
        String psf;
    }
}
