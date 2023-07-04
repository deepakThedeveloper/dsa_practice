package binarysearch;

import javafx.util.Pair;

public class CountParticularNumber {
    public static void main(String[] args) {
        int[] a = {1, 1, 3, 3, 4, 4, 4, 14, 14, 14, 14};
        int n = 4;

        Pair<Integer, Integer> pairFirstAndLast = FindFirstLastOccurrence.firstAndLastOccurrence(a, n);
        int first = pairFirstAndLast.getKey();
        int last = pairFirstAndLast.getValue();
        System.out.println("firstOccurrence:"+ first);
        System.out.println("lastOccurrence:"+ last);

        System.out.println((last - first) + 1);
    }
}
