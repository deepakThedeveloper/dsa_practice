package dynamicProgramming.gap_strategy_pattern;

//refer image /ressources/count_palindromic_substring.jpg
public class CountPalindromicSubstring {
    public static void main(String[] args) {
        String str = "abccbc";
        int count = countPalindromicSubstring(str);
        System.out.println(count);
    }
    private static int countPalindromicSubstring(String str){
        int n = str.length();
        boolean[][] dp = new boolean[n][n];

        int count = 0;
        for(int g=0; g<n; g++){
            for(int i=0, j=g; j<n; i++, j++){
                if(g==0) dp[i][j] = true;
                else if(g==1) dp[i][j] = str.charAt(i) == str.charAt(j);
                else dp[i][j] = str.charAt(i) == str.charAt(j) && dp[i+1][j-1];
                if(dp[i][j]) count++;
            }
        }
        return count;
    }

}
