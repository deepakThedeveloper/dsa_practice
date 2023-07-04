package binarysearch;

import javafx.util.Pair;

public class SearchElementInfiniteSortedArray {
    public static void main(String[] args){
        int[] arr = {2,4,6,7,8,12,23,32,34,56,78,79,80,81,82,82,82,82,82,85};
        int ele = 31;

        int idx = -1;
        if(ele == arr[0]){
            idx = 0;
        }
        else if(ele > arr[0]){
            Pair<Integer, Integer> lowHigh = getHighPointer(arr, ele);
            int low = lowHigh.getKey();
            int high = lowHigh.getValue();
            System.out.println("low:"+low+" high:"+high);
            idx = searchElementIterative(arr, ele, low, high);
        }
        System.out.println(idx);
    }

    private static Pair<Integer, Integer> getHighPointer(int[] arr, int ele){
        int low = 0, tempHigh = 1;

        while(true){
            if(ele > arr[tempHigh]){
                low = tempHigh;
                tempHigh *= 2;
            }
            else
            return new Pair(low, tempHigh);
        }
    }

    public static int searchElementIterative(int[] arr, int ele, int low, int high){
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == ele) return mid;
            if(ele < arr[mid]) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
