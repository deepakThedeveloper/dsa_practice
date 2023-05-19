package recursion;

/**
 * Given a number n, find all binary sequences of length 2n such that sum of first n bits is same as sum of last n bits.
 * e.g: n=2 o/p: 0101 1111 1001 0110 0000 1010
 */
public class EvenLengthBinarySequence {
    public static void main(String[] args) {
        int n = 3;
        printEvenLengthBinarySequence(2*n,"", 0, 0);
    }

    private static void printEvenLengthBinarySequence(int n, String op, int sum1, int sum2) {
        if(op.length()>0) {
            int v = op.charAt(op.length() - 1) - '0';
            if (op.length() <= n / 2) {
                sum1 += v;
            } else {
                sum2 += v;
            }
        }
        if(op.length() == n){
            if(sum1 == sum2) {
                System.out.println(op);
            }
            return;
        }

        printEvenLengthBinarySequence(n, op+"1", sum1, sum2);
        printEvenLengthBinarySequence(n, op+"0", sum1, sum2);
    }
}
