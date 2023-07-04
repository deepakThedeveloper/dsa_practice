package binarysearch;

public class FindElementInNearlySortedArray {
    public static void main(String[] args){
        int[] arr = {10,20,40,30,50,70,60};
        int ele = 70;
        int idx = searchElementIterative(arr, ele, 0, arr.length - 1);
        System.out.println(idx);
    }

    public static int searchElementIterative(int[] arr, int ele, int low, int high){
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == ele) return mid;
            if(mid > low && arr[mid - 1] == ele) return mid - 1;
            if(mid < high && arr[mid + 1] == ele) return mid + 1;
            if(ele < arr[mid]) high = mid - 2;
            else low = mid + 2;
        }
        return -1;
    }
}
