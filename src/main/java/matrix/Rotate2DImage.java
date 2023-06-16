package matrix;

import matrix.Util;

public class Rotate2DImage {
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        System.out.println("before");
        Util.printMatrix(matrix);

        rotate(matrix);
        System.out.println("after");
        Util.printMatrix(matrix);

    }

    public static void rotate(int[][] matrix) {
        transpose(matrix);
        swap(matrix);
    }

    private static void swap(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0, col = matrix.length-1; j<col; j++, col--){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][col];
                matrix[i][col] = temp;
            }
        }
    }

    private static void transpose(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=i+1; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

}
