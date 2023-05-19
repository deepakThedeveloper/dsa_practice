package recursion;

public class BinaryStringWithNoConsecutiveZero {
    public static void main(String[] args) {
        int n = 6;
        int count = binaryStringCombinations(n, "");
        System.out.println();
        System.out.println("combination:"+count);
    }

    private static int binaryStringCombinations(int n, String op){
        if(op.length() > 2 && op.endsWith("00")) return 0;

        if(n==0){
            System.out.print(op+", ");
            return 1;
        }

        return  binaryStringCombinations(n-1, op+"1") +
                binaryStringCombinations(n-1, op+"0");
    }
}
