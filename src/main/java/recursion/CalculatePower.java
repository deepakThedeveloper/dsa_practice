package recursion;

public class CalculatePower {
    public static void main(String[] args) {
        //int val = power(2,7);
        int val = powerLogarithmic(2,8);
        System.out.println(val);
    }

    private static int powerLogarithmic(int x, int y) {
        if(y==1) return x;

        int v = powerLogarithmic(x, y/2);
        int result = v*v;
        if(y%2 != 0){
            result = result * x;
        }
        return result;
    }

    // Expectation: need to multiply x y times, i.e x*x*x*.....*y;
    // Faith: my function multiples x(y-1) times. i.e. x*x*x*.....*y-1;
    // EF: multiply x*power(x,y-1)
    private static int power(int x, int y) {
        if(y==1) return x;
        return x*power(x, y-1);
    }
}
