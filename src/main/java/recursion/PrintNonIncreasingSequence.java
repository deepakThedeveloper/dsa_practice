package recursion;

public class PrintNonIncreasingSequence {
    public static void main(String[] args) {
        int x = 3;
        printSequence(x, "");
    }

    private static void printSequence(int x, String op) {
        if(op.length()>1){
            int n = op.length();
            int l1 = op.charAt(n-1) -'0';
            int l2 = op.charAt(n-2) -'0';
            if(l1>l2) return;
        }
        if(x==0){
            System.out.println(op);
            return;
        }

        for(int i=1; i<=x; i++){
            printSequence(x-i, op + i);
        }
    }
}
