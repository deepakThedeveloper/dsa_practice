package dynamicProgramming.subset.combination.group1;

import matrix.Util;

import java.util.LinkedList;
import java.util.Queue;

public class TargetSumSubset {
    public static void main(String[] args){
        int[] arr = {4, 2, 7, 1, 3};
        int k = 10;

        isSubsetExistsForK(arr, k);

      //  countSubsetWhoseSumIsK(arr, k);
    }

    private static void isSubsetExistsForK(int[] arr, int k){
        int len = arr.length;
        boolean[][] dp = new boolean[len+1][k+1];// k target so k+1 so that k should get included.
        for(int r=0; r<=len; r++){
            dp[r][0] = true;
        }

        for(int r=1; r<=len; r++){
            for(int c=1; c<=k; c++){
                boolean notTake = dp[r - 1][c];
                boolean take = c - arr[r-1] >= 0 && dp[r - 1][c - arr[r-1]];

                dp[r][c] = notTake || take;
            }
        }

        Util.printMatrix(dp);
        boolean subsetSumIsPresent =  dp[len][k];
        System.out.println(subsetSumIsPresent);

        printSubsets(arr, dp, k);
    }

    private static void countSubsetWhoseSumIsK(int[] arr, int k){
        int len = arr.length;
        int[][] dp = new int[len+1][k+1];// k target so k+1 so that k should get included.
        for(int r=0; r<=len; r++){
            dp[r][0] = 1;
        }

        for(int r=1; r<=len; r++){
            for(int c=1; c<=k; c++){
                int notTake = dp[r - 1][c];
                int take = c - arr[r-1] >= 0 ? dp[r - 1][c - arr[r-1]] : 0;

                dp[r][c] = notTake + take;
            }
        }

        Util.printMatrix(dp);
        int subsetCount =  dp[len][k];
        System.out.println("subset count:"+subsetCount);
    }

    private static void printSubsets(int[] arr, boolean[][] dp, int k){
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(arr.length, k, ""));

        while(!queue.isEmpty()){
            Data data = queue.poll();
            int r = data.r, c = data.c;

            if(r==0 || c==0){
                System.out.println(data.psf);
                continue;
            }
            if(dp[r-1][c]){
                queue.add(new Data(r-1, c, data.psf));
            }
            if(c >= arr[r-1]) {
                if (dp[r - 1][c - arr[r - 1]]) {
                    queue.add(new Data(r - 1, c - arr[r - 1], arr[r - 1] +" "+ data.psf));
                }
            }
        }
    }


    static class Data{
        int r, c;
        String psf;

        Data(int r, int c, String psf){
            this.r = r;
            this.c = c;
            this.psf = psf;
        }
    }
}
