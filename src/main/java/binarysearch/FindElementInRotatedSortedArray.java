package binarysearch;

public class FindElementInRotatedSortedArray {
    public static void main(String[] args){
        int[] odd = {6,7,8,2,3,4,5};
        int[] even = {4,7,1,3,8,9,10};
        int n = 5;
//        int index = findElementInRotatedSortedArray(even, n);
//        System.out.println("my approach:"+index);

        int index1 = findElementInRotatedSortedArrayBetterApproach(even, n);
        System.out.println("better approach:"+index1);
    }

    private static int findElementInRotatedSortedArrayBetterApproach(int[] arr, int ele){
        int minElementIndex = FindMinElementInRotatedSortedArray.findMinElement(arr);
        if(minElementIndex != -1 && arr[minElementIndex] == ele) return minElementIndex;

        int idx = SearchElementInSortedArray.searchElementIterative(arr, ele, 0, minElementIndex - 1);
        return idx != -1 ? idx :  SearchElementInSortedArray.searchElementIterative(arr, ele, minElementIndex, arr.length-1);
    }

    // not working
    private static int findElementInRotatedSortedArray(int[] arr, int ele){
        int low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == ele) return mid;
            if (ele > arr[mid]) {
                if(ele > arr[high]) {
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            } else {
                if (arr[mid] < arr[high]) {
                    high = mid - 1;
                } else {
                    if (ele > arr[high]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
