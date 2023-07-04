package dynamicProgramming.lcs;

import matrix.Util;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";

        int[][] dp1 = Util.getMatrix(s1.length(), s2.length(), -1);
        int lcs1 = lcsMemoizationRevision(s1, s1.length() - 1, s2, s2.length() - 1, dp1);
        int scs1 = s1.length()+s2.length()-lcs1;
        System.out.println("shortest common super sequence memoization:"+scs1);

        int lcs2 = lcsTabulationRevision(s1, s2);
        System.out.println("tabulation revision:"+lcs2);
        int scs2 = s1.length()+s2.length()-lcs2;
        System.out.println("shortest common super sequence tabulation:"+scs2);

        printSCSDirectApproach(s1, s2);
    }

    // find LCS >> traverse the tabulation matrix from bottom to top to print shortest common supersequence
    private static void printSCSDirectApproach(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int r=1; r<=n; r++){
            for(int c=1; c<=m; c++){
                if (s1.charAt(r-1) == s2.charAt(c-1)) {
                    dp[r][c] = dp[r-1][c-1]+1;
                }
                else{
                    dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);
                }
            }
        }

        int minSCSLength = n+m-dp[n][m];
        System.out.println("LCS:" +dp[n][m]+"Min SCS Length:"+minSCSLength);

        StringBuilder builder = new StringBuilder();
        int r=n, c=m;
        while(r>0 && c>0){
            if(s1.charAt(r - 1) == s2.charAt(c - 1)){
                builder.insert(0, ""+s1.charAt(r-1));
                r--;
                c--;
            }
            else{
                if(dp[r - 1][c] >= dp[r][c - 1]){
                    builder.insert(0, ""+s1.charAt(r-1));
                    r--;
                }
                else{
                    builder.insert(0, ""+s2.charAt(c-1));
                    c--;
                }
            }
        }
        while(r>0){
            builder.insert(0, ""+s1.charAt(r-1));
            r--;
        }
        while(c>0){
            builder.insert(0, ""+s2.charAt(c-1));
            c--;
        }
        System.out.println("Shortest Common Supersequence:"+builder.toString());
    }

    private static int lcsMemoizationRevision(String s1, int i1, String s2, int i2, int[][] dp) {
        if (i1 < 0 || i2 < 0) return 0;

        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if (s1.charAt(i1) == s2.charAt(i2)) {
            return dp[i1][i2] = 1 + lcsMemoizationRevision(s1, i1 - 1, s2, i2 - 1, dp);
        }
        return dp[i1][i2] = Math.max(lcsMemoizationRevision(s1, i1 - 1, s2, i2, dp),
                lcsMemoizationRevision(s1, i1, s2, i2 - 1, dp));
    }

    private static int lcsTabulationRevision(String s1, String s2){
        int i1 = s1.length();
        int i2 = s2.length();

        int[][] dp = Util.getMatrix(i1+1, i2+1, 0);

        for(int i=1; i<=i1; i++){
            for(int j=1; j<=i2; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        Util.printMatrix(dp);

        printSCSDirectApproach(s1, s2, dp);
        return dp[i1][i2];
    }

    // for display we will start from n-1, m-1 till 0,0. if at any index we find row and column cell same e.g. t(horizontal)
    // and t(vertical) then we will add it once. if char is different then we will compare dp[i-1][j] with dp[i][j-1]
    // which ever is larger we will move in that direction. Lets say we moved up i.e. dp[i-1][j] means we are moving in
    // updirection and so we are loosing in the character at current row as we are going one row above. so we are adding
    // that row char. similarly if we are moving horizontal then we are moving one col to left and so we are adding
    // current col. at the end there is a possibility that we reach to 0 index of either row or col and other section is not
    //traversed and so in such case below are two while loops
    private static void printSCSDirectApproach(String s1, String s2, int[][] dp){
        StringBuilder str = new StringBuilder();
        int i=dp.length-1, j=dp[0].length-1;
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                str.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                str.append(s1.charAt(i-1));
                i--;
            }
            else{
                str.append(s2.charAt(j-1));
                j--;
            }
        }
        while(i>0){
            str.append(s1.charAt(i-1));
            i--;
        }
        while(j>0){
            str.append(s2.charAt(j-1));
            j--;
        }
        System.out.println(reverse(str.toString()));
    }


    private static String reverse(String s1){
        StringBuilder builder = new StringBuilder();
        for(int i=s1.length()-1; i>=0; i--){
            builder.append(s1.charAt(i));
        }
        return builder.toString();
    }

}
