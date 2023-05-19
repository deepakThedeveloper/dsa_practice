package recursion;

public class MinEdits {
    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";

        //int moves = getMinEditToConvertS1ToS2(s1, s2, s1.length(), s2.length());
        int[][] dp = new int[s1.length()][s2.length()];
        int moves = getMinEditToConvertS1ToS2Memoization(s1, s2, s1.length(), s2.length(), dp);
        System.out.println(moves);
    }

    private static int getMinEditToConvertS1ToS2(String s1, String s2, int m, int n) {
        if(m==0){
            return n;
        }
        if(n==0) {
            return m;
        }

        System.out.println("hello:m: "+m+" n:"+n);
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return getMinEditToConvertS1ToS2(s1, s2, m-1, n-1);
        }
        else{
            int v1 = 1+getMinEditToConvertS1ToS2(s1, s2, m, n-1); //insert
            int v2 = 1+getMinEditToConvertS1ToS2(s1, s2, m-1, n-1); // replace
            int v3 = 1+getMinEditToConvertS1ToS2(s1, s2, m-1, n);// remove

            return Math.min(v1, Math.min(v2, v3));
        }
    }

    private static int getMinEditToConvertS1ToS2Memoization(String s1, String s2, int m, int n, int[][] dp) {
        if(m==0){
            return n;
        }
        if(n==0) {
            return m;
        }

        if(dp[m-1][n-1] !=0){
            return dp[m-1][n-1];
        }
        System.out.println("hello:m: "+m+" n:"+n);
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            dp[m-1][n-1] = getMinEditToConvertS1ToS2Memoization(s1, s2, m-1, n-1, dp);
            return dp[m-1][n-1];
        }
        else{
            int v1 = 1+getMinEditToConvertS1ToS2Memoization(s1, s2, m, n-1, dp); //insert
            int v2 = 1+getMinEditToConvertS1ToS2Memoization(s1, s2, m-1, n-1, dp); // replace
            int v3 = 1+getMinEditToConvertS1ToS2Memoization(s1, s2, m-1, n, dp);// remove

            dp[m-1][n-1] = Math.min(v1, Math.min(v2, v3));
            return dp[m-1][n-1];
        }
    }

    private static String remove(String s, int pos) {
        String right = s.substring(pos+1);
        String left = s.substring(0, pos);

        String s1 = left+right;
        return s1;
    }

    private static String replace(String s, int pos, char c) {
        String right = s.substring(pos+1);
        String left = s.substring(0, pos);

        String s1 = left + c + right;
        return s1;
    }

    private static String insert(String s, int pos, char c){
        String right = s.substring(pos);
        String left = s.substring(0, pos);

        String s1 = left + c + right;
        return s1;
    }
}
