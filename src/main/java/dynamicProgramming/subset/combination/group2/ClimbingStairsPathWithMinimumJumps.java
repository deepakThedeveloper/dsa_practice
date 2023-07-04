package dynamicProgramming.subset.combination.group2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClimbingStairsPathWithMinimumJumps {
    public static void main(String[] args) {
        int[] jumps = {3,3,0,2,2,3};
        int minJumps = getMinJumpsDPDirectApproach(6, jumps);
        System.out.println("dp:"+minJumps);
    }


    private static int getMinJumpsDPDirectApproach(int steps, int[] jumps) {
        int len = jumps.length;
        Integer[] dp = new Integer[len];

        dp[len-1] = 0;
        for(int i=len-2; i>=0; i--){
            int min = Integer.MAX_VALUE;
            for(int j=1; j<=jumps[i] && i+j < len; j++){
                min = dp[i+j] != null ? Math.min(min, dp[i+j]) : min;
            }
            dp[i] = min != Integer.MAX_VALUE ? min + 1 : null;
        }

        Arrays.stream(dp).forEach(v-> System.out.print(v+" "));
        return dp[0];
    }
}
