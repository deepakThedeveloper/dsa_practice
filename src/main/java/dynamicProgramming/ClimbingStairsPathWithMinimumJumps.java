package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairsPathWithMinimumJumps {
    public static void main(String[] args) {
        int[] jumps = {3,3,0,2,2,3};
        //getMinJumps(6, 0, jumps, 0, 0, "");
//        System.out.println("recursion:"+min);
        getMinJumpsMemoization(6, 0, jumps, 0, 0,  new HashMap<>());
        System.out.println("memoization:"+min1);
//        int minPath = getMinPathsWithJumpsTabulation(6, jumps);
//        System.out.println("tabulation:"+minPath);
//        int totalSteps = test(4, "");
//        System.out.println();
//        System.out.println(totalSteps);
//
//        int totalSteps1 = testCountViaParam(4, "", 0);
//        System.out.println();
//        System.out.println(totalSteps1);
//
//        int count = testCountViaReturn(4, "");
//        System.out.println();
//        System.out.println(count);
    }

    private static int test(int n, String op) {
        if(n<0) return 0;
        if(n==0) {
            System.out.print(op+", ");
            return 1;
        }

        int sum=0;
        for(int i=1; i<=3; i++){
            sum += test(n-i, op+i);
        }
        return sum;
    }

    private static int testCountViaParam(int n, String op, int count) {
        if(n<0) return 0;
        if(n==0) {
            System.out.print("{"+op+"="+count+"}, ");
            return 1;
        }
        int sum=0;
        for(int i=1; i<=3; i++){
            sum += testCountViaParam(n-i, op+i, count+1);
        }
        return sum;
    }

    //todo
    private static int testCountViaReturn(int n, String op) {
        if(n<0) return 0;
        if(n==0) return 1;

        int count=0;
        for(int i=1; i<=3; i++){
            count += testCountViaReturn(n-i, op+i)+1;
            System.out.print("{"+op+i+"="+count+"}, ");
        }
        return count;
    }

    static int min = Integer.MAX_VALUE;
    private static void getMinJumps(int n, int step, int[] jumps, int k, int count, String op) {
        //System.out.println("in method");
        if(step>n) return;
        if(step == n) {
            if(count<min){
                min = count;
                //System.out.println(op);
            }
            return;
        }
        for(int i=k; i<jumps.length; i++){
            for(int j=1; j<=jumps[i]; j++){
                getMinJumps(n, step+j, jumps, k+j, count+1, op+j);
            }
        }
    }

    //todo: once I learn to return count in return then I can work o this
    static int min1 = Integer.MAX_VALUE;
    private static boolean getMinJumpsMemoization(int n, int step, int[] jumps, int k, int count, Map<Integer, Integer> dp) {
        if(step>n) return false;
        if(step == n) {
            //min1 = Math.min(min1, count);
            return true;
        }
        for(int i=k; i<jumps.length; i++){
            for(int j=1; j<=jumps[i]; j++){
                boolean reached = getMinJumpsMemoization(n, step+j, jumps, k+j, count+1, dp);
                if(reached){
                    int count1 = count+1;
                    System.out.println(count1);
                    min1 = Math.min(count1, min1);
                }
            }
        }
        dp.put(step, count);
        return true;
    }

    // solving the problem in opposite direction i.e from n to 0.
    private static int getMinPathsWithJumpsTabulation(int n, int[] jumps) {
        int[] dp = new int[n+1];
        dp[n] = 0;

        for(int i=n-1; i>=0; i--){
            int min = Integer.MAX_VALUE;
            for(int j=1; j<=jumps[i]; j++){
                if(i+j>n) break;
                min = Math.min(min, dp[i+j]);
            }
            dp[i] = min == Integer.MAX_VALUE ? min : min+1;
        }

        return dp[0];
    }
}
