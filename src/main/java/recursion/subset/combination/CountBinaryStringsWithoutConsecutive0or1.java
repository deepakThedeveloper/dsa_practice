package recursion.subset.combination;

public class CountBinaryStringsWithoutConsecutive0or1 {
    public static void main(String[] args) {
        int n=3;
        printTotalBinaryStringOfLengthNWithoutConsecutiveZero(n, "", 1);
        int sum = printCountOfBinaryStringOfLengthNWithoutConsecutiveZero(n,  1);
        System.out.println(sum);
    }

    private static void printTotalBinaryStringOfLengthNWithoutConsecutiveZero(int n, String op, int lastChar) {
        if(n==0){
            System.out.println(op);
            return;
        }
        printTotalBinaryStringOfLengthNWithoutConsecutiveZero(n-1, op+"1", 1);
        if(lastChar!=0)
        printTotalBinaryStringOfLengthNWithoutConsecutiveZero(n-1, op+"0", 0);
    }

    private static int printCountOfBinaryStringOfLengthNWithoutConsecutiveZero(int n, int v) {
        if(n==0){
            return 1;
        }
        int count1 = printCountOfBinaryStringOfLengthNWithoutConsecutiveZero(n-1, 1);
        int count2 = 0;
        if(v!=0) {
            count2 = printCountOfBinaryStringOfLengthNWithoutConsecutiveZero(n - 1, 0);
        }
        return count1 + count2;
    }
}
