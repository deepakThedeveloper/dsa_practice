package algorithm.kadane;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] a = {1, 2, 7, -4, 3, 2, -10, 9, 1};
        long max = maxSubarraySum(a, a.length);
        System.out.println(max);
    }
    public static long maxSubarraySum(int[] arr, int n) {
        long sum = 0l;
        long max = -1l;
        for(int i=0; i<n; i++){
            sum += arr[i];
            if(sum < 0) {
                sum = 0;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
