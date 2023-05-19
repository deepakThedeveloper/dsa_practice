package dynamicProgramming;

import matrix.Util;

public class DistinctSubsequence {
    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";

        int[][] dp = Util.getMatrix(s1.length(), s2.length(), -1);
        int distinctSubsequence = distinctSubsequenceCountMemoizationRevision(s1, s1.length()-1, s2, s2.length()-1,dp);
        System.out.println("memoization revision:"+distinctSubsequence);

        int distinctSubsequence1 = distinctSSCountTabulationRevision(s1, s2);
        System.out.println("tabulation revision:"+distinctSubsequence1);
    }

    private static int distinctSubsequenceCountMemoizationRevision(String s1, int i, String s2, int j, int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = distinctSubsequenceCountMemoizationRevision(s1, i-1, s2, j-1, dp) +
                    distinctSubsequenceCountMemoizationRevision(s1, i-1, s2, j, dp);
        }
        else{
            return dp[i][j] = distinctSubsequenceCountMemoizationRevision(s1, i-1, s2, j, dp);
        }
    }

    private static int distinctSSCountTabulationRevision(String s1, String s2){
        int i1 = s1.length();
        int i2 = s2.length();

        int[][] dp = Util.getMatrix(i1+1, i2+1, 0);
        for(int row = 0; row<=i1; row++){
            dp[row][0] = 1;
        }

        for(int i=1; i<=i1; i++){
            for(int j=1; j<=i2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        Util.printMatrix(dp);
        return dp[i1][i2];
    }
}
