package recursion.backtracking;

import matrix.Util;

public class SudokoRevision {
    public static void main(String[] args) {
        int[][] sudoku = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        solveSudoku(sudoku, 0, 0);
    }

    private static void solveSudoku(int[][] sudoku, int r, int c) {
        if(r== sudoku.length){
            Util.printMatrix(sudoku);
            return;
        }
        for (int col = c; col < 9; col++) {
            if (sudoku[r][col] != 0) continue;
            for (int i = 1; i <= 9; i++) {
                if (isValid(sudoku, r, col, i)) {
                    sudoku[r][col] = i;
                    solveSudoku(sudoku, r, c + 1);
                    sudoku[r][col] = 0;
                }
            }
            return;
        }
        solveSudoku(sudoku, r+1, 0);
    }

    private static boolean isValid(int[][] sudoku, int r, int c, int val) {
        for(int i=0; i<9; i++){
            if(sudoku[r][i] == val)
            return false;
        }

        for(int i=0; i<9; i++){
            if(sudoku[i][c] == val)
            return false;
        }

        int subMatrixR = r/3 *3;
        int subMatrixC = c/3 *3;

        for(int i = subMatrixR; i<=subMatrixR+2; i++){
            for(int j = subMatrixC; j<=subMatrixC+2; j++){
                if(sudoku[i][j] == val) return false;
            }
        }
        return true;
    }
}
