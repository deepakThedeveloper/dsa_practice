package arrays;

import java.util.Arrays;

public class CountInversionInArray {
    public static void main(String[] args) {
        int[] arr = {5,3,2,4,1};
        countInversions(arr);
        Arrays.stream(arr).forEach(v->System.out.print(v+" "));
        System.out.println();
        System.out.println("inversion count:"+count);
    }

    private static void countInversions(int[] arr){
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
                count = count + (m-i)+1; // this is the logic of inversion. 2,3,5 -- 1,4 if 2>1 means 3 and 5 will be > than 1.
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
    }
}
