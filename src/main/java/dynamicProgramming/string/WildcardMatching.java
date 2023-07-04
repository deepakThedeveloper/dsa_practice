package dynamicProgramming.string;

import matrix.Util;

public class WildcardMatching {
    public static void main(String[] args) {
        String s1 = "ab*def";
        String s2 = "abcdef";
        int[][] dp = Util.getMatrix(s1.length()+1, s2.length()+1, -1);
        int matchString = matchStringMemoizationRevision(s1, s1.length(), s2, s2.length(), dp);
        boolean finalVal = matchString == 1;
        System.out.println("memoization:"+finalVal);

        boolean matchString1 = matchStringTabulationRevision(s1, s2);
        System.out.println("tabulation:"+matchString1);

        boolean matchString2 = wildcardMatchingApproach2(s1, s2);
        System.out.println("approach2:"+matchString2);
    }

    /*
    1. 2D boolean matrix with n+1 length. s1 on x-axis and s2 on y-axis
    2. start filling from n,n till 0,0
    3. n,n will be true and n row and n column will be false
    4. if(s1[i] == s2[j] || s1[i] == '?') then look use value of right diagonal dp[i+1][j+1]
    5. if(s1[i] != s2[j]) put false
    6. if(s1[i] == '*') then look right and bottom and if anyone is true then ans is true. dp[i][j] = dp[i][j+1] || dp[i+1][j]
     */
    private static boolean wildcardMatchingApproach2(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[n-1][m-1] = true;
        for(int i=n-2; i>=0; i--){
            for(int j=n-2; j>=0; j--){
                if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?'){
                    dp[i][j] = dp[i+1][j+1];
                }
                else if(s1.charAt(i) == '*'){
                    dp[i][j] = dp[i+1][j] || dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }

    private static int matchStringMemoizationRevision(String s1, int i1, String s2, int i2, int[][] dp) {
        if(i1 == 0 && i2 == 0) return 1;
        if(i1==0 && i2 > 0) return 0;
        if(i2==0 && i1>0){
            for(int i=i1; i>0; i--){
                if(s1.charAt(i-1)!='*') return 0;
            }
            return 1;
        }
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if (s1.charAt(i1-1) == s2.charAt(i2-1) || s1.charAt(i1-1)=='?') {
            return dp[i1][i2] = matchStringMemoizationRevision(s1, i1 - 1, s2, i2 - 1, dp);
        }
        if(s1.charAt(i1-1) == '*'){
            return dp[i1][i2] = matchStringMemoizationRevision(s1, i1-1, s2, i2, dp) == 1
                    || matchStringMemoizationRevision(s1, i1, s2, i2-1, dp)==1 ? 1 : 0;
        }
        return dp[i1][i2] = 0;
    }

    //todo: notworking. incorrect output for String s1 = "bab*def"; String s2 = "abcdef";
    private static boolean matchStringTabulationRevision(String s1, String s2){
        int i1 = s1.length();
        int i2 = s2.length();

        int[][] dp = Util.getMatrix(i1+1, i2+1, 0);
        dp[0][0] = 1;
        for(int i=1; i<=i1; i++){
            int flag = 1;
            for(int j=1; j<=i; j++){
                if(s1.charAt(i-1)!='*') {
                    flag = 0;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        for(int i=1; i<=i1; i++){
            for(int j=1; j<=i2; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1)=='?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(s1.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j] == 1 || dp[i][j-1]==1 ? 1 : 0;
                }
                else dp[i][j] = 0;
            }
        }
        return dp[i1][i2] == 1;
    }
}
