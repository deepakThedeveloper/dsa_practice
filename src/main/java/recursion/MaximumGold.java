package recursion;

import matrix.Util;

public class MaximumGold {
    public static void main(String[] args) {
        //int[][] gold = {{0,1,4,2,8,2}, {4,3,6,5,0,4}, {1,2,4,1,4,6}, {2,0,7,3,2,2}, {3,1,5,9,2,4}, {2,7,0,8,5,5}};
        int[][] gold = {{1,2,3}, {4,5,6}, {7,8,9}};

       /* getMaxGoldByRecursion(gold, 0, 0, 0);
        System.out.println("max profit:"+maxProfit);*/

        int rlen = gold.length;
        int cLen = gold[0].length;
        int[][] mat = Util.getMatrix(rlen, cLen, -1);
        int max=Integer.MIN_VALUE;
        for(int i=0; i<rlen; i++) {
            int temp = maxGoldRecursionReturnRevision(gold, i, 0, mat);
            max = Math.max(temp, max);
        }
        System.out.println("max using memoization::"+max);
        Util.printMatrix(mat);

        System.out.println();
        int maxGoldProfit = getMaxGoldByTabulationRevision(gold);
        System.out.println("max using tabulation:"+maxGoldProfit);
    }

    private static int maxGoldRecursionReturnRevision(int[][] a, int sr, int sc, int[][] mat){
        if(sr >=a.length || sc>=a[0].length || sr<0 || sc<0) return 0;

        if(sr==a.length-1 && sc==a[0].length-1) {
            mat[sr][sc] = a[sr][sc];
            return a[sr][sc];
        }

        if(mat[sr][sc] != -1) return mat[sr][sc];
        int v1 = maxGoldRecursionReturnRevision(a, sr - 1, sc + 1, mat);
        int v2 = maxGoldRecursionReturnRevision(a, sr, sc + 1, mat);
        int v3 = maxGoldRecursionReturnRevision(a, sr + 1, sc + 1, mat);

        int currVal = a[sr][sc];
        int max = Math.max(currVal + v1, Math.max(currVal + v2, currVal + v3));
        mat[sr][sc] = max;

        return max;
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
