package recursion;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {5,2,8,7,1,0,6};
        
        bubbleSort(a,0, 0);
        Arrays.stream(a).forEach(System.out::print);
    }

    static boolean iterate = true;
    private static void bubbleSort(int[] a, int n, int count) {
        if(a.length-1 == n) return;

        if(iterate){
            iterate = false;
            bubbleSort(a, 0, count+1);
        }
        if (a[n] > a[n + 1]) {
            int temp = a[n + 1];
            a[n + 1] = a[n];
            a[n] = temp;
        }
        bubbleSort(a, n + 1, count);
        if(n==0 && count<a.length-1) iterate = true;
    }
}
