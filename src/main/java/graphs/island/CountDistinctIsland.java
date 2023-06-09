package graphs.island;

import javafx.util.Pair;

import java.util.*;

//island with same shape are considered duplicate and those with different shape are considered distinct
public class CountDistinctIsland {
    public static void main(String[] args) {
        int[][] mat = {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1}
        };

        int distinctIslandDFS = distinctIslandDFS(mat);
        System.out.println(distinctIslandDFS);

        int distinctIslandBFS = distinctIslandBFS(mat);
        System.out.println(distinctIslandBFS);
    }

    private static int distinctIslandBFS(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];
        Set<List<Integer>> island = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && mat[i][j]==1){
                    List<Integer> list = new ArrayList<>();
                    getIslandBFS(mat, i, j, visited, list, i, j);
                    island.add(list);
                }
            }
        }
        return island.size();
    }

    private static void getIslandBFS(int[][] mat, int sr, int sc, boolean[][] visited,
                                  List<Integer> list, int baseR, int baseC){
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(sr, sc));

        while(!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int i1 = pair.getKey();
            int j1 = pair.getValue();
            visited[i1][j1] = true;

            list.add(baseR - i1);
            list.add(baseC - j1);

            for (int i = 0; i < 4; i++) {
                int nr = i1 + row[i];
                int nc = j1 + col[i];
                if (nr >= 0 && nr < mat.length && nc >= 0 && nc < mat[0].length && !visited[nr][nc] && mat[nr][nc] == 1) {
                   queue.add(new Pair<>(nr, nc));
                }
            }
        }
    }

    private static int distinctIslandDFS(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];
        Set<List<Integer>> island = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && mat[i][j]==1){
                    List<Integer> list = new ArrayList<>();
                    getIsland(mat, i, j, visited, list, i, j);
                    island.add(list);
                }
            }
        }
        return island.size();
    }

    static int[] row = {-1,0,1,0};
    static int[] col = {0,1,0,-1};
    private static void getIsland(int[][] mat, int sr, int sc, boolean[][] visited,
                                  List<Integer> list, int baseR, int baseC){
        visited[sr][sc] = true;
        for(int i=0;i<4;i++){
            int nr = sr+row[i];
            int nc = sc+col[i];
            if(nr>=0 && nr<mat.length && nc>=0 && nc<mat[0].length && !visited[nr][nc] && mat[nr][nc]==1){
                list.add(nr-baseR);
                list.add(nc-baseC);
                getIsland(mat, nr, nc, visited, list, baseR, baseC);
            }
        }
    }
}
