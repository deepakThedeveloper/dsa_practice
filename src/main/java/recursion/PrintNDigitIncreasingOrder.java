package recursion;

//todo
public class PrintNDigitIncreasingOrder {
    public static void main(String[] args) {
        int n = 2;
        String op = getValues(n);
        printDigitsInIncreasingOrder(n, op, op.length()-1);
    }

    private static void printDigitsInIncreasingOrder(int n, String op, int pos) {

        System.out.println(op);
        char c = op.charAt(pos);
        int i =  (c - '0')+1;
        for(; i<9; i++){
            printDigitsInIncreasingOrder(n, op.replace(c, (char)(i+'0')), pos);
        }
    }

    private static String getValues(int n){
        String op = "";
        int i=0;
        while(op.length()<n){
            op+=i;
            i++;
        }

        return op;
    }
}
