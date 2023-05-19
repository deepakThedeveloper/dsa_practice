package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
given an array[1,2,....,n]. k is given. k is kth permutation amongst all permutations.
 */
public class KthPermutation {
    public static void main(String[] args) {
        Integer[] a = {1,2,3,4};// as values are 4 so there will be n! is 4! = 24 permutations
        int k = 17;

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, a);
        String permutation = findPermutation(list, k-1, "", a.length);
        System.out.println(permutation);
    }

    private static String findPermutation(List<Integer> a, int k, String op, int n){
        if(a.size() == 1){
            op = op+a.get(0);
            return op;
        }
        int factorial = factorial(n-1);
        int pos = (k)/factorial;
        String op1 = op+a.get(pos);
        a.remove(pos);
        int next = (k)%factorial;

        return findPermutation(a, next, op1, a.size());
    }

    private static int factorial(int n){
        int fact = 1;
        while(n>=2){
            fact = fact * n;
            n--;
        }
        return fact;
    }
}
