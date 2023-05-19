package recursion;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        Arrays.stream(a).forEach(System.out::print);

        reverse(a, 0, a.length-1);
        System.out.println();
        Arrays.stream(a).forEach(System.out::print);

    }

    private static void reverse(int[] a, int start, int end){
        if(start>=end){
            return;
        }
        reverse(a, start+1, end-1);
        int temp = a[start];
        a[start] = a[end];
        a[end] = temp;

    }
}
