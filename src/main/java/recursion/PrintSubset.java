package recursion;

import java.util.HashMap;
import java.util.Map;

public class PrintSubset {
    public static void main(String[] args) {
        //int[] a = {10,20,30,40,50,60};
       // int k = 60;
        int[] a = {4,2,7,1,3};
        int k = 10;
        printSubset(a, 0, 0, "", k);
        //printSubsetDP(a, 0, 0, "", k);
    }

    private static void printSubset(int[] a, int i, int sum, String op, int k) {
        if(sum == k){
            System.out.println(op);
            return;
        }
        if(sum > k || i == a.length){
            return;
        }

        printSubset(a, i+1, sum+a[i], op+a[i], k);
        printSubset(a, i+1, sum, op, k);
    }

    //todo
    static  Map<Integer, Integer> map = new HashMap<>();
    private static int printSubsetDP(int[] a, int i, int sum, String op, int k) {
        if(sum == k){
            System.out.println(op);
            return sum;
        }
        if(sum > k || i == a.length){
            return sum;
        }

        int includedSum = printSubsetDP(a, i+1, sum+a[i], op+a[i], k);
        map.put(a[i], includedSum-a[i]);
        int excludedSum = printSubsetDP(a, i+1, sum, op, k);

        return sum;
    }
}
