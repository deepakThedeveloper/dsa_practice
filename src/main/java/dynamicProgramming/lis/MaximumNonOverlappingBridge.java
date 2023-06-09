package dynamicProgramming.lis;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumNonOverlappingBridge {
    public static void main(String[] args) {
        int[][] bridge = {{10, 20},{2, 7},{8, 15},{17, 3},{21, 40},{50, 4},{41, 57},{60, 80},{80, 90},{1, 30}};
        int max = maximumNonOverlappingBridge(bridge);
        System.out.println(max);
    }

    private static int maximumNonOverlappingBridge(int[][] bridge){
        Comparator<int[]> compare = (a, b)-> Integer.compare(a[0], b[0]);
        Arrays.sort(bridge,compare);

        int[] southPosition = new int[bridge.length];
        for(int i=0; i<bridge.length; i++){
            southPosition[i] = bridge[i][1];
        }
        return LongestIncreasingSubsequence.lisTabulationApproach2(southPosition);
    }
}
