package dynamicProgramming.subset.combination.group1;

import javafx.util.Pair;

import java.util.*;

public class MinJumpToReachDestination {
    public static void main(String[] args){
        int[] jumps = {3,3,0,2,1,2,4,2,0,0};
        minJumpsAndPrintAllPaths(jumps);
    }

    private static void minJumpsAndPrintAllPaths(int[] jumps){
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
        System.out.println();

        printPaths(dp, jumps);
    }

    private static void printPaths(Integer[] dp, int[] jumps){
        Queue<Pair<Integer, String>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, "0"));

        while(!queue.isEmpty()){
            Pair<Integer, String> pair = queue.poll();
            int i = pair.getKey();
            if(dp[i]==0) {
                System.out.println(pair.getValue());
                continue;
            }
            for(int j=1; j<=jumps[i] && i+j < jumps.length; j++){
                if(dp[i+j] != null && dp[i+j] == dp[i]-1){
                    queue.add(new Pair<>(i+j, pair.getValue()+"->"+(i+j)));
                }
            }
        }
    }
}
