package recursion.lcs;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String s1 = "abcab";
        String s2 = "abcab";

        int lcs2 = longestRepeatingSubsequence(s1, s1.length() - 1, s2, s2.length() - 1);
        System.out.println("recursion:"+lcs2);
    }

    private static int longestRepeatingSubsequence(String s1, int i1, String s2, int i2) {
        if (i1 < 0 || i2 < 0) return 0;
        if (s1.charAt(i1) == s2.charAt(i2) && i1!=i2) {
            return 1 + longestRepeatingSubsequence(s1, i1 - 1, s2, i2 - 1);
        }
        return Math.max(longestRepeatingSubsequence(s1, i1 - 1, s2, i2), longestRepeatingSubsequence(s1, i1, s2, i2 - 1));
    }
}
