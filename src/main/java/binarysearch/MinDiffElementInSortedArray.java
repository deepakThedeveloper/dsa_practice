package binarysearch;

import javafx.util.Pair;

// find element with whom abs diff of k is less. e.g. [4,6,10] k = 7 ans  = 6 [4-7, 6-7, 10-7]
public class MinDiffElementInSortedArray {
    public static void main(String[] args){
        int[] arr = {2,4,6,7,8,12,23,32,34,56,78};
        int ele = 18;

        int minDiff = findElementWithMinDiff(arr, ele);
        System.out.println(minDiff);
    }

    public static int findElementWithMinDiff(int[] arr, int ele){
        Pair<Integer, Integer> floorAndCeil = FindFloorAnCeilInSortedArray.floorAndCeil(arr, ele);
        int floor = floorAndCeil.getKey();
        int ceil = floorAndCeil.getValue();
        if(floor == ele || ceil == ele) return 0;

        return Math.min(Math.abs(ele - floor), ceil - ele);
    }
}
