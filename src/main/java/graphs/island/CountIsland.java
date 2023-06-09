package graphs.island;

public class CountIsland {
    public static void main(String[] args) {
        int[][] mat = {
                {0,0,1,1,1,1,1},
                {0,0,1,1,0,0,1},
                {1,1,1,1,1,1,0},
                {1,1,0,0,0,1,0},
                {0,1,1,1,0,1,0},
                {1,1,1,1,1,1,1}};
        int count = countIsland(mat);
        System.out.println(count);
;    }
    private static int countIsland(int[][] mat){
        int rlen = mat.length;
        int clen = mat[0].length;

        int count = 0;
        boolean[][] visited = new boolean[rlen][clen];
        for(int i=0; i<rlen; i++){
            for(int j=0; j<clen; j++){
                if(!visited[i][j] && mat[i][j] == 0) {
                    count += traverseAndCount(mat, i, j, rlen, clen, visited);
                }
            }
        }
        return count;
    }
    private static int traverseAndCount(int[][] mat, int sr, int sc, int dr, int dc, boolean[][] visited){
        if(sr >= dr || sr < 0 || sc >= dc || sc < 0 || visited[sr][sc] || mat[sr][sc] == 1) return 0;

        visited[sr][sc] = true;
        traverseAndCount(mat, sr, sc+1, dr, dc, visited);
        traverseAndCount(mat, sr+1, sc, dr, dc, visited);
        traverseAndCount(mat, sr, sc-1, dr, dc, visited);
        traverseAndCount(mat, sr-1, sc, dr, dc, visited);

        return 1;
    }
}
