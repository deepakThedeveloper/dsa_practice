package slidingwindow;

import javafx.util.Pair;

import java.util.*;

// there is an array and K window. in every pass need to move window by one to right and which ever max value is present
// int that window should be printed
public class MaxValueInKWindowSubarray {
    public static void main(String[] args) {
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        printMaxInKWindowApproach1(a, k);
        System.out.println("========================================");
        printMaxInKWindowApproach2(a, k);
    }

    //tc: O(nlogk)
    private static void printMaxInKWindowApproach1(int[] a, int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for(int i=0; i<k; i++){
            queue.add(a[i]);
        }
        System.out.println(queue.peek());
        for(int i=k; i<a.length; i++){
            queue.remove(a[i-k]);
            queue.add(a[i]);
            System.out.println(queue.peek());
        }
    }

    // todo: doesn't work properly. incorrect output
    private static void printMaxInKWindowApproach2(int[] a, int k){
        int n = a.length;
        int rem = n%k;
        int q = n/k;
        q = rem == 0 ? q : q+1;

        List<int[]> max = new ArrayList<>(q);

        for(int i=0; i<q; i++){
            max.add(new int[]{Integer.MIN_VALUE, -1});
        }
        int loc = 0;

        // filling max array with max values in k window subarray
        for(int i=0; i<n; i++){
            loc = i/k;
            int[] pair = max.get(loc);
            if(pair[0]<a[i]){
                pair[0] = a[i];
                pair[1] = i;
                max.set(loc, pair);
            }
        }

        int loc1, loc2;
        for(int i=0, j=k-1; j<n; i++, j++){
            loc1 = i/k;
            loc2 = j/k;

            int[] pair1 = max.get(loc1);
            int[] pair2 = max.get(loc2);
            int maxVal;
            if(pair1[1] >= i && pair2[1]<=j){
                maxVal = Math.max(pair1[0], pair2[0]);
            }
            else if(pair1[1]>=i){
                maxVal = pair1[0];
            }
            else maxVal = pair2[0];
            System.out.println(maxVal);
        }
    }
}
