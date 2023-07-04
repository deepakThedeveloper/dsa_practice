package dynamicProgramming.threeDimension_DP;

public class InterleavingString {
     public static void main(String[] args){
         String s1 = "aabcc";
         String s2 = "dbbca";
         String s3 = "aadbbcbcac";

         int n = s1.length(), m = s2.length();

         int[][][] dp = new int[n+1][m+1][n+m+1];
         for(int i=0; i<=n; i++){
             for(int j=0; j<=m; j++){
                 for(int k=0; k<=n+m; k++){
                     dp[i][j][k] = -1;
                 }
             }
         }
         boolean match =  matchMemo(s1, s2, s3, 0, 0, dp);
        System.out.println(match);
     }

    //https://leetcode.com/problems/interleaving-string/submissions/983469976/
    private boolean match(String s1, String s2, String s3, int i, int j, Boolean[][] dp){
        if(i==s1.length() && j==s2.length()) return true;

        if(dp[i][j] != null) return dp[i][j];
        if(i<s1.length() && s1.charAt(i) == s3.charAt(i+j)){
            if(match(s1, s2, s3, i+1, j, dp)){
                return dp[i][j] = true;
            }
        }
        if(j<s2.length() && s2.charAt(j) == s3.charAt(i+j)){
            if(match(s1, s2, s3, i, j+1, dp)){
                return dp[i][j] = true;
            }
        }
        return dp[i][j] = false;
    }

     //leetcode https://leetcode.com/problems/interleaving-string/submissions/983468230/
     private static boolean matchMemo(String s1, String s2, String s3, int i, int j, int[][][] dp){
         if(i==s1.length() && j==s2.length()) return true;

         if(dp[i][j][i+j] != -1) return dp[i][j][i+j] == 1;
         if(i<s1.length() && s1.charAt(i) == s3.charAt(i+j)){
             if(matchMemo(s1, s2, s3, i+1, j, dp)){
                 dp[i][j][i+j] = 1;
                 return true;
             }
         }
         if(j<s2.length() && s2.charAt(j) == s3.charAt(i+j)){
             if(matchMemo(s1, s2, s3, i, j+1, dp)){
                 dp[i][j][i+j] = 1;
                 return true;
             }
         }
         dp[i][j][i+j] = 0;
         return false;
     }
}
