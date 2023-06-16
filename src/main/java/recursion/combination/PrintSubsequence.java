package recursion.combination;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequence {
    public static void main(String[] args) {
        printSubsequence("abc", "", 3);
        int[] a = {1,2,3};
        arraySubsequence(0, a.length, a, new ArrayList<>());
    }

    private static void printSubsequence(String str, String op, int n) {
        if(str.length() == 0){
            System.out.println(op);
            return;
        }
        char c = str.charAt(0);
        printSubsequence(str.substring(1, n), op+c, n-1);
        printSubsequence(str.substring(1, n), op+"", n-1);

    }

    private static void arraySubsequence(int idx, int n, int[] a, List<Integer> op){
        if(idx == n){
            System.out.println(op);return;
        }

        op.add(a[idx]);
        arraySubsequence(idx+1, n, a, op);
        op.remove(op.size()-1);

        arraySubsequence(idx+1, n, a, op);
    }
}
