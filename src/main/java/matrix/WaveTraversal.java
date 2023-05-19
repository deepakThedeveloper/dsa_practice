package matrix;

public class WaveTraversal {
    public static void main(String[] args) {
        int[][] b = {{10,1,1,1}, {20,1,1,1}, {3,2,0,7}};

        printElementsByWaveTraversal(b, b.length, b[0].length);
        System.out.println();
        waveTraverseRevision1(b, b.length, b[0].length);
    }

    private static void waveTraverseRevision1(int[][] mat, int rLen, int cLen){
        boolean tTB = true;
        for(int c=0; c<cLen; c++) {
            if(tTB) {
                for (int r = 0; r < rLen; r++) {
                    System.out.print(mat[r][c]+" ");
                }
                tTB = false;
            }
            else {
                for (int r = rLen-1; r >= 0; r--) {
                    System.out.print(mat[r][c]+" ");
                }
                tTB = true;
            }
            System.out.println();
        }
    }

    private static void printElementsByWaveTraversal(int[][] b, int rows, int cols) {
        for(int i=0; i<cols;i++){
            if(i%2==0){
                for(int j=0; j<rows; j++){
                    System.out.print(b[j][i]+" ");
                }
            }
            else{
                for(int j=rows-1; j>=0; j--){
                    System.out.print(b[j][i]+" ");
                }
            }
        }
    }
}
