package binarysearch;

import javafx.util.Pair;

public class FindFloorAnCeilInSortedArray {
    public static void main(String[] args){
        int[] arr = {2,4,6,7,8,12,23,32,34,56,78,79};
        int ele = 9;
        int floor = findFloorIterative(arr, ele, 0,arr.length-1);
        int ceil = findCeilIterative(arr, ele, 0,arr.length-1);
        System.out.println("floor:"+floor+" ceil:"+ceil);
    }

    public static Pair<Integer, Integer> floorAndCeil(int[] arr, int ele){
        int low = 0, high = arr.length - 1;
        return new Pair<>(findFloorIterative(arr, ele, low, high), findCeilIterative(arr, ele, low, high));
    }

    public static int findFloorIterative(int[] arr, int ele, int low, int high){
        int result = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == ele) return arr[mid];
            if(ele < arr[mid]) high = mid - 1;
            else{
                result = arr[mid];
                low = mid + 1;
            }
        }
        return result;
    }

    public static int findCeilIterative(int[] arr, int ele, int low, int high){
        int result = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == ele) return arr[mid];
            if(ele < arr[mid]){
                result = arr[mid];
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return result;
    }
}
