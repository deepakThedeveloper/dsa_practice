package recursion;

/**
 * Given two sorted arrays A and B, generate all possible arrays such that first element is taken from A then from B
 * then from A and so on in increasing order till the arrays exhausted. The generated arrays should end with an element from B.
 * A = {10, 15, 25}
 * B = {1, 5, 20, 30}
 *
 * The resulting arrays are:
 *   10 20
 *   10 20 25 30
 *   10 30
 *   15 20
 *   15 20 25 30
 *   15 30
 *   25 30
 */
public class PrintAllSortedArrays {
    public static void main(String[] args) {
        int[] a = {10, 15, 25};
        int[] b = {1, 5, 20, 30};

        for(int k=0; k<a.length;k++) {
            printSortedArraysCombination(a, b, ""+a[k], "a", 0, 0);
        }
    }

    private static void printSortedArraysCombination(int[] a, int[] b, String op, String op1, int i, int j) {
        if(op1.equalsIgnoreCase("b")){
            System.out.println(op);
            //return;
        }
        if(i==a.length || j== b.length){
            return;
        }
        if (op1.equalsIgnoreCase("a")) {
            for (; j < b.length; ) {
                if (a[i] > b[j]) j++;
                else break;
            }
            if (j <= b.length - 1)
                printSortedArraysCombination(a, b, op + "," + b[j], "b", i + 1, j);
                printSortedArraysCombination(a, b, op, "a", i + 1, j);
        }
        if (op1.equalsIgnoreCase("b")) {
            for (; i < a.length; ) {
                if (a[i] < b[j]) i++;
                else break;
            }
            if (i <= a.length - 1)
                printSortedArraysCombination(a, b, op + "," + a[i], "a", i, j + 1);
            //printSortedArraysCombination(a, b, op,"b", i, j+1);
        }
    }
}
