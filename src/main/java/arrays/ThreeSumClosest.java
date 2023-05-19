package arrays;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        new ThreeSumClosest().threeSumClosestLeetCode(nums, target);
    }

    public int threeSumClosestLeetCode(int[] nums, int target) {
        return getMinSum(nums, target);
    }

    /*
    3 sum technique is two pointer great technique when we want to add three values of an array.
    normally if we need to add any three values of array we will land up in n3 time complexity. n(n-1)(n-1).
    3 sum technique reduces it to n^2.
    in normal technique we iterate through all the elements even if there are irrelevant.
    in 3 sum technique we just do n(n-1), that is the irrelevant combinations are avoided in calculation.
    this is basically two sum technique, where two numbers are added and merged with third number.
    so any kth sum in array, should be first brought down recursively to 3 sum technique and then apply below sudocode
    sudocode:
    1. sort the array in ascending
    2. run a loop i from 0 to n-2
    3. take two value left = i+1 and right = n-1;
    4. while(left < right)
        5. sum = nums[i]+nums[left]+nums[right];
        6. if sum < target : left++
        7. else : right --;
     by above technique both pointers left and right are moving in one iteration and irrelevant combinations we can avoid based
     on target
     */
    public int getMinSum(int[] nums, int target){
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int finalSum = 0;
        for(int i=0; i<nums.length-2; i++){
            int left = i+1;
            int right = nums.length-1;

            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                int diff = target>sum ? target-sum : sum-target;
                if(diff < minDiff){
                    minDiff = diff;
                    finalSum = sum;
                }
                if(sum == target){
                    break;
                }
                if(sum<target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return finalSum;
    }
}
