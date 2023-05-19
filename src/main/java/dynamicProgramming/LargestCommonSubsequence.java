package dynamicProgramming;

import matrix.Util;

import java.util.ArrayList;
import java.util.List;

public class LargestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "amcd";
        String s2 = "aced";

        int[][] dp = Util.getMatrix(s1.length(), s2.length(), -1);
        int lcsLength1  = getLCSMemoization(s1.toCharArray(), s2.toCharArray(), s1.length()-1, s2.length()-1, dp);
        System.out.println("memoization:"+lcsLength1);

        int lcsLength2  = getLCSTabulation(s1.toCharArray(), s2.toCharArray());
        System.out.println("tabulation:"+lcsLength2);

        int[][] dp1 = Util.getMatrix(s1.length(), s2.length(), -1);
        int lcs1 = lcsMemoizationRevision(s1, s1.length() - 1, s2, s2.length() - 1, dp1);
        System.out.println("memoization revision:"+lcs1);

        int lcs2 = lcsTabulationRevision(s1, s2);
        System.out.println("tabulation revision:"+lcs2);
    }

    private static int lcsMemoizationRevision(String s1, int i1, String s2, int i2, int[][] dp) {
        if (i1 < 0 || i2 < 0) return 0;

        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if (s1.charAt(i1) == s2.charAt(i2)) {
            return dp[i1][i2] = 1 + lcsMemoizationRevision(s1, i1 - 1, s2, i2 - 1, dp);
        }
        return dp[i1][i2] = Math.max(lcsMemoizationRevision(s1, i1 - 1, s2, i2, dp),
                lcsMemoizationRevision(s1, i1, s2, i2 - 1, dp));
    }

    private static int lcsTabulationRevision(String s1, String s2){
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

        printCommonSubsequence(s1, s2, dp);
        return dp[i1][i2];
    }

    private static void printCommonSubsequence(String s1, String s2, int[][] dp){
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


    //adebc, dcadb
    private static int getLCSTabulation(char[] c1, char[] c2){
        int ind1 = c1.length;
        int ind2 = c2.length;

        int val = 1;
        String op = "";
        int[][] dp = new int[ind1+1][ind2+1];
        for(int i=0, i1=1; i<ind1; i++, i1++){
            for(int j=0, j1=1; j<ind2; j++, j1++){
                if(c1[i] == c2[j]){
                    dp[i1][j1] = 1 + dp[i1-1][j1-1];
                }
                else {
                    int l1 = dp[i1 - 1][j1];
                    int l2 = dp[i1][j1 - 1];
                    dp[i1][j1] = Math.max(l1 , l2);
                }
                if(dp[i1][j1] == val){
                    op = op+c2[j];
                    val++;
                }
            }
        }
        for(int i=0; i<=ind1; i++){
            for(int j=0; j<=ind2; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(op);
        return dp[ind1][ind2];
    }


    private static int getLCSMemoization(char[] c1, char[] c2, int ind1, int ind2, int[][] dp){
        if(ind1 <0 || ind2 < 0){
            return 0;
        }
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(c1[ind1] == c2[ind2]){
            return dp[ind1][ind2] = 1 + getLCSMemoization(c1, c2, ind1-1, ind2-1, dp);
        }

        int l1 = getLCSMemoization(c1, c2, ind1-1, ind2, dp);
        int l2 = getLCSMemoization(c1, c2, ind1, ind2-1, dp);

        return dp[ind1][ind2] = Math.max(l1 , l2);
    }
}
