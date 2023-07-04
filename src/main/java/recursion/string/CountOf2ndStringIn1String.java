package recursion.string;

/**
 * There are 2 strings s1 and s2.
 * Need to find count of s2 appearing number of times in s1 as distinct subsequence.
 */
public class CountOf2ndStringIn1String {
    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";

        int repetitiveSubsequence = distinctSubsequenceCount(s1, s1.length()-1, s2, s2.length()-1);
        System.out.println("recursion:"+repetitiveSubsequence);

        int repetitiveSubsequence1 = distinctSubsequenceCountTabulation(s1, s2);
        System.out.println("tabulation:"+repetitiveSubsequence1);
    }

    /**
     * Consider s1 = "babgbag" s2 = "bag". Now i want to find how many time s2 appears in s1 as a distinct subsequence.
     * First thing, if I need to return count then I need to do plus a recursive method either with another recursive method
     * or with some constant like count/sum. There is no scope of MAX or MIN.
     * Second: Lets start comparing two string char by char. starting from n-1 and m-1 of both the strings,
     * we need to check 'g' appears in string s1. Now there are 2 occurences of g in s1. now as we have to explore all the paths
     * i.e all possible values of 'g' in s1 we have two options. Either will consider the current occurence of 'g' or will
     * ignore current occurence and try find out any further occurences of 'g'.
     * If we go ahead with first occurence then now we found first char and now we need to find second occurrence. i.e. we
     * now need to shrink the two strings. s1 = babgba and s2 = ba and try finding occurence of next char m-2 in 0----n-2
     * If we go ahead with not selecting first occurrence then we can keep current string s2 and try searching s2 in 0---n-2
     * i.e. s1 = babgba and s2 = bag. search m-1 in 0----n-2.
     * Above are the positive cases when we found the character of s2 in s1. but what if we don't find the character.
     * In that case we have no option but to shrink first string and search whole second string in first string.
     * s1 = babgba and s2 = bag.
     */
    private static int distinctSubsequenceCount(String s1, int i, String s2, int j){
        if(j<0) return 1;
        if(i<0) return 0;

        if(s1.charAt(i) == s2.charAt(j)){
            return distinctSubsequenceCount(s1, i-1, s2, j-1) + distinctSubsequenceCount(s1, i-1, s2, j);
        }
        else{
            return distinctSubsequenceCount(s1, i-1, s2, j);
        }
    }

    private static int distinctSubsequenceCountTabulation(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}
