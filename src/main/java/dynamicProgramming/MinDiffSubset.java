package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinDiffSubset {
    public static void main(String[] args) {
        int[] a = {2,3,1,9};
        
        int minDiff = getMinDiff(a);
        System.out.println(minDiff);

        int minDiff1 = minDiffTabulation(a);
        System.out.println(minDiff1);

        minSubsetDiffRevision(a);
    }

    // from an array two subset should be created such that difference between both sets should be minimal.
    // need to minimal difference as output and no need to create subset
    private static void minSubsetDiffRevision(int[] a){
        int target = Arrays.stream(a).sum();
        boolean[][] subsetTabulation = subsetPartitionTabulation(a, target);

        int rlen = subsetTabulation.length;
        int clen = subsetTabulation[0].length;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<clen; i++){
            System.out.print(subsetTabulation[rlen-1][i]+" ");
            if(subsetTabulation[rlen-1][i]){
                int s2 = target - i;
                min = Math.min(min, Math.abs(s2- i));
            }
        }
        System.out.println();
        System.out.println("min difference:"+min);
    }

    private static boolean[][] subsetPartitionTabulation(int[] a, int target){
        int n = a.length;
        boolean[][] dp = new boolean[n][target+1];

        for(int row=0; row<n; row++){
            dp[row][0] = true;         // based on recursion base case if target==0 return 1/true;
        }
        if(a[0]<=target) dp[0][a[0]] = true; //based on recursion base case if n==0 then return a[0]==target;

        for(int row = 1; row<n; row++){
            for(int j=1; j<=target; j++){
                boolean take = j >= a[row] && dp[row - 1][j - a[row]];
                boolean nottake = dp[row-1][j];
                dp[row][j] = take || nottake;
            }
        }
        return dp;
    }

    private static int minDiffTabulation(int[] a){
        int sum = Arrays.stream(a).sum();
        int n = a.length;
        boolean[][] dp = new boolean[n][sum+1];

        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        if(a[0]<=sum) dp[0][a[0]] = true;

        for(int i=1; i<n; i++){
            for(int j=1; j<=sum; j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(a[i]<=j){
                    take = dp[i-1][j-a[i]];
                }

                dp[i][j] = take || notTake;
            }
        }
        for(int i=0; i<dp[0].length; i++){
            System.out.print(dp[dp.length-1][i]+" ");
        }
        //printMatrix(dp);

        List<Integer> vals = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i=0; i<=sum; i++){
            if(dp[n-1][i]){
                vals.add(i);
                int v2 = Math.abs(sum - i);
                min = Math.min(Math.abs(i-v2), min);
            }
        }
        System.out.println(vals);
        return min;
    }
    private static int getMinDiff(int[] a){
        List<Integer> subsetSums = new ArrayList<>();

        getAllSubsetSum(a, 0, subsetSums, 0);
        System.out.println(subsetSums);
        subsetSums.sort(Comparator.naturalOrder());
        int minDiff = Integer.MAX_VALUE;
        for(int i=0, j=subsetSums.size()-1; i<j; i++, j--){
            minDiff = Math.min(minDiff, Math.abs(subsetSums.get(i) - subsetSums.get(j)));
        }
        return minDiff;
    }
    private static void getAllSubsetSum(int[] a, int i, List<Integer> list, int sum){
        if(i==a.length){
            list.add(sum);
            return;
        }
        getAllSubsetSum(a, i+1, list, sum+a[i]);
        getAllSubsetSum(a, i+1, list, sum);
    }

    private static void printMatrix(boolean[][] a){
        int r = a.length;
        int c = a[0].length;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++) {
                System.out.print(a[i][j]+" ");
                //dp[i][j] = null;
            }
            System.out.println();
        }
    }
}
