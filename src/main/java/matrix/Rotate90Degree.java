package matrix;

public class Rotate90Degree {
    public static void main(String[] args) {
        //int[][] a = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        int[][] a = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        System.out.println("before:----------------");
        printMatrix(a);

        rotateMatrixBy90Degree(a);
    }

    private static void printMatrix(int[][] a) {
        int r = a.length;
        int c = a[0].length;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void rotateMatrixBy90Degree(int[][] a) {
        int r = a.length;
        int c = a[0].length;

        a = transpose(a,r,c);
        System.out.println("after transpose:-----------");
        printMatrix(a);

        reverse(a,r,c);
        System.out.println("after reverse:-----------");
        printMatrix(a);

    }

    private static void reverse(int[][] a, int r, int c) {
        // reverse the columns. i.e. swap a[0][0] with a[0][c-1], a[0][1] with a[0][c-2] ....... for all rows
        int m;
        for(int i=0; i<r; i++){
            m=c-1;
            for(int j=0; j<m; j++){
                int temp = a[i][j];
                a[i][j] = a[i][m];
                a[i][m] = temp;
                m--;
            }
        }
    }

    private static int[][] transpose(int[][] a, int r, int c) {
        //transpose the matrix. transpose means rows becomes column and column becomes rows
        for(int i=0; i<r; i++){
            for(int j=i; j<c; j++){
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        return a;
    }

}
