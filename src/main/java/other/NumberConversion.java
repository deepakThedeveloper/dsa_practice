package other;

public class NumberConversion {
    public static void main(String[] args) {
        int n = 573;
        String binary = decimalToBinary(n);
        System.out.println("decimal:" +n);
        System.out.println("binary:"+binary);

        int decimal = binaryToDecimal(binary);
        System.out.println("binary:"+binary);
        System.out.println("decimal:" +n);
    }

    // For binary to decimal, divide the binary number by 10 as the base for decimal is 10. Do the division till quotient is 0.
    // All the remainders those are obtained during computation multiply them with 2^0,1...... and then sum them up.
    private static int binaryToDecimal(String binary) {
        Long divi = Long.parseLong(binary);
        Long div = 10l, quo = Long.MAX_VALUE, rem;

        int count = 0;
        int sum = 0;
        while(quo!=0){
            rem = divi % div;
            quo = divi / div;
            divi = quo;
            sum += rem * 2 ^ count;
        }
        return sum;
    }

    // for decimal to binary divide the decimal with 2 till quo is 0. Print all remainders that occurred in every division.
    // Those are binary.
    private static String decimalToBinary(int n) {
        int divi = n, div = 2, quo = Integer.MAX_VALUE, rem;
        String list = "";
        while(quo!=0){
            rem = divi % div;
            quo = divi / div;
            list += rem;
            divi = quo;
        }
        return list;
    }
}
