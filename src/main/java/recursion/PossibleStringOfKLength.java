package recursion;

public class PossibleStringOfKLength {
    public static void main(String[] args) {
//        char[] set = {'a','b'};
//        int length = 3;
        char[] set = {'a','b','c'};
        int length = 1;
        printStrings(set, length, "");
    }

    private static void printStrings(char[] set, int n, String op) {
        if(op.length() == n){
            System.out.println(op);
            return;
        }
        for(int i=0; i<set.length; i++){
            printStrings(set,n, op+set[i]);
        }
    }
}
