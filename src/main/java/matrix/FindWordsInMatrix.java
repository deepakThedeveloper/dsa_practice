package matrix;

public class FindWordsInMatrix {
    public static void main(String[] args){
        char[][] letters = {
                {'a', 'b', 'f', 'd'},
                {'a', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'}
        };
        String[] words = {"abfj", "afjk", "lkgfai", "afgj"};
        traverseAndSearch(letters, words);
    }

    private static void traverseAndSearch(char[][] letters, String[] words){
        int n = letters.length;
        int m = letters[0].length;
        boolean[][] visited = new boolean[n][m];
        for(String word : words){
            found = false;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    isExist(word, letters, visited, i, j, 0);
                    if(found){
                        System.out.println(word+" "+found);
                        break;
                    }
                }
                if(found) break;
            }
        }
    }

    static boolean found = false;
    private static boolean isExist(String word, char[][] letters, boolean[][] visited, int sr, int sc, int idx){
        if(idx == word.length()) return true;
        if(sr < 0 || sc < 0 || sr >= letters.length || sc >= letters[0].length || visited[sr][sc]) return false;

        visited[sr][sc] = true;

        if(letters[sr][sc] == word.charAt(idx)) {
            if(isExist(word, letters, visited, sr, sc+1, idx+1)) found = true;
            if(isExist(word, letters, visited, sr+1, sc, idx+1)) found = true;
            if(isExist(word, letters, visited, sr, sc-1, idx+1)) found = true;
            if(isExist(word, letters, visited, sr-1, sc, idx+1)) found = true;
        }
        visited[sr][sc] = false;

        return false;
    }
}

/**
 * [10:13 AM] Tarun Razdan
 *
 * Given a mxn matrix as an array input. input could be something like [[a,b,b,c,d], [d,g,r,d,h]]
 * You have to find a word like ="a,d,g,b" exists or not. You can move only in four directions and there is a constraint not to visit already visited path.
 * Sample Matrix:
 * {'a', 'b', 'f', 'd'},
 * {'a', 'f', 'g', 'h'},
 * {'i', 'j', 'k', 'l'}
 *
 * Sample Words: {"abfj", "afjk", "lkgfai", "afgj"}
 */