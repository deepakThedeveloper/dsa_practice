package binarysearch;

public class FindMinElementInRotatedSortedArray {
    public static void main(String[] args){
        int[] odd = {8,2,3,4,5,6,7};
        int[] even = {1,2,3,4,5,6,7,0};
        int n = 6;
        int index = findMinElement(odd);
        System.out.println(index);
    }

    public static int findMinElement(int[] arr){
        int n = arr.length;
        int low = 0, high = n - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < arr[(mid + n - 1) % n] && arr[mid] < arr[(mid + 1) % n]) return mid;
            if (arr[low]<=arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
