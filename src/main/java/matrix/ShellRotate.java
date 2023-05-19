package matrix;

//rotate the layers, shell 1 means outer layer, shell 2 means inner layer, shell 3 means inner of inner layer like wise.
public class ShellRotate {
    public static void main(String[] args) {
        //int[][] a = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        int[][] a = {{1,2,3,4,5,6}, {11,12,13,14,15,16}, {21,22,23,24,25,26}, {31,32,33,34,35,36}, {41,42,43,44,45,46}};
        System.out.println("before:----------------");
        Util.printMatrix(a);

        shellRotate(a, a.length, a[0].length, 2, 1);
        System.out.println("after rotate-----------");
        Util.printMatrix(a);
    }

    private static void shellRotate(int[][] a, int r, int c, int shell, int rotation) {
        int[] oned = fillOnedFromMatrix(a, r, c, shell);
        rotate(oned, rotation);
        fillMatrixFromOned(a, r, c, oned, shell);
    }

    private static int[] fillOnedFromMatrix(int[][] a, int r, int c, int shell) {
        int minr = shell-1;
        int minc = shell-1;
        int maxr = r-shell;
        int maxc = c-shell;

        int sz = 2*(maxr - minr + maxc - minc);

        int[] oned = new int[sz];

        int idx = 0;
        for(int i = minr, j = minc; i<=maxr; i++){
            oned[idx] = a[i][j];
            idx++;
        }

        for(int i = maxr, j = minc+1; j<=maxc; j++){
            oned[idx] = a[i][j];
            idx++;
        }

        for(int i = maxr-1, j = maxc; i>=minr; i--){
            oned[idx] = a[i][j];
            idx++;
        }

        for(int i = minr, j = maxc-1; j>minc; j--){
            oned[idx] = a[i][j];
            idx++;
        }

        return oned;
    }

    private static void rotate(int[] oned, int rotation) {
        int sz = oned.length;

        int m = sz - rotation;
        reverseOned(oned, 0, m-1);
        reverseOned(oned, m, sz-1);
        reverseOned(oned, 0, sz-1);
    }


    private static void fillMatrixFromOned(int[][] a, int r, int c, int[] oned, int shell) {
        int minr = shell-1;
        int minc = shell-1;
        int maxr = r-shell;
        int maxc = c-shell;

        int idx = 0;
        for(int i = minr, j = minc; i<=maxr; i++){
            a[i][j] = oned[idx];
            idx++;
        }

        for(int i = maxr, j = minc+1; j<=maxc; j++){
            a[i][j] = oned[idx];
            idx++;
        }

        for(int i = maxr-1, j = maxc; i>=minr; i--){
            a[i][j] = oned[idx];
            idx++;
        }

        for(int i = minr, j = maxc-1; j>minc; j--){
            a[i][j] = oned[idx];
            idx++;
        }
    }

    private static void reverseOned(int[] oned, int i, int j) {
        while(i<j){
            int temp = oned[i];
            oned[i] = oned[j];
            oned[j] = temp;
            i++;
            j--;
        }
    }
}
