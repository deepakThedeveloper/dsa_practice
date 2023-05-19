package dynamicProgramming;

import matrix.Util;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        int[][] dp = Util.getMatrix(s1.length()+1, s2.length()+1, -1);
        int minOperations = minOperationsMemoizationRevision(s1, s1.length(), s2, s2.length(), dp);
        System.out.println("memoization:"+minOperations);

        int minOperations1 = minOperationTabulationRevision(s1, s2);
        System.out.println("tabulation:"+minOperations1);
    }

    private static int minOperationsMemoizationRevision(String s1, int i, String s2, int j, int[][] dp){
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
            int insert = minOperationsMemoizationRevision(s1, i, s2, j-1, dp);
            int delete = minOperationsMemoizationRevision(s1, i-1, s2, j-1, dp);
            int replace = minOperationsMemoizationRevision(s1, i-1, s2, j-1, dp);

            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
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

        for(int i=1; i<=i1; i++){
            for(int j=1; j<=i2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int insert = dp[i][j-1];
                    int delete = dp[i-1][j-1];
                    int replace = dp[i-1][j-1];

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[i1][i2];
    }
}
