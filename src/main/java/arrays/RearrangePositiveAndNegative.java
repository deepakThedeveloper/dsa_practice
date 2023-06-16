package arrays;

import java.util.Arrays;
import arrays.Util;

public class RearrangePositiveAndNegative {
    public static void main(String[] args){
        int[] a = {-2, 1, 3, -6, 4, 3, -1, -2, -3, 5, 7, -5};
        int n = a.length;
        int[] a1 = new int[n];
        int[] a2 = new int[n];

        for(int i=0; i<n; i++){
            a1[i] = a[i];
            a2[i] = a[i];
        }

        Util.print1DArray("original array", a1);
        rearrangeInSameArrayApproach(a1);
        Util.print1DArray("same array approach", a1);

        Util.print1DArray("original array", a2);
        int[] result = newArray(a2);
        Util.print1DArray("new array approach", result);
    }


    private static void rearrangeInSameArrayApproach(int[] a){
        for(int i=0, j=0; j<a.length; j++){
            // positives are at even index
            if(i%2==0) {
                if(a[i] > 0) i++;
                else if(a[j] > 0) {
                    swap(i, j, a);
                    i++;
                }
            }
            // -ve are at odd index
            else {
                if(a[i] < 0) i++;
                else if(a[j] < 0) {
                    swap(i, j, a);
                    i++;
                }
            }
        }
    }

    private static void swap(int i, int j, int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
     }

    private static int[] newArray(int[] a){
        int n = a.length;
        int[] arranged = new int[n];
        int even = 0, odd = 1;
        for(int i=0; i<n; i++){
            if(a[i] > 0){
                arranged[even] = a[i];
                even = even + 2;
            }
            else{
                arranged[odd] = a[i];
                odd = odd + 2;
            }
        }
        return arranged;
    }
}
