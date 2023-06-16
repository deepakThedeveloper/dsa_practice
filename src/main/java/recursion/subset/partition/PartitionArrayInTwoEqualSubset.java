package recursion.subset.partition;

import java.util.Arrays;

// an array on integers is given. need to check if array can be partitioned into two arrays such that sum of elements of
// both the array will be same. return true or false
public class PartitionArrayInTwoEqualSubset {
    public static void main(String[] args) {
        int[] a = {4,8,12};
        int sum = Arrays.stream(a).sum();
        boolean canPartition;
        if(sum%2!=0) canPartition = false;

        else canPartition = partitionIn2Subset(a, sum/2, a.length-1);
        System.out.println(canPartition);
    }

    private static boolean partitionIn2Subset(int[] a, int target, int n){
        if(target == 0) return true;
        if(n==0) return a[0] == target;

        boolean take = target > a[n] && partitionIn2Subset(a, target - a[n], n - 1);
        if(take) return true;
        boolean nottake = partitionIn2Subset(a, target, n-1);
        if(nottake) return true;

        return false;
    }
}
