package graphs.disjointset;

import javafx.util.Pair;
import matrix.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIsland2 {
    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] sea = Util.getMatrix(n, m, 0);
        List<Pair<Integer, Integer>> sourceDest = getQueries();

        int[] noOfIslands = findNumberOfIsland(sea, sourceDest, n, m);
        Arrays.stream(noOfIslands).forEach(v-> System.out.print(v+" "));
    }

    private static int[] findNumberOfIsland(int[][] sea, List<Pair<Integer, Integer>> sourceDestPair, int n, int m){
        int[] noOfIsland = new int[n*m];

        int islandCount = 0;
        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        DisjointSet set = new DisjointSet(n * m);
        for(int i=0; i<sourceDestPair.size(); i++){
            Pair<Integer, Integer> pair = sourceDestPair.get(i);
            int r = pair.getKey();
            int c = pair.getValue();
            if(sea[r][c] == 1){
                noOfIsland[i] = islandCount;
                continue;
            }
            else{
                sea[r][c] = 1;
                islandCount++;

                for(int j=0; j<4; j++){
                    int newRow = r+row[j];
                    int newCol = c+col[j];

                    if(newRow >=0 && newCol >= 0 && newRow < n && newCol < m){
                        if(sea[newRow][newCol] == 1){
                            int cNode = r * m + c;
                            int adjNode = newRow * m + newCol;
                            if(set.findUParent(cNode) != set.findUParent(adjNode)){
                                set.unionByRank(cNode, adjNode);
                                islandCount--;
                            }
                        }
                    }
                }
                noOfIsland[i] = islandCount;
            }
        }

        return noOfIsland;
    }

    private static List<Pair<Integer, Integer>> getQueries() {
        List<Pair<Integer, Integer>> queries = new ArrayList<>();
        queries.add(new Pair<>(0, 0));
        queries.add(new Pair<>(0, 0));
        queries.add(new Pair<>(1, 1));
        queries.add(new Pair<>(1, 0));
        queries.add(new Pair<>(0, 1));
        queries.add(new Pair<>(0, 3));
        queries.add(new Pair<>(1, 3));
        queries.add(new Pair<>(0, 4));
        queries.add(new Pair<>(3, 2));
        queries.add(new Pair<>(2, 2));
        queries.add(new Pair<>(1, 2));
        queries.add(new Pair<>(0, 2));

        return queries;
    }
}
