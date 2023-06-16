package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int a[] = {1, 1, 2, 3,5,7};
        int b[] = {0,2,6,8,9};


        System.out.println("before merging");
        Arrays.stream(a).forEach(v -> System.out.print(v+" "));
        System.out.println();
        Arrays.stream(b).forEach(v -> System.out.print(v+" "));

        List<Integer> result = mergeTwoSortedArrayAndReturnNewArray(a, b);
        System.out.println("new sorted array:"+result);
        merge(a,b);
        System.out.println();
        System.out.println("after merging");
        Arrays.stream(a).forEach(v -> System.out.print(v+" "));
        System.out.println();
        Arrays.stream(b).forEach(v -> System.out.print(v+" "));
    }

    private static List<Integer> mergeTwoSortedArrayAndReturnNewArray(int[] a, int[] b){
        int n = a.length, m = b.length;
        List<Integer> result = new ArrayList<>();
        int i=0, j=0, prev = -1;
        for(; i<n && j<m;){
            int v;
            if(a[i]<=b[j]){
                v = a[i];
                i++;
            }
            else{
                v= b[j];
                j++;
            }

            if(prev==-1 || v != prev){
                result.add(v);
                prev = v;
            }
        }

        while(i<n){
            if(a[i]!=prev){
                result.add(a[i]);
                prev = a[i];
            }
            i++;
        }
        while(j<m){
            if(b[j]!=prev){
                result.add(b[j]);
                prev = b[j];
            }
            j++;
        }
        return result;
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
