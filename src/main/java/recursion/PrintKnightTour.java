package recursion;

// Todo;
public class PrintKnightTour {
    public static void main(String[] args) {
        int[][] board = new int[5][5];
        printKnightTour(2,1, board, 1);
    }

    private static void printKnightTour(int sr, int sc, int[][] board, int move) {
        if(sr < 0 ||sr >= board.length || sc<0 || sc >= board[0].length || board[sr][sc] > 0){
            return;
        }
        else if(move == board.length * board.length){
            board[sr][sc] = move;
            displayBoard(board);
            board[sr][sc] = 0;
            return;
        }
        board[sr][sc] = move;
        printKnightTour(sr+2, sc+1, board, move+1);
        printKnightTour(sr+2, sc-1, board, move+1);
        printKnightTour(sr-2, sc+1, board, move+1);
        printKnightTour(sr-2, sc-1, board, move+1);
        printKnightTour(sr+1, sc+2, board, move+1);
        printKnightTour(sr-1, sc-2, board, move+1);
        printKnightTour(sr+1, sc+2, board, move+1);
        printKnightTour(sr-1, sc-2, board, move+1);
        board[sr][sc] = 0;
    }

    private static void displayBoard(int[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
