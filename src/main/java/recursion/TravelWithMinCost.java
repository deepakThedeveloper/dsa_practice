package recursion;

import lombok.AllArgsConstructor;
import lombok.ToString;
import matrix.Util;

@AllArgsConstructor
@ToString
class Path{
    String route;
    int cost;
}
public class TravelWithMinCost {
    public static void main(String[] args) {
        int[][] routeValues = {{3,0,1,3}, {1,2,5,2}, {1,1,4,0}, {1,1,0,1}};
        int[][] mat = Util.getMatrix(routeValues.length, routeValues[0].length, -1);
        int min = minCostRecursionReturn(routeValues, 0, 0, mat);
        System.out.println(min);
        Util.printMatrix(mat);

        int[][] mat1 = Util.getMatrix(routeValues.length, routeValues[0].length, -1);
        int min1 = minCostMemoization(routeValues, 0, 0, mat);
        System.out.println(min1);
        Util.printMatrix(mat);

//        int minCost = findMinCostTabulation(routeValues);
//        System.out.println(minCost);
    }

    private static int minCostRecursionReturn(int[][] a, int sr, int sc, int[][] mat){
        System.out.println("in method");
        if(sr>=a.length || sc>=a[0].length) return -1;

        if(sr==a.length-1 && sc==a[0].length-1) return a[sr][sc];

        int v1 = minCostRecursionReturn(a, sr, sc+1, mat);
        int v2 = minCostRecursionReturn(a, sr+1, sc, mat);
        int finalVal = a[sr][sc];

        if(v1==-1 && v2!=-1) finalVal+=v2;
        else if(v2==-1 && v1!=-1) finalVal+=v1;
        else if(v1!=-1 & v2!=-1) finalVal = Math.min(finalVal+v1, finalVal+v2);

        mat[sr][sc] = finalVal;
        return finalVal;
    }

    private static int minCostMemoization(int[][] a, int sr, int sc, int[][] mat){
        System.out.println("in method");
        if(sr>=a.length || sc>=a[0].length) return -1;

        if(sr==a.length-1 && sc==a[0].length-1) return a[sr][sc];

        if(mat[sr][sc]!=-1) return mat[sr][sc];
        int v1 = minCostMemoization(a, sr, sc+1, mat);
        int v2 = minCostMemoization(a, sr+1, sc, mat);
        int finalVal = a[sr][sc];

        if(v1==-1 && v2!=-1) finalVal+=v2;
        else if(v2==-1 && v1!=-1) finalVal+=v1;
        else if(v1!=-1 & v2!=-1) finalVal = Math.min(finalVal+v1, finalVal+v2);

        mat[sr][sc] = finalVal;
        return finalVal;
    }

    //todo: to be tested
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
}
