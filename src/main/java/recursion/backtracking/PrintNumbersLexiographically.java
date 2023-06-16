package recursion.backtracking;

public class PrintNumbersLexiographically {
    public static void main(String[] args) {
        int n = 1000;

        /*System.out.println("-------------------------");
        printLexiographically(n, 1);
        System.out.println("-------------------------");*/

        for(int i=1; i<=9; i++) {
            printLexiographicallyApproach2(i, n);
        }
    }

    private static void printLexiographicallyApproach2(int i, int n) {
        if(i>n) return;

        System.out.print(i+" ");
        for(int j=0; j<10; j++) {
            printLexiographicallyApproach2(10*i+j, n);
        }
    }

    private static void printLexiographically(int n, int start) {
        if(start > n){
            return;
        }
        System.out.print(start+" "); /// left leg of node
        printLexiographically(n, start*10);
        int val = (start+1)%10;
        if(val>=1)
            printLexiographically(n, start+1);
    }
}
