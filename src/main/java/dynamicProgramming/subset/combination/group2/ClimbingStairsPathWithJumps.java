package dynamicProgramming.subset.combination.group2;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class ClimbingStairsPathWithJumps {
    public static void main(String[] args) {
        //int[] jumps = {3,3,1,2,2,3};
        int[] jumps = {3,3,0,2,1,2,4,2,0,0};
        int n = 10;
        Integer[] minJumps = climbingStairsWithJumpsTabulation(n, jumps);
        System.out.println(minJumps[0]);

        printPaths(minJumps, jumps);
    }

    private static void  printPaths(Integer[] minJumps, int[] jumps){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, jumps[0], minJumps[0], 0+""));

        while (!queue.isEmpty()){
            Pair curr = queue.poll();
            if(curr.minJumps==0){
                System.out.println(curr.pathSoFar);
            }
            for(int j=1; j<=curr.jumpsAllowed && curr.idx+j < jumps.length; j++){
                int ci = curr.idx+ j;
                if( minJumps[ci] !=null && minJumps[ci]==curr.minJumps-1){
                    queue.add(new Pair(ci, jumps[ci], minJumps[ci], curr.pathSoFar+"->"+ci));
                }
            }
        }
    }

    private static Integer[] climbingStairsWithJumpsTabulation(int n, int[] jumps){
        Integer[] dp = new Integer[n];
        dp[n-1] = jumps[n-1];
        for(int i=n-2; i>=0; i--){
            int steps = jumps[i];
            int min = Integer.MAX_VALUE;
            for(int j=1;j<=steps && i+j<jumps.length;j++){
                if(dp[i+j]!=null && dp[i+j]<min){
                    min = dp[i+j];
                }
            }
            if(min!=Integer.MAX_VALUE) dp[i] = min+1;
        }

        Arrays.stream(dp).forEach(v-> System.out.print(v+" "));
        return dp;
    }

    @AllArgsConstructor
    static
    class Pair{
        int idx;
        int jumpsAllowed;
        int minJumps;

        String pathSoFar;
    }
}

