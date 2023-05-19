package matrix;

//TODO
public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] a = {{10,0,0}, {0,1,20}};
        int[][] b = {{10,1,1,1}, {20,1,1,1}, {3,2,0,7}};

        int[][] c = multiplyMatrix(a, b);
    }

    private static int[][] multiplyMatrix(int[][] a, int[][] b) {
        int aRows = a.length;
        int aCols = a[0].length;
        int bRows = b.length;
        int bCols = b[0].length;

        if (aCols != bRows) throw new RuntimeException("Invalid operation");

        int[][] c = new int[aRows][bCols];


        for (int k = 0; k < aRows; k++) {
            for (int m = 0; m < bCols; m++) {
                c[k][m] = getValue(a, b, k, m, aRows, bCols);
            }
        }
        return c;
    }
    private static int getValue(int[][] a, int[][] b, int i, int j, int aRows, int bCols){
        /*int sum = 0;
        for(int j=0;j<aCols; j++){
            sum += a[i][j] * b[j][i];
        }*/
        return 0;
    }
}
