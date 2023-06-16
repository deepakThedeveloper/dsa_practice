package arrays.prefixsuffix;

public class ProductOfArrayExceptElementItself {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        int[] result = productExceptSelf(nums);
    }

    //leetcode verified: https://leetcode.com/problems/product-of-array-except-self/description/
    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] suffix = new int[n];
        int[] prefix = new int[n];

        suffix[n-1] = nums[n-1];
        prefix[0] = nums[0];

        for(int i=n-2, j=1; i>=0 && j<n; i--, j++){
            suffix[i] = suffix[i+1] * nums[i];
            prefix[j] = prefix[j-1] * nums[j];
        }

        // Arrays.stream(prefix).forEach(v->System.out.print(v+" "));
        // System.out.println();
        // Arrays.stream(suffix).forEach(v->System.out.print(v+" "));
        // System.out.println();
        int[] result = new int[n];
        result[0] = suffix[1];
        for(int i=1; i<n-1; i++){
            result[i] = suffix[i+1] * prefix[i-1];
        }
        result[n-1] = prefix[n-2];

        return result;
    }
}
