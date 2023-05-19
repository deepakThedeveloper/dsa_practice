package backtracking;

public class FIndWord {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCCED";
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean found = false;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                found = findWord(board, word, i, j, visited, 0);
                if(found) break;
            }
            if(found) break;
        }
        System.out.println(found);
    }
    public static boolean findWord(char[][] board, String word, int r, int c, boolean[][] visited, int i){
        if(i==word.length()) return true;
        if(r<0 || c<0 || r == board.length || c == board[0].length || visited[r][c] || board[r][c] != word.charAt(i)){
            return false;
        }
        visited[r][c] = true;
        boolean found;
            found  = findWord(board, word, r + 1, c, visited, i+1)
            || findWord(board, word,  r - 1, c, visited, i+1)
            || findWord(board, word,  r, c + 1, visited, i+1)
            || findWord(board, word,  r, c - 1, visited, i+1);

        visited[r][c] = false;
        return found;
    }
}
