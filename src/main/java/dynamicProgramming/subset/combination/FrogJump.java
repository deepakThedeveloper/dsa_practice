package dynamicProgramming.subset.combination;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FrogJump {
    public static void main(String[] args) {
        int[] ht = {30,10,60,10,50};

//        int min = findMinEnergyNeededToJump(ht, ht.length-1, 0);
//        System.out.println("min energy needed:"+min);
//        int min = findMinEnergyNeededToJumpBetterApproach(ht, ht.length-1);
//        System.out.println("min energy needed:"+min);
//        System.out.println("----------------------------------------------");
//        int[] dp = new int[ht.length+1];
//        IntStream.range(0, ht.length+1).forEach(i -> dp[i]=-1);
//        int min1 = findMinEnergyNeededToJumpMemoization(ht, ht.length-1, dp);
//        System.out.println("min energy needed:"+min1);
//          findMinEnergyNeededToJumpTabulation(ht, ht.length, 2);
          findMinEnergyNeededToJumpTabulationKSteps(ht, ht.length, 2);
    }

    // frog needs to jum from start 0 to end i.e. 4. ht is difference between two building and frog needs diff between two hts to
    // jump. need to find the way through which frog should require min energy to reach from 0,4(n).
    // he can jump either one building or two at max
    private static int findMinEnergyNeededToJump(int[] ht, int n, int energyNeeded) {
        if(n==0) {
            return energyNeeded;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(n>=1)
        left = findMinEnergyNeededToJump(ht, n-1, energyNeeded +Math.abs(ht[n]-ht[n-1]));
        if(n>=2)
        right = findMinEnergyNeededToJump(ht, n-2, energyNeeded +Math.abs(ht[n]-ht[n-2]));

        return Math.min(left, right);
    }
    private static int findMinEnergyNeededToJumpBetterApproach(int[] ht, int n) {
        if(n==0) {
            return 0;
        }

        System.out.println("hello:"+n);
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(n>=1)
        left = findMinEnergyNeededToJumpBetterApproach(ht, n-1) + Math.abs(ht[n]-ht[n-1]);
        if(n>=2)
        right = findMinEnergyNeededToJumpBetterApproach(ht, n-2) +Math.abs(ht[n]-ht[n-2]);

        return Math.min(left, right);
    }
    private static int findMinEnergyNeededToJumpMemoization(int[] ht, int n, int dp[]) {
        if(n==0) {
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        System.out.println("hello:"+n);
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        left = findMinEnergyNeededToJumpMemoization(ht, n-1, dp) + Math.abs(ht[n]-ht[n-1]);
        if(n>=2)
        right = findMinEnergyNeededToJumpMemoization(ht, n-2, dp) +Math.abs(ht[n]-ht[n-2]);
        return dp[n] = Math.min(left, right);
    }

    //30,10,60,10,50 - 0,20,30,0,10
    private static void findMinEnergyNeededToJumpTabulation(int[] ht, int n, int k) {
        int dp[] = new int[n];
        dp[0] = 0;
        int second = Integer.MAX_VALUE;

        for(int i=1; i<n; i++){
            int first = dp[i-1] + Math.abs(ht[i] - ht[i-1]);
            if(i>1){
               second = dp[i-2]+Math.abs(ht[i] - ht[i-2]);
            }
            dp[i] = Math.min(first, second);
        }
        System.out.println("max energy:"+dp[n-1]);
    }

    private static void findMinEnergyNeededToJumpTabulationKSteps(int[] ht, int n, int k) {
        int dp[] = new int[n];
        dp[0] = 0;
        int second = Integer.MAX_VALUE;

        for(int i=1; i<n; i++){
            int maxEnergy = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                if(i<j) break;
                int first = dp[i-j] + Math.abs(ht[i] - ht[i-j]);
                maxEnergy = Math.min(first, maxEnergy);
            }
            dp[i] = maxEnergy;
        }
        System.out.println("max energy:"+dp[n-1]);
    }
}
