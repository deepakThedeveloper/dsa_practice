package binarysearch;

public class SearchElementInSortedArray {
    public static void main(String[] args){
        int[] arr = {2,4,6,7,8,12,23,32,34,56,78};
        int ele = 23;
        int idx = searchElementIterative(arr, ele, 0, arr.length - 1);
        System.out.println(idx);
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
