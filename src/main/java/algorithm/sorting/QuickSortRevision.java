package algorithm.sorting;

import arrays.PartitionAnArray;

import java.util.Arrays;
import arrays.Util;

public class QuickSortRevision {
    public static void main(String[] args) {
        int[] a={4, 6, 2, 8, 2, 11, 5, 7, 9, -1, 1, 3, 12, 0, 9, 32, 2};

        quickSortRevision(a, 0, a.length-1);
        Util.print1DArray("sorted array revision", a);
    }

    private static void quickSortRevision(int[] a, int low, int high){
        if(low>=high) return;

        int pivotNewIndex = placePivotAtPosition(a, low, high, low);
        quickSortRevision(a, low, pivotNewIndex - 1);
        quickSortRevision(a, pivotNewIndex + 1, high);
    }

    private static int placePivotAtPosition(int[] a, int low, int high, int pivot){
        while(low<high){
            while(low <= high && a[low] <= a[pivot]) low++;
            while(high >= low && a[high] > a[pivot]) high--;

            if(low<=high && a[low] > a[pivot] && a[high] <= a[pivot]) {
                swap(low, high, a);
                low++;
                high--;
            }
        }
        swap(high, pivot, a);
        return high;
    }

    private static void swap(int i, int j, int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void quickSort(int a[], int pivotPosition, int start, int end){
        if(start>=end-1) return;
        int pivot = a[pivotPosition];
        int n = PartitionAnArray.partitionBasedOnPivot(pivot, a, start, end, pivotPosition);
        quickSort(a, n-1, start, n);
        quickSort(a, n+1, n, end);
    }
}
