package algorithm.sorting;

//7,9,2,6,4,0,11,3,19,8
//7,9,2,6,4,0,11,3,19,8
//7,2,6,4,0,9,11,3,19,8
//7,2,6,4,0,3,11,9,19,8
//7,2,6,4,0,3,9,11,19,8

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
       // int[] arr = {9,7,5,11,12,2,14,3,10,6};
        int[] arr = {7,9,2,6,4,0,11,3,19,8};
        quickSort(arr, 0,arr.length-1);
        System.out.println();
        Arrays.stream(arr).forEach(val -> System.out.print(val+","));
    }

    private static void quickSort(int[] arr, int start, int pivot) {
        if(start>=pivot){
            return;
        }
        int breakPoint = partition(arr, pivot);
        quickSort(arr, start, breakPoint-1);
        Arrays.stream(arr).forEach(val -> System.out.print(val+","));
        System.out.println();
        quickSort(arr, breakPoint + 1, pivot);
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
