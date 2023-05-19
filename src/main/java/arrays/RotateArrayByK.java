package arrays;

import java.util.Arrays;

public class RotateArrayByK {
    public static void main(String[] args) {
        int[] a = new int[]{10, 40, 25, 12, 35, 70};
        int k = 5;

        Arrays.stream(a).forEach(op-> System.out.print(op+","));
        System.out.println();
        //rotate(a, k);
        Arrays.stream(a).forEach(op-> System.out.print(op+","));
        rotateNew(a, k);
    }

    private static void rotate(int[] a, int k){
        if(k == a.length) return;
        while(k>0) {
            for (int i = 0, j = i + 1; j < a.length; i++, j++) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            k--;
        }
    }

    // approach 2: Most Optimal TC O(N)+O(N) SC O(1)
    public static void rotateNew(int[] nums, int k) {
        int len = nums.length;
        int finalK = k % len;

        if(finalK == 0) return;
        reverse(nums, 0, len-1);
        reverse(nums, 0, finalK-1);
        reverse(nums, finalK, len-1);
    }

    private static void reverse(int[] nums, int s, int e){
        for(int i = s, j=e; i<j; i++, j--){
            int temp  = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
