package recursion;

import matrix.Util;

import java.util.Arrays;
import java.util.List;

//todo
public class Crossword {
    public static void main(String[] args){
        List<String> words = Arrays.asList("DELHI", "ICELAND", "ANKARA", "LONDON");
        char[][] board = board();

        solve(words, board, 0);
    }

    private static void solve(List<String> words, char[][] board, int idx){
        if(idx == words.size()){
            Util.printMatrix(board);
            return;
        }
        String word = words.get(idx);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ' ' || board[i][j] == word.charAt(0)) {
                    if(canPlaceHorizontally(board, i, j, word)){
                        placeHorizontally(board, i, j, word);
                        solve(words, board, idx+1);
                        unplaceHorizontally(board, i, j, word);
                    }
                    else if(canPlaceVertically(board, i, j, word)) {
                        placeVertically(board, i, j, word);
                        solve(words, board, idx + 1);
                        unplaceVertically(board, i, j, word);
                    }
                }
            }
        }
    }

    private static boolean canPlaceHorizontally(char[][] board, int i, int j, String word){
        if(j-1 >= 0 && board[i][j-1] != '+') return false;
        int len = j + word.length();
        int m = board[0].length;
        if(len >= m || board[i][len] != '+') return false;

        for(int jj = 0; jj<word.length(); jj++){

            if(board[i][j+jj] != ' ' || board[i][j+jj] != word.charAt(jj)) return false;
        }
        return true;
    }

    private static boolean canPlaceVertically(char[][] board, int i, int j, String word){
        if(i-1 >= 0 && board[i-1][j] != '+') return false;
        int len = i + word.length();
        int n = board.length;
        if(len >= n || board[len][j] != '+') return false;

        for(int jj = 0; jj<word.length(); jj++){
            if(board[i+jj][j] != ' ' || board[i+jj][j] != word.charAt(jj)) return false;
        }
        return true;
    }

    private static void placeHorizontally(char[][] board, int r, int c, String word){
        for(int idx = 0; idx<word.length(); idx++, c++) {
            board[r][c] = word.charAt(idx);
        }
    }

    private static void placeVertically(char[][] board, int r, int c, String word){
        for(int idx = 0; idx<word.length(); idx++, r++) {
            board[r][c] = word.charAt(idx);
        }
    }

    private static void unplaceHorizontally(char[][] board, int r, int c, String word){
        for(int idx = 0; idx<word.length(); idx++, c++) {
            board[r][c] = ' ';
        }
    }

    private static void unplaceVertically(char[][] board, int r, int c, String word){
        for(int idx = 0; idx<word.length(); idx++, r++) {
            board[r][c] = ' ';
        }
    }

    private static char[][] board(){
        return new char[][]{
                {'+', ' ', '+', '+', '+', '+', '+', '+', '+', '+'},
                {'+', ' ', '+', '+', '+', '+', '+', '+', '+', '+'},
                {'+', ' ', '+', '+', '+', '+', '+', '+', '+', '+'},
                {'+', ' ', ' ', ' ', ' ', ' ', '+', '+', '+', '+'},
                {'+', ' ', '+', '+', '+', ' ', '+', '+', '+', '+'},
                {'+', ' ', '+', '+', '+', ' ', '+', '+', '+', '+'},
                {'+', '+', '+', '+', '+', ' ', '+', '+', '+', '+'},
                {'+', '+', ' ', ' ', ' ', ' ', ' ', ' ', '+', '+'},
                {'+', '+', '+', '+', '+', ' ', '+', '+', '+', '+'},
                {'+', '+', '+', '+', '+', ' ', '+', '+', '+', '+'},
        };
    }
}
