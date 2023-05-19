package algorithm.sorting;

import arrays.PartitionAnArray;

import java.util.Arrays;

public class QuickSortRevision {
    public static void main(String[] args) {
        int[] a={71,93,82,3,6,2,14,0,59,12,9,32,11};


        quickSort(a, a.length-1, 0, a.length);

        System.out.println();
        System.out.println("sorted...............");
        Arrays.stream(a).forEach(v-> System.out.print(v+" "));
    }

    public static void quickSort(int a[], int pivotPosition, int start, int end){
        if(start>=end-1) return;
        int pivot = a[pivotPosition];
        int n = PartitionAnArray.partitionBasedOnPivot(pivot, a, start, end, pivotPosition);
        quickSort(a, n-1, start, n);
        quickSort(a, n+1, n, end);
    }
}
