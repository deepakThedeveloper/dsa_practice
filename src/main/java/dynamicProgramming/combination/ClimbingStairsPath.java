package dynamicProgramming.combination;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ClimbingStairsPath {
    public static void main(String[] args) {
        int paths = stairsPathMemoization(4, new HashMap<>());
        System.out.println("total paths:"+paths);
    }

    private static int stairsPathMemoization(int n, Map<Integer, Integer> dp){
        System.out.println("in method");

        if(n<0) return 0;
        if(n==0) return 1;
        if(dp.containsKey(n)) return dp.get(n);
        int path = stairsPathMemoization(n-1, dp) +
        stairsPathMemoization(n-2, dp) +
        stairsPathMemoization(n-3, dp);

        dp.put(n, path);
        return path;
    }
}
