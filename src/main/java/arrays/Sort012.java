package arrays;

import java.util.Arrays;


public class Sort012 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 2, 0, 1, 2, 2, 2, 1, 1, 0, 0, 2, 0, 0, 0, 1, 1, 1, 2, 1, 0, 1, 0, 1, 0, 1, 1, 0, 2};

        System.out.println("before:");
        Arrays.stream(arr).forEach(v->System.out.print(v+" "));
        System.out.println();

        sort012MyApproach(arr);
        sort012BetterApproach(arr);
    }

    private static void sort012BetterApproach(int[] a){
        int n = a.length;
        int[] arr = new int[n];
        for(int i=0; i<a.length; i++){
            arr[i] = a[i];
        }
        int low = 0;
        int mid = 0;
        int high = n-1;

        while(mid <= high){
            if(arr[mid] == 0){
                swap(mid, low, arr);
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else if(arr[mid] == 2){
                swap(mid, high, arr);
                high--;
            }
        }
        System.out.println("after better approach:");
        Arrays.stream(arr).forEach(v->System.out.print(v+" "));
        System.out.println();
    }

    private static void sort012MyApproach(int[] a){
        int n = a.length;
        int[] arr = new int[n];
        for(int i=0; i<a.length; i++){
            arr[i] = a[i];
        }
        int zero = zeroPointer(arr, 0, n);
        int two = twoPointer(arr, 0, n-1);

        int k = zero;
        while(k<=two){
            if(arr[k] == 1) {
                k++;
                continue;
            }
            else if(arr[k] == 2) swap(k, two, arr);
            else if(arr[k] == 0) swap(k, zero, arr);
            two = twoPointer(arr, zero, two);
            zero = zeroPointer(arr, zero, two);
            if(k<zero) k = zero;
        }

        System.out.println("after my approach:");
        Arrays.stream(arr).forEach(v->System.out.print(v+" "));
        System.out.println();
    }

    private static void swap(int i, int j, int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static int twoPointer(int[] arr, int start, int end){
        int two = end;
        while(two > start){
            if(arr[two] == 2) two--;
            else break;
        }
        return two;
    }
    private static int zeroPointer(int[] arr, int start, int end){
        int zero = start;
        while(zero < end){
            if(arr[zero] == 0) zero ++;
            else break;
        }
        return zero;
    }
}
