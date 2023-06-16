package recursion.jump;

import java.util.Arrays;

public class ArraysJumToReachDestination {

    public static void main(String[] args){
        int[] jumps = {2,3,1,1,4};
        boolean canJump = jump(jumps, 0);

        System.out.println(canJump);
    }

    //leetcode verified: https://leetcode.com/problems/jump-game/description/
    private static boolean jump(int[] nums, int idx){
        if(idx == nums.length-1) return true;
        if(idx >= nums.length) return false;

        for(int i=1; i<=nums[idx]; i++){
            boolean canJump = jump(nums, idx+i);
            if(canJump) {
                return true;
            }
        }
        return false;
    }
}
