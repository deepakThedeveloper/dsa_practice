package dynamicProgramming.matrices;

import matrix.Util;

public class ParallelMatrixTraversal {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4}, {11,12,13,14}, {21,22,23,24}, {31,32,33,34}};
        int[][][] dp = Util.get3DMatrix(mat.length, mat[0].length, mat[0].length);
        int minCost = minPathMemoization(mat, 0,0,0,mat[0].length-1, dp);
        System.out.println("min cost memoization:"+minCost);

        int minCost1 = minPathTabulationRevision(mat);
        System.out.println("min cost tabulation:"+minCost1);
    }

    private static int minPathMemoization(int[][] mat, int i, int aliceJ, int bobJ, int clen, int[][][] dp){
        if(aliceJ>=clen || aliceJ<0 || bobJ>=clen || bobJ<0) return Integer.MIN_VALUE;
        if(i == mat.length-1){
            if(aliceJ == bobJ) return mat[i][aliceJ];
            return mat[i][aliceJ] + mat[i][bobJ];
        }
        if(dp[i][aliceJ][bobJ]!=-1) return dp[i][aliceJ][bobJ];
        int max = Integer.MIN_VALUE;
        for(int i1=-1; i1<=1; i1++){
            for(int j=-1; j<=1; j++) {
                int value = mat[i][aliceJ] + minPathMemoization(mat,  i+1, aliceJ+i1,  bobJ+j, clen, dp);
                if(aliceJ!=bobJ){
                    value += mat[i][bobJ];
                }
                max = Math.max(value, max);
            }
        }
        return dp[i][aliceJ][bobJ] = max;
    }

    //todo
    private static int minPathTabulationRevision(int[][] mat){
        int rlen = mat.length;
        int clen = mat[0].length;

        int[][][] dp = new int[rlen][clen][clen];

        for(int j1=0; j1<clen; j1++){
            for(int j2=0; j2<clen; j2++) {
                if(j1==j2) dp[rlen-1][j1][j2] = mat[rlen-1][j1];
                else dp[rlen-1][j1][j2] = mat[rlen-1][j1] + mat[rlen-1][j2];
            }
        }

        for(int row = rlen-2; row >=0; row--){
            for(int j1=0; j1<clen; j1++){
                for(int j2=0; j2<clen; j2++){
                    int max = Integer.MIN_VALUE;
                    for(int i1=-1; i1<=1; i1++){
                        for(int j=-1; j<=1; j++) {
                            int value = 0;
                            if(j1==j2) value = mat[row][j1];
                            else value = mat[row][j1]+mat[row][j2];

                            if(j1 + i1 >= 0 && j1 + i1 < clen && j2 + j >= 0 && j2 + j < clen){
                                value += dp[row + 1][j1 + i1][j2 + j];
                            }
                            else{
                                value += Integer.MIN_VALUE;
                            }
                            max = Math.max(value, max);
                        }
                    }
                    dp[row][j1][j2] = max;
                }
            }
        }
        return dp[0][0][clen-1];
    }
}
