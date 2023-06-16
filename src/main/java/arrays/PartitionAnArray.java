package arrays;

import java.util.Arrays;

/* 7,9,4,8,3,6,2,1
   4,9,7,8,3,6,2,1
   4,8,7,9,3,6,2,1
   4,3,2,1,8,7,6,9
 */
public class PartitionAnArray {
    public static void main(String[] args) {

        int[] a={7,9,4,8,3,6,2,1,10,5};
        int[] a1={7,9,4,8,3,6,2,1,10,5};

        int pivotIndex = a.length-2;
        int pivot = a[pivotIndex];

        partitionBasedOnPivot(pivot, a, 0, a.length, pivotIndex);
        Arrays.stream(a).forEach(v-> System.out.print(v+", "));
        System.out.println();
        partitionRevision(a1, pivotIndex);
        Arrays.stream(a1).forEach(v-> System.out.print(v+", "));
        System.out.println();
    }

    private static void partitionRevision(int[] a, int pivotIndex){
        System.out.println("pivot:"+a[pivotIndex]);
        int big = -1;
        for(int i=0; i<a.length;i++){
            if(i==pivotIndex) continue;
            if(a[i]<a[pivotIndex] && big!=-1){
                swap(a, i, big);
                big++;
            }
            if(a[i]>a[pivotIndex] && big == -1) big=i;
        }

        if(big != -1){
            if(big < pivotIndex) swap(a, big, pivotIndex);
            else swap(a, big-1, pivotIndex);
        }
        else{
            swap(a, pivotIndex, a.length-1);
        }
    }

    public static int partitionBasedOnPivot(int pivot, int[] a, int start, int end, int pivotPosition) {
        int i = start;
        for(int j=i+1; j<end;  j++){
            if(a[i]<a[j]) continue;
            swap(a,i,j);
            if(a[i]<pivot)
                i++;
            if(i<end && j==end-1){
                j=i;
            }
        }

//        System.out.println("pivot:"+pivot);
//        Arrays.stream(a).forEach(v-> System.out.print(v+" "));
//        System.out.println();

        if(a[pivotPosition] == pivot){
           // System.out.println("pivot position:"+ pivotPosition);
            return pivotPosition;
        }
        //System.out.println("pivot position:"+ i);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
