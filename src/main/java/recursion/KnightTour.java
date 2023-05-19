package recursion;

public class KnightTour {
    public static void main(String[] args) {
        int[][] mat = new int[5][5];
        boolean[][] visited = new boolean[5][5];
        knightTour(mat, 2, 3, visited, "", 0);
    }

    private static void knightTour(int[][] mat, int sr, int sc, boolean[][] visited, String op, int visit){
        if(sr>=mat.length || sc>=mat[0].length || sr<0 || sc<0 || visited[sr][sc]) return;
        if(visit == mat.length * mat[0].length){
            System.out.println("in if");
            System.out.println(op);
            return;
        }

        visited[sr][sc]=true;
        knightTour(mat, sr-2, sc+1, visited, op+"U2R1, ", visit+1);
        knightTour(mat, sr-1, sc+2, visited, op+"U1R2, ", visit+1);
        knightTour(mat, sr+1, sc+2, visited, op+"D1R2, ", visit+1);
        knightTour(mat, sr+2, sc+1, visited, op+"D2R1, ", visit+1);
        knightTour(mat, sr+2, sc-1, visited, op+"D2L1, ", visit+1);
        knightTour(mat, sr+1, sc-2, visited, op+"D1L2, ", visit+1);
        knightTour(mat, sr-1, sc-2, visited, op+"U1L2, ", visit+1);
        knightTour(mat, sr-2, sc-1, visited, op+"U2L1, ", visit+1);
        visited[sr][sc]=false;

    }
}
