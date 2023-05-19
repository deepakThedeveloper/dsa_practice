package dynamicProgramming;

//0,2,5,8,1+2+
public class NLengthBinaryStrings {
    public static void main(String[] args) {
        int n=5;
       // printTotalBinaryStringOfLengthNWithoutConsecutiveZero(n, "", 1);
//        int sum = printCountOfBinaryStringOfLengthNWithoutConsecutiveZero(n,  1);
//        System.out.println(sum);
        int sum = printCountOfBinaryStringOfLengthNWithoutConsecutiveZeroDP(n);
        System.out.println(sum);
    }

    // using string[] and storing string inside array is just for informative purpose to understand how tabulation is implemented.
    // short trick is to use int[][] and store count in array. Then using tabulation zeroth row will have value of dp[row+1][col-1]
    // and oneth row will have dp[row][col-1]+dp[row-1][col-1] value;
    // final answer will also be dp[0][n-1]+dp[1][n-1]
    private static int printCountOfBinaryStringOfLengthNWithoutConsecutiveZeroDP(int n) {
        String[][] dp = new String[2][n];

        dp[0][0] = "0,";
        dp[1][0] = "1,";

        for(int col=1; col<n; col++){
            for(int row=0; row<2; row++){
                if(row==0) {
                    String val =  dp[row + 1][col-1];
                    String[] arr = val.split(",");
                    String zeroEndingStrings="";
                    for(String s : arr){
                        zeroEndingStrings = s+"0,"+zeroEndingStrings;
                    }
                    dp[row][col] = zeroEndingStrings;
                }
                else{
                    String val =  dp[row-1][col-1]+dp[row][col-1];
                    String[] arr = val.split(",");
                    String zeroEndingStrings="";
                    for(String s : arr){
                        zeroEndingStrings = s+"1,"+zeroEndingStrings;
                    }
                    dp[row][col] = zeroEndingStrings;
                }
            }
        }
        for(int row = 0; row<2; row++){
            for(int col = 0; col<n; col++){
                System.out.print(dp[row][col]+"||");
            }
            System.out.println();
        }
        String zeroString = dp[0][n-1];
        String oneString = dp[1][n-1];
        return zeroString.split(",").length+oneString.split(",").length;
    }

    private static void printTotalBinaryStringOfLengthNWithoutConsecutiveZero(int n, String op, int v) {
        if(n==0){
            System.out.println(op);
            return;
        }
        printTotalBinaryStringOfLengthNWithoutConsecutiveZero(n-1, op+"1", 1);
        if(v!=0)
        printTotalBinaryStringOfLengthNWithoutConsecutiveZero(n-1, op+"0", 0);
    }

    private static int printCountOfBinaryStringOfLengthNWithoutConsecutiveZero(int n, int v) {
        if(n==0){
            return 1;
        }
        int sum=0;
        int count1 = printCountOfBinaryStringOfLengthNWithoutConsecutiveZero(n-1, 1);
        sum +=count1;
        if(v!=0) {
            int count2 = printCountOfBinaryStringOfLengthNWithoutConsecutiveZero(n - 1, 0);
            sum+=count2;
        }
        return sum;
    }
}
