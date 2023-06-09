package dynamicProgramming.lcs;

import matrix.Util;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s1 = "bbabb";

        int[][] dp = Util.getMatrix(s1.length(), s1.length(), -1);
        int count1 = getPalindromicSubsequenceBetterApproachMemo(s1.toCharArray(), 0, s1.length()-1, dp);
        System.out.println("lpsMemoization:"+count1);

        int count2 = getPalindromicSubsequenceBetterApproachTabu(s1);
        System.out.println("lpsTabulation:"+count2);

        int count3 = lpsApproach2(s1);
        System.out.println("lpsAppraoch2:"+count3);
    }

    // refer: /resources/longest_palindromic_subsequence.jpg
    private static int lpsApproach2(String str){
        int n = str.length();
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            for(int r=0, c=i; c<n; r++, c++){
                if(i==0) dp[r][c] = 1;
                else {
                    boolean firstLastCharMatch = str.charAt(r) == str.charAt(c);
                    if(i==1) dp[r][c] = firstLastCharMatch ? 2 : 1;
                    else{
                        int v;
                        if(firstLastCharMatch){
                            v = 2+dp[r+1][c-1];
                        }
                        else{
                            v = Math.max(dp[r][c-1],dp[r+1][c]);
                        }
                        dp[r][c] =  v;
                    }
                }
            }
        }
        return dp[0][n-1];
    }

    private static int getPalindromicSubsequenceBetterApproachMemo(char[] c1, int i, int j, int[][] dp){
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(c1[i] == c1[j]){
            return dp[i][j] =  2 + getPalindromicSubsequenceBetterApproachMemo(c1, i+1, j-1, dp);
        }

        int l1 = getPalindromicSubsequenceBetterApproachMemo(c1, i+1, j, dp);
        int l2 = getPalindromicSubsequenceBetterApproachMemo(c1, i, j-1, dp);

        return dp[i][j] = Math.max(l1, l2);
    }

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

    private static int getPalindromicSubsequenceBetterApproachTabu(String s1){
        String s2 = new StringBuilder(s1).reverse().toString();
        return getLCSTabulation(s1.toCharArray(), s2.toCharArray());
    }
}
