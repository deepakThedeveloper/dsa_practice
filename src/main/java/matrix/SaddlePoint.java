package matrix;

//Point which is smaller in the row and bigger in the col. there can be only one saddle point in matrix
public class SaddlePoint {
    public static void main(String[] args) {
        int[][] b = {{4,3,2,6}, {6,4,12,7}, {12,5,11,9}, {11,10,12,13}};

        int point = findSaddlePoint(b, b.length-1, b[0].length-1);
        System.out.println("saddle point:"+point);
    }

    private static int findSaddlePoint(int[][] a, int r, int c) {
        int sm = Integer.MAX_VALUE;
        int idx = -1;
        boolean found;
        for(int k=0; k<=r; k++) {
            found = true;
            sm = Integer.MAX_VALUE;
            for (int i = 0; i < c; i++) {
                if (a[k][i] < sm) {
                    sm = a[k][i];
                    idx = i;
                }
            }

            for (int i = 0; i <=r; i++) {
                if (sm < a[i][idx]) {
                    found = false;
                    break;
                }
            }
            if(found) {
                System.out.println("point:"+sm+" idx:"+idx);
                return sm;
            }
        }
        return Integer.MIN_VALUE;
    }
}
