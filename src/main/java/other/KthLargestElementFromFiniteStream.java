package other;

import java.util.Arrays;

public class KthLargestElementFromFiniteStream {
    public static void main(String[] args) {
        int[] arr = {9,7,5,11,12,2,14,3,10,6};
        int k = 3, n = arr.length;
        int val = quickSelect(arr, 0,n-1, n-k);
        System.out.println(k+" largest value is:"+val);
    }

    private static int quickSelect(int[] arr, int start, int pivot, int k) {
        while(start<=pivot) {

            int breakPoint = partition(arr, pivot);
            Arrays.stream(arr).forEach(val -> System.out.print(val + ","));

            if (breakPoint == k) return arr[breakPoint];
            if(breakPoint < k) start = breakPoint +1;
            else{ pivot = breakPoint-1;}
        }
        return -1;
    }

    private static int partition(int[] arr, int pivot) {
        int pointer = pivot;
        for(int i=0; i<=pivot-1; i++){
            if (arr[i] > arr[pivot]) {
                if (pointer == pivot) {
                    pointer = i;
                }
            }
            else{
                if(pointer != pivot){
                    swap(arr, pointer, i);
                    pointer++;
                }
            }
        }
        swap(arr, pointer, pivot);
        return pointer;
    }

    private static void swap(int[] arr, int pointer, int i) {
        int temp = arr[pointer];
        arr[pointer] = arr[i];
        arr[i] = temp;
    }
}

//10,9,8,7,4,3,2,1
