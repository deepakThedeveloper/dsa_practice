package arrays;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int a[] = {1,3,5,7};
        int b[] = {0,2,6,8,9};
        /*int a[] = {5,6};
        int b[] = {4,6};*/

        System.out.println("before merging");
        Arrays.stream(a).forEach(v -> System.out.print(v+" "));
        System.out.println();
        Arrays.stream(b).forEach(v -> System.out.print(v+" "));

        merge(a,b);
        System.out.println();
        System.out.println("after merging");
        Arrays.stream(a).forEach(v -> System.out.print(v+" "));
        System.out.println();
        Arrays.stream(b).forEach(v -> System.out.print(v+" "));
    }

    private static void merge(int[] a, int[] b) {
        for(int i=0; i<a.length;i++){
            if(a[i] > b[0]){
                int temp = a[i];
                a[i] = b[0];
                b[0] = temp;

                sort(b);
            }
        }
    }

    private static void sort(int[] b) {
        for(int i=0; i<b.length-1; i++){
            if(b[i]>b[i+1]){
                swap(b,i,i+1);
            }
        }
    }

    private static void swap(int[] b, int i, int i1) {
        int temp = b[i];
        b[i] = b[i1];
        b[i1] = temp;
    }
}
