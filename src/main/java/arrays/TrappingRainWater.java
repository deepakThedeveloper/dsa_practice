package arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] ht = {0,1,0,2,1,0,1,3,2,1,2,1};
        new TrappingRainWater().trap(ht);
    }
    //[0,1,0,2,1,0,1,3,2,1,2,1]
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0; int right = height.length - 1; // Pointers to both ends of the array.
        int maxLeft = 0; int maxRight = 0;

        int totalWater = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    totalWater += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    totalWater += maxRight - height[right];
                }
                right--;
            }
        }
        return totalWater;
    }
}
