package recursion;

public class NQueenProblem {
    public static void main(String[] args) {
        int[][] board = new int[4][4];
        nQueen(board, 4, 0);
        //printLocationOfNQueen(board, "",0);
    }

    private static void nQueen(int[][] board, int n, int row){
        if(n==0){
            printBoard(board);
            return;
        }
        for(int j=0; j<board[0].length; j++){
            if(isValid(row, j, board)){
                board[row][j] = 1;
                nQueen(board, n-1, row+1);
                board[row][j] = 0;
            }
        }
    }

    private static boolean isValid(int r, int c, int[][] board){
        int rLen = board.length;
        int cLen = board[0].length;

        // check if anything is present in row
        for(int i=0; i<cLen; i++){
            if(board[r][i] == 1) return false;
        }

        //check if anything is present in col
        for(int i=0; i<rLen; i++){
            if(board[i][c] == 1) return false;
        }

        //check if anything is present in diagonals r-1, c-1
        for(int i=r-1, j=c-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 1) return false;
        }

        //check if anything is present in diagonals r-1, c+1
        for(int i=r-1, j=c+1; i>=0 && j<cLen; i--, j++){
            if(board[i][j] == 1) return false;
        }
        return true;
    }

    private static void printBoard(int[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("===============================");
    }
    private static void printLocationOfNQueen(int[][] board, String op, int i) {
        if(i == board.length){
            System.out.println(op);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if(!matchesHVD(i, j, board)) {
                board[i][j] = 1;
                printLocationOfNQueen(board, op + i +"-" + j+" , ", i + 1);
                board[i][j] = 0;
            }
        }
    }

    private static boolean matchesHVD(int sr, int sc, int[][] board) {
        //vertical presence of queen
        for(int i=sr-1; i>=0; i--){
            if(board[i][sc] == 1)
                return true;
        }

        // diagonal presence testing
        for(int i = sr-1, j = sc-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 1){
                return true;
            }
        }

        for(int i = sr-1, j = sc+1; i>=0 && j<board[0].length; i--, j++){
            if(board[i][j] == 1){
                return true;
            }
        }
        return false;
    }
}
