package binarysearch;

public class FindPeakElementInUnsortedArray {
    public static void main(String[] args){
        int[] arr = {1,2,4,6,5,7,20,30,40,50,60};
        int peak = findPeakElement(arr, 0, arr.length - 1);
        System.out.println(peak);
    }

    public static int findPeakElement(int[] arr, int low, int high){
        int n = arr.length;
        while(low <= high){
            int mid = (low + high) / 2;
            if(mid > 0 && mid < n - 1){
                if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]){
                    return mid;
                }
                else if(arr[mid - 1] > arr[mid]) high = mid - 1;
                else low = mid + 1;
            }
            else if(mid == 0){
                return arr[0] > arr[1] ? 0 : 1;
            }
            else if(mid == n - 1){
                return arr[n-1] > arr[n-2] ? n-1 : n-2;
            }
        }
        return -1;
    }
}
