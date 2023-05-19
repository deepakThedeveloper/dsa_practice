package dynamicProgramming;

import matrix.Util;

public class LargestPalindromicSubsequence {
    public static void main(String[] args) {
        String s1 = "bbabcbcab";
        String s2 = reverse(s1);
        int[][] dp1 = Util.getMatrix(s1.length(), s2.length(), -1);
        int lcs1 = lpsMemoizationRevision(s1, s1.length() - 1, s2, s2.length() - 1, dp1);
        System.out.println("memoization revision:"+lcs1);

        int lcs2 = lpsTabulationRevision(s1, s2);
        System.out.println("tabulation revision:"+lcs2);
    }

    private static String reverse(String s1){
        StringBuilder builder = new StringBuilder();
        for(int i=s1.length()-1; i>=0; i--){
            builder.append(s1.charAt(i));
        }
        return builder.toString();
    }

    private static int lpsMemoizationRevision(String s1, int i1, String s2, int i2, int[][] dp) {
        if (i1 < 0 || i2 < 0) return 0;

        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if (s1.charAt(i1) == s2.charAt(i2)) {
            return dp[i1][i2] = 1 + lpsMemoizationRevision(s1, i1 - 1, s2, i2 - 1, dp);
        }
        return dp[i1][i2] = Math.max(lpsMemoizationRevision(s1, i1 - 1, s2, i2, dp),
                lpsMemoizationRevision(s1, i1, s2, i2 - 1, dp));
    }

    private static int lpsTabulationRevision(String s1, String s2){
        int i1 = s1.length();
        int i2 = s2.length();

        int[][] dp = Util.getMatrix(i1+1, i2+1, 0);

        for(int i=1; i<=i1; i++){
            for(int j=1; j<=i2; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        Util.printMatrix(dp);

        printPalindromicSubsequence(s1, s2, dp);
        return dp[i1][i2];
    }

    // incorrect string print. will fix this
    private static void printPalindromicSubsequence(String s1, String s2, int[][] dp){
        int prev = 0;
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(dp[i][j]>prev){
                    builder.append(s1.charAt(i-1));
                    prev = dp[i][j];
                }
            }
        }
        System.out.println("Common Subsequence:"+builder.toString());
    }
}
