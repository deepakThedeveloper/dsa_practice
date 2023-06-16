package recursion.subset.partition;

public class PartitionArrayForMaxSum {
    public static void main(String[] args) {
        int[] a = {3,15,12,6,7};
        int k=2;
        int maxSum = maxSum(0, k, a);
        System.out.println(maxSum);
    }

    private static int maxSum(int i, int k, int[] a){
        if(i==a.length) return 0;

        int len = 0, sum, partitionMax = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        for(int idx = i; idx < Math.min(a.length, i+k); idx++){
            partitionMax = Math.max(partitionMax, a[idx]);
            len++;
            sum = (partitionMax * len) + maxSum(idx+1, k, a);
            max = Math.max(max, sum);
        }
        return max;
    }
}
