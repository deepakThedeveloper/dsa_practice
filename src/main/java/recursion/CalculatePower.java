package recursion;

public class CalculatePower {
    public static void main(String[] args) {
        //int val = power(2,7);
        double val = pow(2.0000,10);
        System.out.println(val);

        double val1 = pow(2.1000,3);
        System.out.println(val1);

        double val2 = pow(2.000, -2);
        System.out.println(val2);
    }

    private static double pow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }
}
