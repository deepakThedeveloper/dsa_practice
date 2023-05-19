package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s1 = "bbabb";

        int localMax = getSubsequence(s1.length()-1, s1.toCharArray(), "");
        System.out.println(localMax);


//        int count = getSubsequenceCount(s1.length()-1, s1.toCharArray(), "", dp);
//        System.out.println(count);
//        int length = getLongestSubsequence(s1.length()-1, s1.toCharArray(), "", dp);
//        System.out.println(length);

        int count = getPalindromicSubsequenceBetterApproach(s1.toCharArray(), 0, s1.length()-1);
        System.out.println(count);

        int[][] dp = new int[s1.length()][s1.length()];
        for(int i=0; i<s1.length(); i++){
            for(int i1=0; i1<s1.length(); i1++){
                dp[i][i1] = -1;
            }
        }
        int count1 = getPalindromicSubsequenceBetterApproachMemo(s1.toCharArray(), 0, s1.length()-1, dp);
        System.out.println(count1);

        int count2 = getPalindromicSubsequenceBetterApproachTabu(s1);
        System.out.println(count2);

    }

    private static int getPalindromicSubsequenceBetterApproach(char[] c1, int i, int j){
        if(i>j) return 0;
        if(i==j) return 1;
        if(c1[i] == c1[j]){
            return 2 + getPalindromicSubsequenceBetterApproach(c1, i+1, j-1);
        }

        int l1 = getPalindromicSubsequenceBetterApproach(c1, i+1, j);
        int l2 = getPalindromicSubsequenceBetterApproach(c1, i, j-1);

        return Math.max(l1, l2);
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
//        int n = c1.length;
//        int[][] dp = new int[n+1][n+1];
//        for(int i=0, j=0; i<=n; i++, j++){
//            dp[i][j] = 1;
//        }
//
//        int i1=n, j1 = 1;
//        for(int i=n-1; i>n/2; i--) {
//            for (int j = 0; j<n/2; j++) {
//                if (c1[i] == c1[j]) {
//                    dp[i1][j1] = 2 + dp[i + 1][j - 1];
//                } else {
//                    int l1 = dp[i + 1][j];
//                    int l2 = dp[i][j - 1];
//
//                    dp[i1][j1] = Math.max(l1, l2);
//                }
//            }
//        }
//        for(int i=0; i<=n; i++){
//            for(int j=0; j<=n; j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
//        return dp[n][n];
        String s2 = new StringBuilder(s1).reverse().toString();
        return getLCSTabulation(s1.toCharArray(), s2.toCharArray());
    }

    private static int getSubsequence(int n, char[] c1, String op){
        if(n<0){
            return isPalindrome(op) ? op.length() : 0;
        }

        int l1 = getSubsequence(n-1, c1, op+c1[n]);
        int r1 = getSubsequence(n-1, c1, op);

        return Math.max(l1, r1);
    }

    private static int getSubsequenceCount(int n, char[] c1, String op, int[] dp){
        if(n<0){
            return 1;
        }
        if(dp[n]!=-1) return dp[n];
        int l1 = getSubsequenceCount(n-1, c1, op+c1[n], dp);
        int r1 = getSubsequenceCount(n-1, c1, op, dp);

        return dp[n] = l1+r1;
    }

    private static int getLongestSubsequence(int n, char[] c1, String op, int[] dp){
        if(n<0){
            return op.length();
        }
        if(dp[n]!=-1){
            System.out.println("n:"+n+" val:"+dp[n]);
            return dp[n];
        }
        System.out.println("n:"+n);
        int l1 = getLongestSubsequence(n-1, c1, op+c1[n], dp);
        int r1 = getLongestSubsequence(n-1, c1, op, dp);

        return dp[n] = Math.max(l1, r1);
    }

    private static boolean isPalindrome(String s1){
        for(int i=0, j=s1.length()-1; i<j; i++, j--){
            if(s1.charAt(i)!= s1.charAt(j)) return false;
        }
        return true;
    }
}
