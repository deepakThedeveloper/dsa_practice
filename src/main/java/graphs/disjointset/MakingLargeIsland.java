package graphs.disjointset;

import java.util.HashSet;

public class MakingLargeIsland {
    public static void main(String[] args) {
        int n = 6, m = 5;
        int[][] matrix = getQueries(n, m);
        int max = largeIslandSize(matrix);
        System.out.println("large island size:"+max);
    }

    private static int largeIslandSize(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        DisjointSet set = createDisjointSet(matrix);
        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};

        int size = 0, max = Integer.MIN_VALUE;
        System.out.println(set.getSize());
        HashSet<Integer> visitedParent = new HashSet<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                size = 0;
                if(matrix[i][j] == 0){
                    visitedParent.clear();
                    for(int k = 0; k<4; k++) {
                        int newR = i + row[k];
                        int newC = j + col[k];

                        if(newR >= 0 && newR < n && newC >= 0 && newC < m && matrix[newR][newC] == 1){
                            int adjNode = newR * m + newC;
                            int parent = set.findUParent(adjNode);
                            if(visitedParent.contains(parent)) continue;
                            visitedParent.add(parent);
                            size += set.getSize().get(parent);
                        }
                    }
                    size += 1;
                    max = Math.max(max, size);
                }
            }
        }
        return max;
    }

    private static DisjointSet createDisjointSet(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        DisjointSet set = new DisjointSet(n * m);
        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 1){
                    for(int k = 0; k<4; k++) {
                        int newR = i + row[k];
                        int newC = j + col[k];

                        if(newR >= 0 && newR < n && newC >= 0 && newC < m && matrix[newR][newC]==1){
                            int cNode = i * m + j;
                            int adjNode = newR * m + newC;
                            if(set.findUParent(cNode) != set.findUParent(adjNode)){
                                set.unionBySize(cNode, adjNode);
                            }
                        }
                    }
                }
            }
        }
        return set;
    }

    private static int[][] getQueries(int n, int m){
        int[][] mat = new int[n][m];
        mat[0][0] = 1;
        mat[0][1] = 1;
        mat[1][0] = 1;
        mat[1][1] = 1;
        mat[2][0] = 1;
        mat[2][1] = 1;
        mat[0][3] = 1;
        mat[0][4] = 1;
        mat[1][3] = 1;
        mat[1][4] = 1;
        mat[2][3] = 1;
        mat[2][4] = 1;
        mat[3][2] = 1;
        mat[4][2] = 1;
        mat[4][3] = 1;
        mat[4][4] = 1;
        mat[5][2] = 1;
        mat[5][3] = 1;
        mat[5][4] = 1;

        return mat;
    }
}
