package recursion;

public class Factorial {
    public static void main(String[] args) {
        int n = 4;
        int factorial = findFactorial(n);
        System.out.println("factorial of: "+n+" is:"+factorial);
    }

    public static int findFactorial(int n) {
        if(n==0 || n==1) return n;

        return findFactorial(n-1) * n;
    }
}
