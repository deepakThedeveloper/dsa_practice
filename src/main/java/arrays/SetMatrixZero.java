package arrays;

import matrix.Util;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {{1,0}, {2,7},{3,0},{4,8}};
        setZeros(matrix);
        Util.printMatrix(matrix);
    }
    public static void setZeros(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int col0 = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){
                    if(j!=0) matrix[0][j] = 0;
                    else col0 = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>0; j--){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(col0 == 0) matrix[i][0] = 0;
        }
    }
}
