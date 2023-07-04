package dynamicProgramming.lcs;

import matrix.Util;

public class MinAsciiDeleteToMakeStringEqual {
    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";

        int minAsciiDeletion = minAsciiDeletionToMakeStringEqualTabulation(s1, s2);
        System.out.println(minAsciiDeletion);

//        int[][] dp = Util.getMatrix(s1.length(),s2.length(), -1);
//        int minAsciiDeletion1 = minAsciiDeletionToMakeStringEqualMemo(s1.length()-1, s1, s2.length()-1, s2, dp);
//        Util.printMatrix(dp);
//        System.out.println();
//        System.out.println("memo:"+minAsciiDeletion1);

        int minAsciiDeletion1 = minAsciiDeletionTabulationDirect(s1, s2);
        System.out.println();
        System.out.println("tabulation:"+minAsciiDeletion1);
    }

    private static int minAsciiDeletionTabulationDirect(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int[][] dp = Util.getMatrix(n+1, m+1, 0);
        for(int r=dp.length-1; r>=0; r--){
            for(int c=dp[0].length-1; c>=0; c--){
                if(r==dp.length-1 && c==dp[0].length-1){
                    dp[r][c] = 0;
                }
                else if(r==dp.length-1){
                    dp[r][c] = (int)s2.charAt(c) + dp[r][c+1];
                }
                else if(c==dp[0].length-1){
                    dp[r][c] = (int)s1.charAt(r) + dp[r+1][c];
                }
                else{
                    if(s1.charAt(r) == s2.charAt(c)){
                        dp[r][c] = dp[r+1][c+1];
                    }
                    else {
                        dp[r][c] = Math.min((int)s1.charAt(r) + dp[r + 1][c],
                                (int)s2.charAt(c)+dp[r][c + 1]);
                    }
                }
            }
        }
        Util.printMatrix(dp);
        System.out.println();
        return dp[0][0];
    }

    private static int minAsciiDeletionToMakeStringEqualTabulation(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int[][] dp = Util.getMatrix(n+1, m+1, 0);

        for(int r=n-1; r>=0; r--){
            dp[r][m] = dp[r+1][m]+(int)s2.charAt(r);
        }
        for(int c=m-1; c>=0; c--){
            dp[n][c] = dp[n][c+1]+(int)s1.charAt(c);
        }

        for(int r=n-1; r>=0; r--){
            for(int c=m-1; c>=0; c--){
                char ch1 = s1.charAt(c);
                char ch2 = s2.charAt(r);

                if(ch1 == ch2) dp[r][c] = dp[r+1][c+1];
                else {
                    int right = dp[r][c+1];
                    int down = dp[r+1][c];
                    if(right < down){
                        dp[r][c] = right + (int)ch1;
                    }
                    else{
                        dp[r][c] = down + (int)ch2;
                    }
                }
            }
        }
        Util.printMatrix(dp);
        return dp[0][0];
    }

    private static int minAsciiDeletionToMakeStringEqualMemo(int i, String s1, int j, String s2, int[][] dp){
        if(i==0 && j==0) {
            return s1.charAt(i) == s2.charAt(j)
                    ? 0
                    : (int)s1.charAt(i) + (int)s2.charAt(j);
        }
        if(i<0 && j>=0){
            int sum = 0;
            while (j>=0){
                sum += (int)s2.charAt(j);
                j--;
            }
            return sum;
        }
        if(j<0 && i>=0){
            int sum = 0;
            while (i>=0){
                sum += (int)s1.charAt(i);
                i--;
            }
            return sum;
        }

        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = minAsciiDeletionToMakeStringEqualMemo(i-1, s1, j-1, s2, dp);
        }
        else{
            int s1Traverse = minAsciiDeletionToMakeStringEqualMemo(i-1, s1, j, s2, dp) + (int)s1.charAt(i);
            int s2Traverse = minAsciiDeletionToMakeStringEqualMemo(i, s1, j-1, s2, dp) + (int)s2.charAt(j);
            return dp[i][j] = Math.min(s1Traverse, s2Traverse);
        }
    }
}
