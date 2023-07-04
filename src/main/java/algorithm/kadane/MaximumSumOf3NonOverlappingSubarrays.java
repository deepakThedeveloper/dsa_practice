package algorithm.kadane;

import java.util.Arrays;

public class MaximumSumOf3NonOverlappingSubarrays {
    public static void main(String[] args){
        int[] arr = {5,2,1,4,3,4,2,1,3,6,3,3,6};
        int subArrayLength = 3;
        int max = maxSum(arr, subArrayLength);
        System.out.println(" max:"+max);
    }

    private static int maxSum(int[] arr, int k) {
        int n = arr.length;
        int[] leftSubarray = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i < k) {
                sum += arr[i];
                leftSubarray[i] = sum;
            } else {
                sum += arr[i] - arr[i - k];
                leftSubarray[i] = Math.max(sum, leftSubarray[i - 1]);
            }
        }

        sum = 0;
        int[] rightSubarray = new int[n];
        rightSubarray[n - 1] = arr[n - 1];
        for (int i = n - 1, count = 0; i >= 0; i--, count++) {
            if (count < k) {
                sum += arr[i];
                rightSubarray[i] = sum;
            } else {
                sum += arr[i] - rightSubarray[i + k];
                rightSubarray[i] = Math.max(sum, rightSubarray[i + 1]);
            }
        }


        int[] prefixSum = new int[n];
        for(int i=0; i<n; i++){
            if(i==0) prefixSum[i] = arr[i];
            else prefixSum[i] = prefixSum[i-1]+arr[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = k; i < n- 2*k; i++) {
            max = Math.max(max, leftSubarray[i-1] + rightSubarray[i+k] + (prefixSum[i+k-1] - prefixSum[i-1]));
        }

        return max;
    }
}
