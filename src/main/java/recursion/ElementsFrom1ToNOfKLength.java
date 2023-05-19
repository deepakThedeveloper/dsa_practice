package recursion;

/*
Given two positive integers n and k,
 print all increasing sequences of length k such that the elements in every sequence are from first n natural numbers.
 Input: k = 2, n = 3
Output: 1 2
        1 3
        2 3
*/
public class ElementsFrom1ToNOfKLength {
    public static void main(String[] args) {
        int n = 5   ;
        int k = 3;

        printNElementsCombinations(k, n,"", 0);
    }

    private static void printNElementsCombinations(int k, int n, String op, int i) {
        if(op.length()==k){
            System.out.println(op);
            return;
        }
        if(i==n)return;

        printNElementsCombinations(k, n, op+(i+1), i+1);
        printNElementsCombinations(k, n, op, i+1);
    }
}
