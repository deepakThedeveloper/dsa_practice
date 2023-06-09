package dynamicProgramming.lcs;

import matrix.Util;

//refer: /resources/LongestCommonSubarray.jpg
public class LongestCommonSubarray {
    public static void main(String[] args) {
        int[] a1 = {1,3,5,4,2,6};
        int[] a2 = {6,3,2,3,5,4,2,1};

        int maxLength = largestCommonSubarray(a1, a2);
        System.out.println(maxLength);
    }

    private static int largestCommonSubarray(int[] a1, int[] a2){
        int n = a1.length;
        int m = a2.length;
        int[][] dp = new int[n+1][m+1];

        for(int row=1; row<n; row++){
            for(int col=1; col<m; col++){
                if(a1[row-1] == a2[col-1]){
                    dp[row][col] = dp[row-1][col-1]+1;
                }
                else{
                    dp[row][col] = dp[row][col-1];
                }
            }
        }

        Util.printMatrix(dp);
        return dp[n-1][m-1];
    }
}
