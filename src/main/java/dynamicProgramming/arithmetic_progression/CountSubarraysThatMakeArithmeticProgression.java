package dynamicProgramming.arithmetic_progression;

//An integer array is called arithmetic progression if it consists of at least three elements and if the difference between any two consecutive elements is the same.
public class CountSubarraysThatMakeArithmeticProgression {
    public static void main(String[] args){
        int[] arr = {2, 5, 9, 12, 15, 18, 22, 26, 30, 34, 36, 38, 40, 41};
        int ans = countSubArrays(arr);
        System.out.println(ans);
    }

    //leetcode verified: https://leetcode.com/problems/arithmetic-slices/submissions/982978528/
    private static int countSubArrays(int[] arr){
        int n = arr.length;
        int[] dp = new int[n];
        int ans = 0;

        // starting from 2 because subarray should be of atleast 3 length, so no need to consider first 2 element
        for(int i=2; i<n; i++){
            if(arr[i] - arr[i-1] == arr[i-1] - arr[i-2]){
                dp[i] = dp[i-1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    }
}
