package dynamicProgramming;

import java.util.stream.IntStream;

public class ClimbingStairsPathWithJumps {
    public static void main(String[] args) {
        //int[] jumps = {3,3,1,2,2,3};
        int[] jumps = {1,2,3};
        int n = 4;
        int path = getTotalPathsWithJumps(n, jumps, 0);
        System.out.println(path);

//        int path1 = getTotalPathsWithJumpsTabulation(n, jumps);
//        System.out.println(path1);
    }

    // solving the problem in opposite direction i.e from n to 0.
    private static int getTotalPathsWithJumpsTabulation(int n, int[] jumps) {
        int[] dp = new int[n+1];
        dp[n] = 1;

        for(int i=n-1; i>=0; i--){
            for(int j=1; j<=jumps[i]; j++){
                if(i+j>n) break;
                dp[i] += dp[i+j];
            }
        }

        return dp[0];
    }

    private static int getTotalPathsWithJumps(int n, int[] jumps, int step) {
        if(n==step) return 1;
        if(n < step) return 0;
        int jump = jumps[step];
        int[] p1 = new int[jumps[step]];
        for(int j=1; j<=jump; j++){
           int val = getTotalPathsWithJumps(n, jumps, step+j);
           p1[j-1] = val;
        }

        return IntStream.of(p1).sum();
    }
}
