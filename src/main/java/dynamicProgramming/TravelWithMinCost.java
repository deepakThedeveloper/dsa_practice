package dynamicProgramming;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
class Path{
    String route;
    int cost;
}
public class TravelWithMinCost {
    public static void main(String[] args) {
        int[][] routeValues = {{3,0,1,3}, {1,2,5,2}, {1,1,4,0}, {1,1,0,1}};

/*
        Path path = getMinCostPathRecursion(routeValues, 0, 0, "s", 0);
        System.out.println(path);
*/
        int minCost = findMinCostTabulation(routeValues);
        System.out.println(minCost);
    }

    private static int findMinCostTabulation(int[][] routeValues) {
        int r = routeValues.length;
        int c = routeValues[0].length;
        int[][] dp = new int[r][c];

        for(int i = r-1; i>=0; i--){
            for(int j = c-1; j>=0; j--){
                dp[i][j] = getMin(dp, i, j, r, c) + routeValues[i][j];
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(dp[i][j]+",");
            }
            System.out.println();
        }
        return dp[0][0];
    }

    private static int getMin(int[][] val, int i, int j, int r, int c) {
        int min = Integer.MAX_VALUE;
        if(i+1<r && val[i+1][j] < min){
            min = val[i+1][j];
        }
        if(j+1<c && val[i][j+1] < min){
            min = val[i][j+1];
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    static int min = Integer.MAX_VALUE;
    static String route1 = "";
    private static Path getMinCostPathRecursion(int[][] routeValues, int sr, int sc, String route, int cost) {

        if(sr == routeValues.length || sc == routeValues[0].length){
            return new Path(route, cost);
        }
        if(sr == routeValues.length-1 && sc == routeValues[0].length-1){
            cost += routeValues[sr][sc];
            if(cost < min){
                min = cost;
                route1 = route;
            }
            return new Path(route1, min);
        }

        if(sr < routeValues.length){
            getMinCostPathRecursion(routeValues, sr+1, sc, route+"v", cost+routeValues[sr][sc]);
        }

        if(sc < routeValues[0].length) {
            getMinCostPathRecursion(routeValues, sr, sc + 1, route + "h", cost + routeValues[sr][sc]);
        }
        return new Path(route1, min);
    }
}
