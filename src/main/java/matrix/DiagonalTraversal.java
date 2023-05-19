package matrix;

public class DiagonalTraversal {
    public static void main(String[] args) {
        int[][] a = {{1,2,3,4,5,6}, {11,12,13,14,15,16}, {21,22,23,24,25,26}, {31,32,33,34,35,36}, {41,42,43,44,45,46}};
        Util.printMatrix(a);
        System.out.println();
        diagonalPrint(a, a.length, a[0].length);
    }
    private static void diagonalPrint(int[][] a, int rlen, int clen) {
        int idx = -1;
        for (int i = 0; i < rlen; i++) {
            idx++;
            for (int r = 0, c = idx; r < rlen && c < clen; r++, c++) {
                System.out.print(a[r][c]+", ");
            }
            System.out.println();
        }
    }
}
