package dynamicProgramming.jump;

import java.util.Arrays;

public class ArraysJumpToReachDestination {

    public static void main(String[] args){
        int[] jumps = {2,3,1,1,4};
        int[] dp = new int[jumps.length];
        Arrays.fill(dp, -1);
        boolean canJumpMemo = jumpMemoization(jumps, 0, dp);
        System.out.println("memoization:"+ canJumpMemo);

        boolean canJumpTabu = canJumpTabulation(jumps);
        System.out.println("tabulation:"+ canJumpTabu);
    }

    //leetcode verified: https://leetcode.com/problems/jump-game/description/
    private static boolean jumpMemoization(int[] nums, int idx, int[] dp){
        if(idx == nums.length-1) return true;
        if(idx >= nums.length) return false;

        if(dp[idx] != -1) return dp[idx] == 1;
        for(int i=1; i<=nums[idx]; i++){
            boolean canJump = jumpMemoization(nums, idx+i, dp);
            if(canJump) {
                dp[idx] = 1;
                return true;
            }
        }
        dp[idx] = 0;
        return false;
    }

    public static boolean canJumpTabulation(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n-1] = true;

        for(int i = n-2; i>=0; i--){
            for(int j=1; j<=nums[i]; j++){
                int pos = i+j;
                if( pos < n && dp[pos]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

}
