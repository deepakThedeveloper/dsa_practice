package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 6;
        int val = printFibonacciSeries(n);
        int val1 = printFibonacciSeries1(n); // 3rd may 2023
        System.out.println(val);
        System.out.println(val1);
    }

    private static int printFibonacciSeries1(int n) {
        if(n==0 || n==1) return 0;
        if(n==2) return 1;

        return printFibonacciSeries1(n-1) + printFibonacciSeries1(n-2);
    }

    private static int printFibonacciSeries(int n) {
        if(n==0 || n==1) return 0;
        if(n==2) return 1;

        int prev = printFibonacciSeries(n-1);
        int sprev = printFibonacciSeries(n-2);
        //System.out.print(prev+sprev);
        return prev + sprev;
    }
}

//0,1,1,2,3,5,8,13