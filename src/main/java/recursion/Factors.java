package recursion;

public class Factors {
    public static void main(String[] args) {
        int n=16;
        printAllFactors(n, "", 2, n);
    }

    private static void printAllFactors(int n, String op, int divisor, int k) {
        if(n==1){
            System.out.println(op);
            return;
        }
        if(n<divisor){
            return;
        }

        for(int i=divisor; i<=n; i++){
            if(i>k/2) break;
            int quo = n/i;
            int rem = n%i;

            if(rem==0){
                printAllFactors(quo, op+i, i, k);
            }
        }
    }
}
