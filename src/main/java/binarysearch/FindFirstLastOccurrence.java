package binarysearch;

import javafx.util.Pair;

public class FindFirstLastOccurrence {
    public static void main(String[] args){
        int[] a = {1,1,3,3,4,4,4,14,14,14,14};
        int n = 4;
        System.out.println("size:"+a.length);
        findFirstOccurrence(n, a);
        findLastOccurrence(n, a);
        System.out.println("firstOccurrence:"+ firstOccurrence);
        System.out.println("lastOccurrence:"+ lastOccurrence);
    }

    public static Pair<Integer, Integer> firstAndLastOccurrence(int[] a, int n){
        findFirstOccurrence(n, a);
        findLastOccurrence(n, a);

        return new Pair(firstOccurrence, lastOccurrence);
    }

    static int firstOccurrence = -1;
    public static void findFirstOccurrence(int n, int[] a){
        int low = 0, high = a.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(a[mid] == n) firstOccurrence = mid;
            if(a[mid] >= n) high = mid - 1;
            else low = mid + 1;
        }
    }

    static int lastOccurrence = -1;
    public static void findLastOccurrence(int n, int[] a){
        int low = 0, high = a.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(a[mid] == n) lastOccurrence = mid;
            if(a[mid] <= n) low = mid + 1;
            else high = mid - 1;
        }
    }
}
