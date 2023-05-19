package arrays;

import java.util.Arrays;

public class MostWaterContainer {
    public static void main(String[] args) {
        int waterAccumulationArea = maxArea(new int[]{4,3, 2, 1, 4});
        System.out.println(waterAccumulationArea);
    }

    public static int maxArea(int[] height) {
        int max = 0;
        for(int lft = 0, rt = height.length-1; lft<rt; ){
            int area = (rt-lft) * Math.min(height[lft], height[rt]);
            max = Math.max(max, area);
            if(height[lft] <= height[rt]){
                lft++;
            }
            else{rt--;}
        }
        return max;

    }
}