package recursion;

public class BinariesWithoutConecutive1s {
    public static void main(String[] args) {
        int n = 4;
        printBinariesWithout1s(n,"");
    }

    private static void printBinariesWithout1s(int n, String op) {
        if(n==0){
            System.out.println(op);
            return;
        }

        if(op.length()==0){
            printBinariesWithout1s(n-1, op+"1");
        }
        if(op.length()>0&&(op.charAt(op.length()-1)-'0') != 1)
        printBinariesWithout1s(n-1, op+"1");
        printBinariesWithout1s(n-1, op+"0");
    }
}
