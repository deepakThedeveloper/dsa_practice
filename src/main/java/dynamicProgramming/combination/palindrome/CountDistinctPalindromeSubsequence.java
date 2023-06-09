package dynamicProgramming.combination.palindrome;

import lombok.AllArgsConstructor;
import matrix.Util;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctPalindromeSubsequence {
    public static void main(String[] args) {
        String str = "abccbc";
        int count = countDistinctPalindromicSubsequence(str);
        System.out.println(count);
    }

    //todo: not working summit mallik dsa 2
    private static int countDistinctPalindromicSubsequence(String str){
        int n = str.length();
        int[][] dp = new int[n][n];

        Map<Character, Integer> map = new HashMap<>();
        int[] prev = new int[n];
        for(int i=0; i<n; i++){
            char c = str.charAt(i);
            prev[i] = map.getOrDefault(c, -1);
            map.put(c, i);
        }

        map.clear();;
        int[] next = new int[n];
        for(int i=n-1; i>=0; i--){
            char c = str.charAt(i);
            next[i] = map.getOrDefault(c, -1);
            map.put(c, i);
        }

        for(int i=0; i<n; i++){
            for(int r=0, c=i; c<n; r++, c++){
                if(i==0)dp[r][c] = 1;
                else if(i==1)dp[r][c] = 2;
                else {
                    char start = str.charAt(r);
                    char end = str.charAt(c);
                    int v;
                    if (start != end) {
                        v = dp[r][c - 1] + dp[r + 1][c] - dp[r+1][c-1];
                    } else {
                        int next1 = next[r];
                        int prev1 = prev[c];
                        if(next1 > prev1){
                            v = 2*dp[r+1][c-1]+2;
                        }
                        else if(prev1 == next1){
                            v = 2*dp[r+1][c-1]+1;
                        }
                        else{
                            v = 2*dp[r+1][c-1] - dp[next1+1][prev1-1];
                        }
                    }
                    dp[r][c] = v;
                }
            }
        }
        Util.printMatrix(dp);
        return dp[0][n-1];
    }

    @AllArgsConstructor
    static class Pair{
        int secondIndex;
        int secondLastIndex;
    }
}

