package recursion;

public class PrintSubsequence {
    public static void main(String[] args) {
        printSubsequence("abc", "", 3);
    }

    private static void printSubsequence(String str, String op, int n) {
        if(str.length() == 0){
            System.out.println(op);
            return;
        }
        char c = str.charAt(0);
        printSubsequence(str.substring(1, n), op+c, n-1);
        printSubsequence(str.substring(1, n), op+"", n-1);

    }
}
