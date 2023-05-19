package recursion;

public class NonnegativeSumCombinations {
    public static void main(String[] args) {
        int n = 5;
        int k = 4;

        //printCombinations(n, k, "", 0);
        int count = printCombinationsSum(n, k, "", 0);
        System.out.println(count);
    }

    private static void printCombinations(int n, int k, String op, int sum) {
        if(op.length() == n && sum == k){
            System.out.println(op);
            return;
        }
        if(op.length() == n){
            return;
        }
        for(int i=0; i<=k; i++){
            printCombinations(n, k, op+i, sum+i);
        }
    }

    private static int printCombinationsSum(int n, int k, String op, int sum) {
        if(op.length() == n && sum == k){
            //System.out.println(op);
            return 1;
        }
        if(op.length() == n){
            return 0;
        }
        int sum1 = 0;
        for(int i=0; i<=k; i++){
            sum1 += printCombinationsSum(n, k, op+i, sum+i);
        }

        return sum1;
    }
}
