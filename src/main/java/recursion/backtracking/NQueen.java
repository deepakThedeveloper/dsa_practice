package recursion.backtracking;

public class NQueen {
    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];

        //placeQueens(board, 0, 0);
        int[] leftRow = new int[n];
        int[] lowerLeftDiagonal = new int[2 *n -1];
        int[] upperLeftDiagonal= new int[2 *n -1];

        placeQueensBetterApproach(board, 0, 0, leftRow, lowerLeftDiagonal, upperLeftDiagonal);
    }

    private static void placeQueens(int[][] board, int r, int c) {
        if(c==board.length) {
            printBoard(board);
            return;
        }
        for(int row = r; row<board.length; row++){
            if(canPlaceQueen(board, row, c)){
                board[row][c] = 1;
                placeQueens(board, r, c+1);
                board[row][c] = 0;
            }
        }
    }
    private static void placeQueensBetterApproach(int[][] board, int r, int c, int[] leftRow, int[] lowerLeftDiagonal,
                                                  int[] upperLeftDiagonal) {
        if(c==board.length) {
            printBoard(board);
            return;
        }
        for(int row = r; row<board.length; row++){
            if(leftRow[row] == 0 && lowerLeftDiagonal[row + c] ==0 && upperLeftDiagonal[board.length - 1 + c-row] ==0 ){
                leftRow[row] = 1;
                lowerLeftDiagonal[row + c] = 1;
                upperLeftDiagonal[board.length - 1 + c-row] = 1;

                board[row][c] = 1;
                placeQueensBetterApproach(board, r, c+1, leftRow, lowerLeftDiagonal, upperLeftDiagonal);
                board[row][c] = 0;

                leftRow[row] = 0;
                lowerLeftDiagonal[row + c] = 0;
                upperLeftDiagonal[board.length - 1 + c-row] = 0;
            }
        }
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
    private static boolean canPlaceQueen(int[][] board, int r, int c) {
        int n = board.length;
        //horizontal check
        for(int col = 0; col<n; col++){
            if(board[r][col] == 1) return false;
        }

        //vertical check
        for(int row = 0; row<n; row++){
            if(board[row][c] == 1) return false;
        }

        // diagonal check
        int j=1;
        for(int row = r-1; row>=0; row--){
            if(c-j>=0 && board[row][c-j] == 1) return false;
            if(c+j<=n-1 && board[row][c+j] ==1) return false;
            j = j+1;
        }
        j=1;
        for(int row = r+1; row<n; row++){
            if(c-j>=0 && board[row][c-j] == 1) return false;
            if(c+j<=n-1 && board[row][c+j] ==1) return false;
            j = j+1;
        }
        return true;
    }
}
