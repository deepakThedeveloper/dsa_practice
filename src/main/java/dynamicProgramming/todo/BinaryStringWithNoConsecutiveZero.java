package dynamicProgramming.todo;

import matrix.Util;

public class BinaryStringWithNoConsecutiveZero {
    public static void main(String[] args) {
        int n = 6;
        int[][] dp = Util.getMatrix(n+1,2,-1);
        int count = binaryStringCombinationsMemoization(n, "", dp);
        System.out.println();
        System.out.println("combination:"+count);
    }

    //todo: its not working
    private static int binaryStringCombinationsMemoization(int n, String op, int[][] dp){
        if(op.length() > 2 && op.endsWith("00")) return 0;

        if(n==0){
            System.out.print(op+", ");
            return 1;
        }
        if(dp[n][1]!=-1) return dp[n][1];
        if(dp[n][0]!=-1) return dp[n][0];

        int count1 =  binaryStringCombinationsMemoization(n-1, op+"1", dp);
        int count0 =  binaryStringCombinationsMemoization(n-1, op+"0", dp);
        dp[n][1] = count1;
        dp[n][0] = count0;
        return count1+count0;
    }
}
