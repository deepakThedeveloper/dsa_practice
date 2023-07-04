package algorithm.kadane;

import java.util.Arrays;

public class MaximumSumOf2NonOverlappingSubarrays {
    public static void main(String[] args){
        int[] arr = {3,8,1,3,2,1,8,9,0};
        int x = 2, y = 3;
        int max = maxSum(arr, x, y);
        System.out.println(" max:"+max);
    }

    // x and y represents 2 subarray size which should be non-overlapping
    private static int maxSum(int[] arr, int x, int y){
        int n = arr.length;
        int[] xSizeSubarrayMaxVal = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++){
            if(i<x) {
                sum += arr[i];
                xSizeSubarrayMaxVal[i] = sum;
            }
            else{
                sum += arr[i] - arr[i-x];
                xSizeSubarrayMaxVal[i] = Math.max(sum, xSizeSubarrayMaxVal[i-1]);
            }
        }

        sum=0;
        int[] ySizeSubarrayMaxVal = new int[n];
        ySizeSubarrayMaxVal[n-1] = arr[n-1];
        for(int i=n-2; i>=0; i--){
            if(n-i-1<y) {
                sum += arr[i];
                ySizeSubarrayMaxVal[i] = sum;
            }
            else{
                sum += arr[i] - ySizeSubarrayMaxVal[i+y];
                ySizeSubarrayMaxVal[i] = Math.max(sum, ySizeSubarrayMaxVal[i+1]);
            }
        }

        System.out.println(" for x size ");
        Arrays.stream(xSizeSubarrayMaxVal).forEach(v-> System.out.print(v+" "));
        System.out.println();
        System.out.println(" for y size ");
        Arrays.stream(ySizeSubarrayMaxVal).forEach(v-> System.out.print(v+" "));

        int max = Integer.MIN_VALUE;
        for(int i=x-1; i<n-y; i++){
            // xSizeSubarrayMaxVal[i] -  will be max value from 0 - i of sub array size x (left to right)
            // ySizeSubarrayMaxVal[i+1] - will be max value from n - i of subarray of size y (right to left)
            // so non-overlapping.
            max = Math.max(max, xSizeSubarrayMaxVal[i] + ySizeSubarrayMaxVal[i+1]);
        }
        return max;
    }
}
