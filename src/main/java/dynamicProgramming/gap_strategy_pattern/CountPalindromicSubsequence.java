package dynamicProgramming.gap_strategy_pattern;

// refer: /resources/count_palindromic_subsequence.jpg
public class CountPalindromicSubsequence {
    public static void main(String[] args) {
        String str = "abccbc";
        int count = countPalindromicSSTabuDirect(str);
        System.out.println(count);
    }

    //gap strategy
    private static int countPalindromicSSTabuDirect(String str){
        int n = str.length();
        int[][] dp = new int[n][n];

        for(int g=0; g<n; g++){
            for(int i=0, j=g; j<n; i++, j++){
                // single char a,b,c
                if(g==0) dp[i][j] = 1;
                // two char ab, bc = 2 {a,b or b,c}, cc=3 {c, c, cc}
                else if(g==1) dp[i][j] = str.charAt(i) == str.charAt(j) ? 3 : 2;
                else {
                    //cbc = prefix + suffix + 1
                    if(str.charAt(i) == str.charAt(j)){
                        dp[i][j] = dp[i+1][j] + dp[i][j-1] + 1;
                    }
                    //abc = prefix + suffix - middle
                    else{
                        dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
