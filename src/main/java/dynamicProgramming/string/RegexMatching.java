package dynamicProgramming.string;

import matrix.Util;

//. represents any single character, _* - it can be zero i.e. mip* will either be mi(* while getting ignored , make 'p' also ignored)
// or it can keep only prev char for once or multiple instance. so mip* can make (mi, mip, mipp, mippp...)
public class RegexMatching {
    public static void main(String[] args){
        String main = "mississippi";
        String regex = "mis*i.*p*i";

        boolean isRegex = isRegexMatch(main, regex);
        System.out.println(isRegex);
    }

    /*
    1. s1[i] != s2[j] --- dp[i][j] = false
    2. s1[i] == s2[j] || s1[i] == '.' ---- dp[i][j] = true
    3. s1[i] == '*' ---- dp[i][j] = dp[i-2][j] || s2[j-1] == s1[i] ? dp[i][j-1] : false;
    -- 3rd point: for * look two rows before the current row which means if * is getting ignored it is making its prev char ignored
    -- if * is not getting ignored then look at prev column only when s1[i]/ main string char == prev char of * i,e, s2[j-1] as s2[j] = *
     */
    private static boolean isRegexMatch(String main, String regex){
        int n = main.length();
        int m = regex.length();

        boolean[][] dp = new boolean[m+1][n+1];
        // first cell, 00. it represent _, _
        dp[0][0] = true;
        for(int r=1; r<=m; r++){
            if(regex.charAt(r-1) == '*'){
                // * getting ignored e.g.: mis*, * getting ignored so string is left with mi i.e. two less rows so row-2
                dp[r][0] = /*r >= 2 && */dp[r - 2][0];
            }
        }

        // filling dp from 0,0 to n,m
        for(int r=1; r<=m; r++){
            for(int c=1; c<=n; c++){
                if(main.charAt(c-1) == regex.charAt(r-1) || regex.charAt(r-1) == '.'){
                    //looking top left if char are equal or s1[r] == '.'
                    dp[r][c] = dp[r-1][c-1];
                }
                else{
                    if(regex.charAt(r-1) == '*'){
                        dp[r][c] = r >= 2 && dp[r-2][c];
                        if(main.charAt(c-1) == regex.charAt(r-2) || regex.charAt(r-2) == '.'){
                            dp[r][c] = dp[r][c-1] || dp[r][c];
                        }
                    }
                }

            }
        }
        Util.printMatrix(dp);
        return dp[m][n];
    }
}
