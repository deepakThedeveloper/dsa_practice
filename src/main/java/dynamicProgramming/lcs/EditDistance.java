package dynamicProgramming.lcs;

import matrix.Util;

public class EditDistance {
    public static void main(String[] args) {
//        String s1 = "horse", s2 = "ros";
        String s1 = "ahellobye", s2 = "amezooe";

        int[][] dp = Util.getMatrix(s1.length()+1, s2.length()+1, -1);
        int minOperations = minOperationsMemoizationRevision(s1, s1.length(), s2, s2.length(), dp);
        System.out.println("memoization:"+minOperations);

        int minOperations1 = minOperationTabulationRevision(s1, s2);
        System.out.println("tabulation:"+minOperations1);

        int minOperations2 = minOperationTabulationDirect(s1, s2);
        System.out.println("tabulation direct:"+minOperations2);
    }

    // this is approach 1.
    // other approach :Approach 2 is to get LCS of both the strings.
    // s1.length > s2.length e.g. s1 = 8 and s2 = 4 and LCS is 3. then 5 operation is needed to be done on s1.
    // s1.length == s2.length and LCS = 2 then 2 operations are needed to be done on s1
    // s1.length < s2.length i.e. s1=4 and s2=8 and LCS = 3 the 5 operations are needed to be done on s1
    private static int minOperationTabulationDirect(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int r=1; r<=n; r++){
            for(int c=1; c<=m; c++){
                if(s1.charAt(r-1) == s2.charAt(c-1)) dp[r][c] = dp[r-1][c-1];
                else dp[r][c] = Math.min(dp[r][c-1], Math.min(dp[r-1][c-1], dp[r-1][c])) + 1;
            }
        }

        return dp[n][m];
    }

    private static int minOperationsMemoizationRevision(String s1, int i, String s2, int j, int[][] dp){
        if(i==0 && j==0) return 0;
        if(i==0){
            return j+1;
        }
        if(j==0){
            return i+1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j] = minOperationsMemoizationRevision(s1, i-1, s2, j-1, dp);
        }
        else{
            int insert = minOperationsMemoizationRevision(s1, i-1, s2, j-1, dp);
            int delete = minOperationsMemoizationRevision(s1, i-1, s2, j, dp);
            int replace = minOperationsMemoizationRevision(s1, i-1, s2, j-1, dp);

            return dp[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
        }
    }

    private static int minOperationTabulationRevision(String s1, String s2){
        int i1 = s1.length();
        int i2 = s2.length();

        int[][] dp = Util.getMatrix(i1+1, i2+1, 0);
        for(int j=0; j<=i2; j++){
            dp[0][j] = j+1;
        }
        for(int i=0; i<=i1; i++){
            dp[i][0] = i+1;
        }
        dp[0][0] = 0;
        for(int i=1; i<=i1; i++){
            for(int j=1; j<=i2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int insert = dp[i-1][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];

                    dp[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
                }
            }
        }
        Util.printMatrix(dp);
        return dp[i1][i2];
    }
}
