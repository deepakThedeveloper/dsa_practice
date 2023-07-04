package binarysearch;

public class PreviousAndNextLetterInSortedArray {
    public static void main(String[] args){
        char[] arr = {'a','b','c','d','e','f'};
        char ele = 'e';
        char prev = findPreviousIterative(arr, ele, 0,arr.length-1);
        char next = findNextIterative(arr, ele, 0,arr.length-1);
        System.out.println("prev:"+prev+" next:"+next);
    }

    public static char findPreviousIterative(char[] arr, char ele, int low, int high){
        char result = '\u0000';
        while(low <= high){
            int mid = (low + high) / 2;
            if(ele <= arr[mid]) high = mid - 1;
            else{
                if(arr[mid] != ele) result = arr[mid];
                low = mid + 1;
            }
        }
        return result;
    }

    public static char findNextIterative(char[] arr, char ele, int low, int high){
        char result = '\u0000';
        while(low <= high){
            int mid = (low + high) / 2;
            if(ele < arr[mid]){
                if(arr[mid] != ele) result = arr[mid];
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return result;
    }
}
