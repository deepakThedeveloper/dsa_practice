package algorithm.kadane;

public class KArrayMaximumSumSubset {
    public static void main(String[] args){
        int[] a = {1, 2, 7, -4, 3, 2, -10, 9, 1};
        int max = maxSumSubset(a, a.length);
        System.out.println(max);
    }

    /*
    Question: copy array arr, k times and find max sum subarray in it
    Sol: 1. if k = 1, apply kadane's
    2. if k > 1 then find sum of all elements
    3. if sum < 0, apply  kadane's on first two array
    4. if sum > 0 apply kadane's on first two array + (k-2) * sum
     */
    private static int maxSumSubset(int[] arr, int k){
        if(k==1){
            return (int)KadanesAlgorithm.maxSubarraySum(arr, arr.length);
        }
        else{
            int sum = 0;
            for(int i=0; i<arr.length; i++){
                sum += arr[i];
            }

            int[] newArr = new int[arr.length * 2];
            for(int i=0, j=0; i<newArr.length; i++, j++){
                newArr[i] = arr[j];
                if(j==arr.length-1) j=0;
            }
            int maxSum = (int)KadanesAlgorithm.maxSubarraySum(newArr, newArr.length);
            return sum < 0 ? maxSum : maxSum + (k-2) * sum;
        }
    }
}
