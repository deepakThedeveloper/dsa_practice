package dynamicProgramming.lis;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

public class PrintAllLis {
    public static void main(String[] args) {
        int[] a = {10, 22, 42, 33, 21, 50, 41, 60, 80, 3};
        printAllLis(a);
    }

    private static void printAllLis(int[] a){
        Data lis = LongestIncreasingSubsequence.lisTabulationApproach2ReturnArray(a);
        Queue<Pair> queue = new LinkedList<>();
        int[] dp = lis.dp;
        int n = dp.length;
        queue.add(new Pair(lis.max, lis.maxIndex, a[lis.maxIndex]+""));

        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            if(cur.length == 1){
                System.out.println(cur.pathSoFar);
            }
            for(int i = cur.index-1; i>=0; i--){
                if(dp[i] == cur.length-1 && a[i]<=a[cur.index]){
                    queue.add(new Pair(dp[i], i, a[i]+"->"+cur.pathSoFar));
                }
            }
        }
    }

    @AllArgsConstructor
    static class Pair{
        int length;
        int index;
        String pathSoFar;
    }
}
