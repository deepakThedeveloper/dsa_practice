package dynamicProgramming.combination.palindrome;

// refer: /resources/count_palindromic_subsequence.jpg
public class CountPalindromicSubsequence {
    public static void main(String[] args) {
        String str = "abccbc";
        int count = countPalindromicSubsequence(str);
        System.out.println(count);
    }

    private static int countPalindromicSubsequence(String str){
        int n = str.length();
        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            for(int r=0, c=i; c<n; r++, c++){
                if(i==0) dp[r][c] = 1;
                else {
                    boolean firstLastCharMatch = str.charAt(r) == str.charAt(c);
                    if(i==1) dp[r][c] = firstLastCharMatch ? 3 : 2;
                    else{
                        int v;
                        if(firstLastCharMatch){
                            v = dp[r][c-1]+dp[r+1][c]+1;
                        }
                        else{
                            v = dp[r][c-1]+dp[r+1][c]-dp[r+1][c-1];
                        }
                        dp[r][c] =  v;
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
