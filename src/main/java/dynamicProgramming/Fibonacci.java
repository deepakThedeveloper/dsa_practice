package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    static final Map<Integer, Integer> mp = new HashMap<>();
    public static void main(String[] args) {
        mp.put(0,0);
        mp.put(1,1);
        //int fib = getFibonacci(10);
        int n = 10;
        int fib = getFibonacciMemoized(n, new int[n+1]);
        System.out.println(fib);
    }

    private static int getFibonacci(int n) {
        if(mp.containsKey(n)){
            return mp.get(n);
        }
        System.out.println("hello");
        int fib1 = getFibonacci(n-1);
        mp.put(n-1, fib1);
        int fib2 = getFibonacci(n-2);
        return fib1+fib2;
    }

    private static int getFibonacciMemoized(int n, int[] qb) {
        if(n==0 || n==1){
            return n;
        }
        if(qb[n]!=0){
            return qb[n];
        }
        System.out.println("hello");
        int fib1 = getFibonacci(n-1);
        int fib2 = getFibonacci(n-2);
        int fib =  fib1+fib2;
        qb[n] = fib;

        return fib;
    }
}
