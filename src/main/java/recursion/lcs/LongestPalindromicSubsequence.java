package recursion.lcs;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s1 = "abccbc";

        int lps = lps(s1, s1.length() - 1, reverse(s1), s1.length() - 1);
        System.out.println("recursion:"+lps);
        int lps1 = getPalindromicSubsequenceBetterApproach(s1.toCharArray(), 0, s1.length() - 1);
        System.out.println("recursion:"+lps1);
    }

    private static String reverse(String s1){
        StringBuilder builder = new StringBuilder();
        for(int i=s1.length()-1; i>=0; i--){
            builder.append(s1.charAt(i));
        }
        return builder.toString();
    }
    // intution: in palindrome we compre a string character from start and last. i=0 and j=str.length()-1.
    //if they match we shrink string by doing i++ and j--;
    // So thought is,
    // 1. first we need to find subsequence which fits in definition of LCS
    // 2. in LCS we compare two strings char by char from last
    // 3. MAIN: the final output of both the string is common subsequence. i.e. final output of LCS is common subsequence
    // between two string.
    // In palindrome also we need to string at end to be same. aba - aba
    private static int lps(String s1, int i1, String s2, int i2) {
        if (i1 < 0 || i2 < 0) return 0;
        if (s1.charAt(i1) == s2.charAt(i2)) {
            return 1 + lps(s1, i1 - 1, s2, i2 - 1);
        }
        return Math.max(lps(s1, i1 - 1, s2, i2), lps(s1, i1, s2, i2 - 1));
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
}
