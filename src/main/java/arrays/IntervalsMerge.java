package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalsMerge {
    public static void main(String[] args) {
        //int[][] a = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] a = {{1,4}, {0,2}, {3,5}};
        int[][] sol = sol2(a);
        System.out.println("final output:---------");
        printMatrix(sol);
    }

    private static void printMatrix(int[][] sol){
        System.out.println();
        for(int i=0; i< sol.length; i++){
            for (int j = 0; j < 2; j++) {
                System.out.print(sol[i][j]+",");
            }
            System.out.print(" ");
        }
        System.out.println();
    }
    public static int[][] sol2(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        List<Integer[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(new Integer[]{interval[0], interval[1]});
        }
        List<Integer[]> temp = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            Integer[] curr = list.get(i);
            Integer[] next = list.get(i + 1);

            if(curr[1] < next[1]){

            }
            if (curr[0] < next[0]) {
                next[0] = curr[0];
                if(temp.size()>0)
                temp.remove(temp.size()-1);
                temp.add(next);
            }
        }
        int[][] mergedIntervals = new int[temp.size()][2];
        for(int i=0; i<temp.size(); i++){
            Integer[] val = temp.get(i);
            mergedIntervals[i][0] = val[0];
            mergedIntervals[i][1] = val[1];
        }
        return mergedIntervals;
    }
}
