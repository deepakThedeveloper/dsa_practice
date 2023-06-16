package arrays.slidingwindow;

import java.util.Arrays;
import java.util.Stack;

// two pointer approach. i = 0 , j = n-1. calculate area, then whose ht is less move that pointer
public class TrappingRainWater2 {
    public static void main(String[] args) {
        int[] ht = {1,8,6,2,5,4,8,3,7};
        int water = maxArea(ht);
        System.out.println("water:"+water);
    }

    // leetcode working. https://leetcode.com/problems/container-with-most-water/description/
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right])left++;
            else right--;
        }
        return maxArea;
    }
}
