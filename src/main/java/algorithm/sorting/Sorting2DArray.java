package algorithm.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Sorting2DArray {
    public static void main(String[] args) {
        int[][] a = {{1,3}, {2,6}, {8,10}, {15,18}, {0,4}};

        Comparator<int[]> comparator = Comparator.comparingInt(o -> o[1]);
        Arrays.sort(a, comparator);
        for(int i=0; i< a.length; i++){
            for (int j = 0; j < 2; j++) {
                System.out.print(a[i][j]+",");
            }
            System.out.print("  ");
        }
    }
}
