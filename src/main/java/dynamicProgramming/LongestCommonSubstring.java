package dynamicProgramming;

import matrix.Util;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcjklpmnpqrstu";
        String s2 = "acjklppqrstuv";

        int count = getLCSTabulation(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
        System.out.println(count);

        int lcSubstring2 = lcsViaTabulationRevision(s1, s2);
        System.out.println("tabulation:"+lcSubstring2);
    }

    private static int getLCSTabulation(char[] c1, char[] c2, int n, int m){
        int[][] dp = new int[n+1][m+1];

        int count = 0;
        for(int i=0, i1=1; i<n; i++, i1++){
            for(int j=0, j1=1; j<m; j++, j1++){
                if(c1[i] == c2[j]){
                    dp[i1][j1] = 1 + dp[i1-1][j1-1];
                    count = Math.max(dp[i1][j1],count);
                }
            }
        }

        return count;
    }

    // Approach 2: Code looks neat and clean but comes with additional space
    private static int lcsViaTabulationRevision(String s1, String s2){
        int i1 = s1.length();
        int i2 = s2.length();

        int[][] dp = Util.getMatrix(i1+1, i2+1, 0);
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=i1; i++){
            for(int j=1; j<=i2; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        Util.printMatrix(dp);
        return max;
    }
}
