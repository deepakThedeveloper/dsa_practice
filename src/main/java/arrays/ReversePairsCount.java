package arrays;

import java.util.Arrays;

// same like count inversion in array with difference that i<j && a[i] > 2*a[j];
public class ReversePairsCount {
    public static void main(String[] args) {
        int[] arr = {40, 25, 19, 12, 9, 6, 2};
        countReversePairs(arr);
        Arrays.stream(arr).forEach(v->System.out.print(v+" "));
        System.out.println();
        System.out.println("reverse pairs count:"+count);
    }

    private static void countReversePairs(int[] arr){
        divide(arr, 0, arr.length-1);
    }

    private static void divide(int[] arr, int s, int e){
        if(s>=e) return;
        int m = (s+e)/2;

        divide(arr, s, m);
        divide(arr, m+1, e);

        merge(arr, s, m, e);
    }

    static int count = 0;
    private static void merge(int[] a, int s, int m, int e){
        int[] op = new int[a.length];

        int idx = 0, i=s, j=m+1;
        for(; i<=m && j<=e; idx++){
            if(a[i]<a[j]){
                op[idx] = a[i];
                i++;
            }
            else{
                for(int k = i; k<=m; k++) {
                    if (a[k] > 2 * a[j]) {
                        count = count + (m - k) + 1;
                        break;
                    }
                }
                op[idx] = a[j];
                j++;
            }
        }

        while(i<=m){
            op[idx] = a[i];
            i++; idx++;
        }
        while(j<=e){
            op[idx] = a[j];
            j++; idx++;
        }

        for(int k=s; k<=e; k++){
            a[k] = op[k-s];
        }
        Arrays.stream(a).forEach(v->System.out.print(v+" "));
        System.out.println();
    }
}
