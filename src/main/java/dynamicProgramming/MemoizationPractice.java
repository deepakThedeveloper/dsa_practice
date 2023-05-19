package dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MemoizationPractice {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] a1 = {1,2,3,4};

        //getSum(a1, 0, 0, "");
        //getSumMemoization(a, 0, 0, "", new HashMap<>());
        //getSumWithoutMemoization(a, 0, 0, "");
//        int[] dp = new int[a.length];
//        for(int i=0; i<a.length; i++){
//            dp[i] = -1;
//        }
        //getSumWithMemoization(a, 0, 0, "", dp);

        int val = 3;
        System.out.println("===============================");
        int[] dp = new int[val];
        IntStream.range(0, val).forEach(i->dp[i]=-1);
//        fib(val);
//        int op = fib1(val, dp); //0,1,1,2,3,5
        //int op = practice(val, dp, 0, 0);
        //int op = practice1(val, dp, "", 0);
        int op = practice2(val, dp, "", 0);
        Arrays.stream(dp).forEach(v-> System.out.print(v+","));
       // System.out.println(op);
    }


    private static int practice(int n, int[] dp, int i, int sum){
        if(i==n) return sum;

        if(dp[i]!=-1){
            System.out.println("in if");
            return dp[i];
        }
        System.out.println("hello:"+i);

        dp[i] =  practice(n, dp, i+1, sum+i);
        return dp[i];
    }
    private static int practice1(int n, int[] dp, String op, int sum){
        if(n==0) {
            System.out.println(op+"-->"+sum);
            return sum;
        }

        //System.out.println("hello:"+n);

        int temp =  practice1(n-1, dp, op+n, sum+n) - n ;
        int temp1 =  practice1(n-1, dp, op, sum) - n ;
        dp[n] = (temp + temp1);
        return dp[n];
    }
    private static int practice2(int n, int[] dp, String op, int i){
        if(i==n) {
            if(op.length() == i){
                return i-1;
            }
            return 0;
        }

        int temp =  practice2(n, dp, op+i, i+1) ;
        int temp1 =  practice2(n, dp, op, i+1);
        dp[i] = (temp + temp1);
        return dp[i];
    }
    private static void getSum(int[] a, int idx, int sum, String op) {
        if(idx == a.length){
            System.out.println(op+"-->"+sum);
            return;
        }
        for(int i=idx; i<a.length; i++){
            getSum(a, i+1, sum+a[i], op+a[i]);
        }
    }

    private static int getSumMemoization(int[] a, int idx, int sum, String op, Map<Integer, Integer> map) {
        if(idx == a.length){
            System.out.println(op+"-->"+sum);
            return sum;
        }
        for(int i=idx; i<a.length; i++){
            int sum1 = getSumMemoization(a, i+1, sum+a[i], op+a[i], map);

        }
        return 0;
    }

    private static void getSumWithoutMemoization(int[] a, int i, int sum, String op) {
        if(i == a.length){
            //System.out.println(op+"-->"+sum);
            return;
        }
        System.out.println("hello:"+i);
        getSumWithoutMemoization(a, i+1, sum+a[i], op+a[i]);
        getSumWithoutMemoization(a, i+1, sum, op);
    }

    private static int getSumWithMemoization(int[] a, int i, int sum, String op, int[] dp) {
        if(i == a.length){
            System.out.println("in if");
            System.out.println(op+"-->"+sum);
            return sum;
        }
        if(dp[i]!=-1){
            System.out.println(op+"-->"+dp[i]);
            return dp[i];
        }

        //System.out.println("hello:"+i);
        int v1 = getSumWithMemoization(a, i+1, sum+a[i], op+a[i], dp);
        int v2 = getSumWithMemoization(a, i+1, sum, op, dp);

        int total = v1+v2;
        dp[i] = total;
        return dp[i];
    }

    private static int fib(int n){
        if(n==0 || n==1) return n;

        System.out.println("hello:"+n);
        return fib(n-1) + fib(n-2);
    }

    private static int fib1(int n, int[] dp){
        if(n==0 || n==1) return n;

        if(dp[n]!=-1){
            return dp[n];
        }
        System.out.println("hello:"+n);

        dp[n] =  fib1(n-1, dp) + fib1(n-2, dp);
        return dp[n];
    }

}
