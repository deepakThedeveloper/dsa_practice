package dynamicProgramming.combination;

import java.util.stream.IntStream;

//todo: not working
public class ClimbingStairsWithJumps {
    public static void main(String[] args) {
        int[] jumps = {1,2,3};
        int n = 4;
        int path = getTotalPathsWithJumps(n, jumps, 0);
        System.out.println(path);
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
