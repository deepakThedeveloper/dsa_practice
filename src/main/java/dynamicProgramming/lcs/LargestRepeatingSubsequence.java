package dynamicProgramming.lcs;

import matrix.Util;

public class LargestRepeatingSubsequence {
    public static void main(String[] args) {
        String s1 = "abcab";
        String s2 = "abcab";

        int[][] dp = Util.getMatrix(s1.length(), s2.length(), -1);
        int lcsLength1  = getLongestRepeatingMemoization(s1.toCharArray(), s2.toCharArray(), s1.length()-1, s2.length()-1, dp);
        System.out.println("memoization:"+lcsLength1);

        int lcsLength2  = getLongestRepeatingSubsequenceTabulation(s1.toCharArray(), s2.toCharArray());
        System.out.println("tabulation:"+lcsLength2);

        int[][] dp1 = Util.getMatrix(s1.length(), s2.length(), -1);
        int lcs1 = lrsMemoizationRevision(s1, s1.length() - 1, s2, s2.length() - 1, dp1);
        System.out.println("memoization revision:"+lcs1);

        int lcs2 = lrsTabulationRevision(s1, s2);
        System.out.println("tabulation revision:"+lcs2);

        int lcs3 = lrsApproach2(s1, s2);
        System.out.println("approach2 :"+lcs3);
    }

    //refer: /resources/longest_common_subsequence.jpg
    private static int lrsApproach2(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i=s1.length()-1; i>=0; i--){
            for(int j=s2.length()-1; j>=0; j--){
                if(s1.charAt(i) == s2.charAt(j) && i != j){
                    dp[i][j] = dp[i+1][j+1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }

    private static int lrsMemoizationRevision(String s1, int i1, String s2, int i2, int[][] dp) {
        if (i1 < 0 || i2 < 0) return 0;

        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if (s1.charAt(i1) == s2.charAt(i2) && i1 != i2) {
            return dp[i1][i2] = 1 + lrsMemoizationRevision(s1, i1 - 1, s2, i2 - 1, dp);
        }
        return dp[i1][i2] = Math.max(lrsMemoizationRevision(s1, i1 - 1, s2, i2, dp),
                lrsMemoizationRevision(s1, i1, s2, i2 - 1, dp));
    }

    private static int lrsTabulationRevision(String s1, String s2){
        int i1 = s1.length();
        int i2 = s2.length();

        int[][] dp = Util.getMatrix(i1+1, i2+1, 0);

        for(int i=1; i<=i1; i++){
            for(int j=1; j<=i2; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1) && i != j) {
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
    private static int getLongestRepeatingSubsequenceTabulation(char[] c1, char[] c2){
        int ind1 = c1.length;
        int ind2 = c2.length;

        int val = 1;
        String op = "";
        int[][] dp = new int[ind1+1][ind2+1];
        for(int i=0, i1=1; i<ind1; i++, i1++){
            for(int j=0, j1=1; j<ind2; j++, j1++){
                if(c1[i] == c2[j] && i1 != j1){
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


    private static int getLongestRepeatingMemoization(char[] c1, char[] c2, int ind1, int ind2, int[][] dp){
        if(ind1 <0 || ind2 < 0){
            return 0;
        }
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if(c1[ind1] == c2[ind2] && ind1 != ind2){
            return dp[ind1][ind2] = 1 + getLongestRepeatingMemoization(c1, c2, ind1-1, ind2-1, dp);
        }

        int l1 = getLongestRepeatingMemoization(c1, c2, ind1-1, ind2, dp);
        int l2 = getLongestRepeatingMemoization(c1, c2, ind1, ind2-1, dp);

        return dp[ind1][ind2] = Math.max(l1 , l2);
    }
}
