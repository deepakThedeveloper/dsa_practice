package dynamicProgramming.matrices;

import matrix.Util;

public class MaximumGold {
    public static void main(String[] args) {
        int[][] gold = {{1,2,3}, {4,5,6}, {7,8,9}};

        int rlen = gold.length;
        int cLen = gold[0].length;
        int[][] dp = Util.getMatrix(rlen, cLen, -1);
        int max=Integer.MIN_VALUE;
        for(int i=0; i<rlen; i++) {
            int temp = maxGoldMemoizationRevision(gold, i, 0, dp);
            max = Math.max(temp, max);
        }
        System.out.println("max using memoization::"+max);
        Util.printMatrix(dp);

        System.out.println();
        int maxGoldProfit = getMaxGoldByTabulationRevision(gold);
        System.out.println("max using tabulation:"+maxGoldProfit);
    }

    private static int maxGoldMemoizationRevision(int[][] a, int sr, int sc, int[][] dp){
        if(sr >=a.length || sc>=a[0].length || sr<0 || sc<0) return 0;

        if(sr==a.length-1 && sc==a[0].length-1) {
            dp[sr][sc] = a[sr][sc];
            return a[sr][sc];
        }

        if(dp[sr][sc] != -1) return dp[sr][sc];
        int v1 = maxGoldMemoizationRevision(a, sr - 1, sc + 1, dp);
        int v2 = maxGoldMemoizationRevision(a, sr, sc + 1, dp);
        int v3 = maxGoldMemoizationRevision(a, sr + 1, sc + 1, dp);

        return dp[sr][sc] = Math.max(v1, Math.max(v2, v3)) + a[sr][sc];
    }

    private static int getMaxGoldByTabulationRevision(int[][] gold) {
        int r = gold.length;
        int c = gold[0].length;
        int[][] dp = Util.getMatrix(r, c, 0);
        for(int i = 0; i<r; i++){
            dp[i][c-1] = gold[i][c-1];
        }

        int max = Integer.MIN_VALUE;
        for(int col=c-2; col>=0; col--){
            for(int row = r-1; row>=0; row--){
                int v1 = row-1>=0 && col+1<c ? dp[row-1][col+1] : 0;
                int v2 = col+1<c ? dp[row][col+1]:0;
                int v3 = row+1<r && col+1<c ? dp[row+1][col+1] : 0;

                int currVal = gold[row][col];

                int max1 = Math.max(currVal+v1, Math.max(currVal+v2, currVal+v3));
                dp[row][col] = max1;
                max = Math.max(max1, max);
            }
        }
        Util.printMatrix(dp);
        return max;
    }
}
