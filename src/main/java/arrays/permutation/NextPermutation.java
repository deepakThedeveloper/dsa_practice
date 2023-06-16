package arrays.permutation;

import arrays.Util;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args){
        int[] currentPermutation = {2,3,1,4,5};  // for number 123 (123,132,213,231,312,321)
        Util.print1DArray("original permutation:", currentPermutation);
        nextPermutation(currentPermutation);
        Util.print1DArray("next permutation:", currentPermutation);
    }

    private static void nextPermutation(int[] a){
        // step 1: search for break in ascending order from last till first
        int n = a.length, i=n-1;
        for(; i > 0; i--){
            if(a[i]>a[i-1]) break;
        }
        if(i == 0){
            // need to return first permutation
            reverse(i, n-1, a);
        }
        else{
            // step 2: find just next bigger than replaceable
            int replaceable = i-1;
            for(i = n-1; i>replaceable; i--){
                if(a[i] > a[replaceable]) break;
            }
            int nextBigger = i;
            swap(replaceable, nextBigger, a);

            // step 3: reverse the remaining portion of array from replaceable+1 till n
            reverse(replaceable+1, n-1, a);
        }
    }

    private static void reverse(int start, int end, int[] a){
        while(start < end){
            swap(start, end, a);
            start++;
            end--;
        }
    }

    private static void swap(int i, int j, int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
