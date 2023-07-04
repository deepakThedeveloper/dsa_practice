package dynamicProgramming.lis;

import java.util.Arrays;
import java.util.Comparator;

// Russian Doll envelop is also same as this .
public class MaximumNonOverlappingBridge {
    public static void main(String[] args) {
        int[][] bridge = {{10, 20},{2, 7},{8, 15},{17, 3},{21, 40},{50, 4},{41, 57},{60, 80},{80, 90},{1, 30}};
        int max = maximumNonOverlappingBridge(bridge);
        System.out.println(max);
    }

    // for bridges to be non-overlapping the north and south point of bridge should be greater than north and south of other bridge.
    // 1. sort bridge by north point so every bridge north point is arranged in asc order
    // 2. take LIS of south. In LIS we get such subsequence which are greater. i.e sorting sorts whole array,
    // but LIS just gives us subsequence which are in asc order but doesn't sorts them. In this way we will get such bridges
    // whose north and south point are greater than north and south of other bridge.
    private static int maximumNonOverlappingBridge(int[][] bridge){
        Comparator<int[]> compare = Comparator.comparingInt(a -> a[0]);
        Arrays.sort(bridge,compare);

        int[] southPosition = new int[bridge.length];
        for(int i=0; i<bridge.length; i++){
            southPosition[i] = bridge[i][1];
        }
        return LongestIncreasingSubsequence.lisTabulationDirect(southPosition);
    }
}
