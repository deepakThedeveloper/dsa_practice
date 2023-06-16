package recursion.combination;

/*
Given an array of size n, generate and print all possible combinations of r elements in array.
 For example, if input array is {1, 2, 3, 4} and r is 2, then output should be {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4} and {3, 4}.
 */
public class CombinationsOfNElements {
    public static void main(String[] args) {
        int[] a={1,2,3,4,5};
        int n = 3;

        printNElementsCombinations(a,n,"", 0);
    }

    private static void printNElementsCombinations(int[] a, int n, String op, int i) {
        if(op.length()==n){
            System.out.println(op);
            return;
        }
        if(i==a.length  )return;

        printNElementsCombinations(a, n, op+a[i], i+1);
        printNElementsCombinations(a, n, op, i+1);
    }
}
