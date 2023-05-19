package recursion;

/**
 * supersequence means combination of both the string. e.g: brute and groot so the super sequence could be
 * brutegroot. but we need to find shortest i.e from main supersequence(brutegroot) common characters in both the string
 * to be taken once and should not get repeated. in our case "rt" is common longest string between str1 and str2 which
 * should be taken once. This clearly hints me that from two string I need to find longest common string i.e.
 * longest common subsequence. so final answer will be str1.len + str2.len - lcs.
 * e.g.: brute - len = 5, groot - len = 5, lcs = rt = le
 * final string = 5+5-2 = 8 i.e. bgruoote.
 * NOTE: make sure that final string should have char order to be maintained.
 */
public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";
        int lcs = lcs(s1, s1.length() - 1, s2, s2.length() - 1);
        int scs = s1.length()+s2.length()-lcs;
        System.out.println("shortest common super sequence:"+scs);
    }

    private static int lcs(String s1, int i1, String s2, int i2) {
        if (i1 < 0 || i2 < 0) return 0;
        if (s1.charAt(i1) == s2.charAt(i2)) {
            return 1 + lcs(s1, i1 - 1, s2, i2 - 1);
        }
        return Math.max(lcs(s1, i1 - 1, s2, i2), lcs(s1, i1, s2, i2 - 1));
    }
}
