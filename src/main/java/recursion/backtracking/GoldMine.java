package recursion.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GoldMine {
    public static void main(String[] args) {
        int[][] mine = {{10,0,100,200,0,8,0}, {20,0,0,0,0,6,0}, {30, 0, 0, 9,12,3,4}, {4, 0, 2, 5, 8, 3, 11}, {0,0,0,0,0,9,0},
                {5,6,7,0,7,4,2}, {8,9,10,0,1,10,8}};

        int r = mine.length;
        int c = mine[0].length;

        Set<String> visited = new HashSet<>();
        int maxProfit = Integer.MIN_VALUE;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(visited.contains(""+i+j) || mine[i][j]==0) continue;
                List<Integer> bag = new ArrayList<>();
                getCollectedGold(mine, visited, i,j,bag);

                int sum = 0;
                for(int val : bag){
                    sum += val;
                }
                maxProfit = Math.max(sum, maxProfit);
            }
        }
        System.out.println(maxProfit);

    }

    private static void getCollectedGold(int[][] mine, Set<String> visited, int r, int c, List<Integer> bag){
        if(r<0 || c<0 || r==mine.length || c==mine[0].length || mine[r][c] == 0 || visited.contains(""+r+c)){
            return;
        }
        visited.add(""+r+c);
        bag.add(mine[r][c]);
        getCollectedGold(mine, visited, r, c + 1, bag);
        getCollectedGold(mine, visited, r, c - 1, bag);
        getCollectedGold(mine, visited, r + 1, c, bag);
        getCollectedGold(mine, visited, r-1, c, bag);
    }
}
