package backtracking;

import matrix.Util;

public class NQueenBoundAndReleaseAlgo {
    public static void main(String[] args) {
        int[][] board = Util.getMatrix(4,4,0);
        int nQueen = 4;
        int n = board.length;
        placeNQueens(0, nQueen, board, new int[n], new int[2*n-1], new int[2*n-1], n-1);
    }

    private static void placeNQueens(int idx, int n, int[][] mat, int[] col, int[] rightDiag, int[] leftDiag, int boardLen){
        if(idx==n){
            Util.printMatrix(mat);
            return;
        }
        for(int j=0;j<mat[0].length; j++){
            if(canPlaceQueen(idx, j, col, rightDiag, leftDiag, boardLen)){
                mat[idx][j] = idx+1;
                col[j] = 1;
                rightDiag[idx+j] = 1;
                leftDiag[idx - j + boardLen] = 1;
                placeNQueens(idx+1, n, mat, col, rightDiag, leftDiag, boardLen);
                col[j] = 0;
                rightDiag[idx+j] = 0;
                leftDiag[idx-j+boardLen] = 0;
                mat[idx][j] = 0;
            }
        }
    }

    private static boolean canPlaceQueen(int i, int j, int[] col, int[] rightDiag, int[] leftDiag, int boardLen){
        if(col[j]==1 || rightDiag[i+j]==1 || leftDiag[i-j+boardLen]==1) return false;
        return true;
    }
}
