package dynamicProgramming.subset.combination;

import matrix.Util;

public class CountOf2ndStringIn1String {
    public static void main(String[] args){
        String s1 = "babgbag", s2 = "bag";
        int count = countOfSubsequence(s1, s2);

        System.out.println(count);
    }

    private static int countOfSubsequence(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=n; i++){
            dp[0][i] = 1;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if (s1.charAt(j - 1) == s2.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        Util.printMatrix(dp);
        return dp[m][n];
    }
}
