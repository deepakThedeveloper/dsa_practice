package recursion;

// intution: we need to make whole string palindrome. so in that case first lets find out how much size of string is palindrome
// lets suppose original string length = 10 and out of that 6 characters or subsequence is palindrome.
// now there might be question that there is palindrome but it is subsequence and not substring. It doesn't matter whether
// whether string is subsequence or substring until the string is palindrome. Reason being even is subsequence is palindrome
// but it is in order even if not consecutive. and if a string is in order and palindrome then we need to just add characters
// in between the palindrome subsequence/
// e.g: string str = abea
// longest palindrome  = aea || aba. now in aea, b is missing. If i insert b to right of e then string will abeba.
// how to insert that is different problem. here the question is to find min insertion. and so totalLength - lps = minInsertion
public class MinInsertionToMakeStringPalindrome {
    public static void main(String[] args) {
        String s1 = "bbabcbcab";

        int lps = lps(s1, s1.length() - 1, reverse(s1), s1.length() - 1);
        int minInsertion = s1.length() - lps;
        System.out.println("recursion:"+minInsertion);
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
}
