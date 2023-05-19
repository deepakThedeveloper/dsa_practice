package recursion;

import matrix.Util;

public class LongestColumnSubsequence {
    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ead";
        int lcs = lcs(s1, s1.length() - 1, s2, s2.length() - 1);
        System.out.println("recursion:"+lcs);
    }

    private static int lcs(String s1, int i1, String s2, int i2) {
        if (i1 < 0 || i2 < 0) return 0;
        if (s1.charAt(i1) == s2.charAt(i2)) {
            return 1 + lcs(s1, i1 - 1, s2, i2 - 1);
        }
        return Math.max(lcs(s1, i1 - 1, s2, i2), lcs(s1, i1, s2, i2 - 1));
    }
}
