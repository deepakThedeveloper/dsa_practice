package dynamicProgramming.partition;

import matrix.Util;

import java.util.Arrays;

// an array on integers is given. need to check if array can be partitioned into two arrays such that sum of elements of
// both the array will be same. return true or false
public class PartitionArrayInTwoEqualSubset {
    public static void main(String[] args) {
        int[] a = {4,8,12};
        int sum = Arrays.stream(a).sum();
        int target = sum/2;
        int[][] dp = Util.getMatrix(a.length, target+1, -1);
        if(sum%2!=0) System.out.println(false);

        else{
            boolean canPartition = partitionIn2SubsetMemoization(a, a.length-1, target,  dp);
            System.out.println(canPartition);

            boolean canPartition1 = partitionIn2SubsetTabulation(a, target);
            System.out.println(canPartition1);
        }
    }

    private static boolean partitionIn2SubsetMemoization(int[] a, int n, int target, int[][] dp){
        if(target == 0) return true;
        if(n==0) return a[0] == target;
        if(dp[n][target]!=-1) return dp[n][target] != 0;

        boolean take = target > a[n] && partitionIn2SubsetMemoization(a,n - 1, target - a[n], dp);
        if(take) return true;
        boolean nottake = partitionIn2SubsetMemoization(a,n-1, target, dp);
        if(nottake) return true;

        dp[n][target] = 0;
        return false;
    }

    private static boolean partitionIn2SubsetTabulation(int[] a, int target){
        int n = a.length;
        boolean[][] dp = new boolean[n][target+1];
        for(int row = 0; row<n; row++){
            dp[row][0] = true;
        }
        if(a[0]<=target)dp[0][a[0]] = true;
        for(int row = 1; row<n; row++){
            for(int j = 1; j<=target; j++){
                boolean take = j >= a[row] && dp[row - 1][j - a[row]];
                boolean nottake = dp[row-1][j];
                dp[row][j] = take || nottake;
            }
        }
        return dp[n-1][target];
    }
}


