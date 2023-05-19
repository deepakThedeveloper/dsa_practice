package recursion;

public class SudokoRevision1 {
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
//        int[][] sudoku = {{3, 1, 6, 5, 7, 8, 4, 9, 2},
//                {5, 2, 9, 1, 3, 4, 7, 6, 8},
//                {4, 8, 7, 6, 2, 9, 5, 3, 1},
//                {2, 6, 3, 4, 1, 5, 9, 8, 7},
//                {9, 7, 4, 8, 6, 3, 1, 2, 5},
//                {8, 5, 1, 7, 9, 2, 6, 4, 3},
//                {1, 3, 8, 9, 4, 7, 2, 5, 6},
//                {6, 9, 2, 3, 5, 1, 8, 7, 4},
//                {7, 4, 5, 2, 8, 6, 3, 1, 0}};

        solveSudoku(sudoku, 0, 0);
    }

    private static void solveSudoku(int[][] sudoku, int r, int c) {
        if(r == sudoku.length) {
            //printBoard(sudoku);
            System.out.println("in if");
            return;
        }
        for (int i = c; i < sudoku[0].length; i++) {
            if (sudoku[r][i] > 0) continue;
            for (int j = 1; j <= 9; j++) {
                if (canFill(sudoku, r, i, j)) {
                    int prev = sudoku[r][i];
                    sudoku[r][i] = j;
                    solveSudoku(sudoku, r, c + 1);
                    sudoku[r][i] = prev;
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

        for(int i1=0; i1<3; i1++){
            for(int j=0; j<3; j++){
                if(sudoku[subMatrixR+i1][subMatrixC+j] == val){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean canFill(int[][] sudoko, int r, int c, int val){
        int len = sudoko.length;
        // check if value to be inserted exists in that row
        for(int i=0; i<len; i++){
            if(sudoko[r][i] == val) return false;
        }
        //check if value to be inserted exists in that col
        for(int i=0; i<len; i++){
            if(sudoko[i][c] == val) return false;
        }
        //check value to be inserted exist in that sub matrix
        int rowPos = r%3;
        int colPos = c%3;
        int rowStart, rowEnd, colStart, colEnd;
        if(rowPos==0){
            rowStart = r;
            rowEnd = r+2;
        }
        else if(rowPos == 1){
            rowStart = r-1;
            rowEnd = r+1;
        }
        else{
            rowStart = r-2;
            rowEnd = r;
        }
        if(colPos==0){
            colStart = c;
            colEnd = c + 2;
        }
        else if(colPos == 1){
            colStart = c-1;
            colEnd = c+1;
        }
        else{
            colStart = c-2;
            colEnd = c;
        }

        for(int i=rowStart; i<=rowEnd; i++){
            for(int j=colStart; j<=colEnd; j++){
                if(sudoko[i][j] == val) return false;
            }
        }
        return true;
    }
    private static void printBoard(int[][] board){
        System.out.println();
        for(int i=0; i< board.length; i++){
            for(int i1=0; i1< board.length; i1++){
                System.out.print(board[i][i1]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
