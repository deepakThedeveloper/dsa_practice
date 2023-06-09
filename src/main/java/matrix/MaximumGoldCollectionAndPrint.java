package matrix;

import lombok.AllArgsConstructor;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumGoldCollectionAndPrint {
    public static void main(String[] args) {
        int[][] mine = {{3,2,5,1}, {2,4,6,0}, {5,0,1,3}, {9,1,5,1}};
        Util.printMatrix(mine);
        System.out.println();
        collectMaxGoldAndPrintAllPathsToIt(mine);
    }
    private static void collectMaxGoldAndPrintAllPathsToIt(int[][] mine){
        int n = mine.length;
        int m = mine[0].length;

        int[][] dp = Util.getMatrix(n, m, 0);
        for(int r=0; r<n ; r++){
            dp[r][m-1] = mine[r][m-1];
        }

        for(int c = m-2; c>=0; c--){
            for(int r=n-1; r>=0; r--){
                int upperBound = r-1>=0 ? dp[r-1][c+1] : Integer.MIN_VALUE;
                int lowerBound = r+1<n ? dp[r+1][c+1] : Integer.MIN_VALUE;
                dp[r][c] = Math.max(upperBound, Math.max(dp[r][c+1], lowerBound)) + mine[r][c];
            }
        }

        Util.printMatrix(dp);

        printPaths(dp);
    }

    private static void printPaths(int[][] dp){
        Queue<Pair> queue = new LinkedList<>();
        int n = dp.length;
        int max = Integer.MIN_VALUE;
        for (int[] ints : dp) {
            max = Math.max(max, ints[0]);
        }
        for(int r=0; r<n; r++){
            if(dp[r][0] == max){
                String index = ""+r+0;
                queue.add(new Pair(max, r, 0, index+""));
            }
        }

        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            int r = cur.row;
            int c = cur.col;

            if(c==dp[0].length-1){
                System.out.println(cur.pathSoFar);
            }
            else {
                int newC = c+1;
                int max1;
                if(r==0){
                    max1 = Math.max(dp[r][newC], dp[r+1][newC]);
                }
                else if(r == n-1){
                    max1 = Math.max(dp[r-1][newC], dp[r][newC]);
                }
                else{
                    max1 = Math.max(dp[r-1][newC], Math.max(dp[r][newC], dp[r+1][newC]));
                }
                for(int i = r-1; i<=r+1; i++){
                    if(i<0 || i==n) continue;
                    if(dp[i][newC] == max1){
                        String index = "" + i + newC;
                        queue.add(new Pair(dp[i][newC], i, newC, cur.pathSoFar+"->"+index));
                    }
                }
            }
        }
    }

    @AllArgsConstructor
    static class Pair{
        int val;
        int row;
        int col;
        String pathSoFar;
    }
}
