package algorithm.sorting;

import java.util.Arrays;

//Todo
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {9,3,2,7,5,1,0,6,11,32,45,23,12,67,17};
        Arrays.stream(a).forEach(val -> System.out.print(val + " "));

        System.out.println();
        System.out.println("sorted:====================================");
        //int[] sortedArray = mergeSort(a);
        mergeSortBetter(a);
        Arrays.stream(a).forEach(val -> System.out.print(val+" "));
    }

    private static void mergeSortBetter(int[] a){
        divideBetter(a, 0, a.length-1);
    }

    private static void divideBetter(int[] a, int start, int end) {
        if(start>=end) return;

        int mid = (start+end)/2;

        divideBetter(a, start, mid);
        divideBetter(a, mid+1, end);

        mergeBetter(a, start, mid, end);
    }

    private static void mergeBetter(int[] a, int start, int mid, int end) {
        int[] op = new int[a.length];

        int idx = 0, i=start, j=mid+1;
        for( ;i<=mid && j<=end; idx++) {
            if(a[i]<a[j]){
                op[idx] = a[i];
                i++;
            }
            else {
                op[idx] = a[j];
                j++;
            }
        }
        for(;i<=mid; i++, idx++){
            op[idx] = a[i];
        }
        for(;j<=end; j++, idx++){
            op[idx] = a[j];
        }

        for(int k=start; k<=end; k++){
            a[k] = op[k-start];
        }
    }

    // in divide method called from this method it creates new int[] object when start>=end which increases space
    // for better version refer mergeSortBetter
    private static int[] mergeSort(int[] a) {
        return divide(a, 0, a.length-1);
    }

    private static int[] divide(int[] a, int start, int end){
        if(start>=end) return new int[]{a[start]};

        int mid = (start+end)/2;

        int[] left = divide(a, start, mid);
        int[] right = divide(a, mid+1, end);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right){
        int n = left.length;
        int m = right.length;
        int[] op = new int[n+m];

        int idx = 0, i=0, j=0;
        for(; i<n && j<m; ) {
            if(left[i]<right[j]){
                op[idx] = left[i];
                i++;
            }
            else if(right[j] < left[i]){
                op[idx] = right[j];
                j++;
            }
            else{
                op[idx] = left[i];
                i++;
                j++;
            }
            idx++;
        }
        for(;i<n; i++, idx++){
            op[idx] = left[i];
        }
        for(;j<m; j++, idx++){
            op[idx] = right[j];
        }
        return op;
    }
}
//1,2,3,4,7
//2,3,5,6

//1,2,3,4,5,6