package graphs;

import lombok.AllArgsConstructor;
import matrix.Util;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int[][] mat = {{1,1,1},{2,2,0},{2,2,2}};
        int newColour = 3;
        int sr  = 2, sc = 0;
        //fillWithSameColorDFS(mat, newColour, sr, sc);
        fillUsingBFS(mat, sr, sc, newColour);
    }

    private static void fillWithSameColorDFS(int[][] mat, int col, int sr, int sc){
        Util.printMatrix(mat);
        System.out.println("=========================================================");
        int n = mat.length;
        int m = mat[0].length;

        traverseAndFill(mat, new boolean[n][m], sr, sc, col, mat[sr][sc]);
        Util.printMatrix(mat);
    }

    private static void fillUsingBFS(int[][] mat, int sr, int sc, int col){
        int n = mat.length;
        int m = mat[0].length;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        boolean[][] visited = new boolean[n][m];

        visited[sr][sc] = true;
        int initColor = mat[sr][sc];
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int i = pair.i, j = pair.j;
            mat[i][j] = col;

            for(int r = -1; r<=1; r++){
                int newR = i+r;
                if(newR<0 || newR>=n || visited[newR][j] || mat[newR][j] != initColor) continue;
                visited[newR][j] = true;
                queue.add(new Pair(newR, j));
            }
            for(int c = -1; c<=1; c++){
                int newC = j+c;
                if(newC<0 || newC>=m || visited[i][newC] || mat[i][newC] != initColor) continue;
                visited[i][newC] = true;
                queue.add(new Pair(i, newC));
            }
        }
        System.out.println("==========================");
        Util.printMatrix(mat);
    }

    private static void traverseAndFill(int[][] mat, boolean[][] visited, int sr, int sc, int col, int initCol){
        if(sr<0 || sc<0 || sr>=mat.length || sc>=mat[0].length || visited[sr][sc] || mat[sr][sc] != initCol) return;

        visited[sr][sc] = true;
        mat[sr][sc] = col;
        traverseAndFill(mat, visited, sr, sc+1, col, initCol);
        traverseAndFill(mat, visited, sr, sc-1, col, initCol);
        traverseAndFill(mat, visited, sr+1, sc, col, initCol);
        traverseAndFill(mat, visited, sr-1, sc, col, initCol);
    }

    @AllArgsConstructor
    static class Pair{
        int i;
        int j;
    }
}
