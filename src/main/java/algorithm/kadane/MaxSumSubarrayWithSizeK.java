package algorithm.kadane;

public class MaxSumSubarrayWithSizeK {
    public static void main(String[] args) {

//        int[] a = {2, 3, 1, -7, 6, -5, -4, 4, 3, 3, 2, -9, -5, 6, 1, 2, 1, 1};
        int[] a = {2, 3, 1, 2, -1, 6, -5, -9, 4, 3, 3, 2, -9, -5, 11 , 4};
        int k = 4;
        int max = maxSumSubarrayWihKLenApproach1(a, k);
        System.out.println("max:"+max);
    }

    // applied normal kadane's algo with change that will consider sum of subarray only when distance between j-i >=k.
    // intution is kadane's give max sum subarray in original array but it is possible that count of the subarray is not k,
    // and there is other subarray which has sum < kadane's sum but it has at least k elements. we need to compare such sum.
    //todo: need to be tested against other test cases as well, to confirm whether this code works
    private static int maxSumSubarrayWihKLenApproach1(int[] arr, int k){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0, j=0; j<arr.length; j++){
            int temp = sum + arr[j];
            if(temp < 0){
                sum = 0;
                i=j+1;
            }
            else{
                sum += arr[j];
                if((j-i) + 1 >=k){
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    //todo: summit mallik approach dp level2
    private static int maxSumSubarrayWihKLenApproach2(int[] arr, int k){
      return 0;
    }
}
