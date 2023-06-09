package dynamicProgramming.combination.palindrome;

//refer image /ressources/count_palindromic_substring.jpg
public class PalindromicSubstring {
    public static void main(String[] args) {
        String str = "abccbc";
        int count = countPalindromicSubstring(str);
        System.out.println(count);
    }
    private static int countPalindromicSubstring(String str){
        int n = str.length();
        boolean[][] dp = new boolean[n][n];

        int count = 0;
        for(int i=0; i<n; i++){
            for(int r=0, c=i; c<n; r++, c++){
                if(i==0) dp[r][c] = true;
                else if(i==1) dp[r][c] = str.charAt(r) == str.charAt(c);
                else dp[r][c] = str.charAt(r) == str.charAt(c) && dp[r+1][c-1];
                if(dp[r][c]) count++;
            }
        }
        return count;
    }

}
