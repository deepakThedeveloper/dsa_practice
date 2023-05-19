package matrix;

public class SymmetricMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{2,4,5},{3,5,8}};
        boolean isSymmetric = isMatrixSymmetric(matrix);
        System.out.println(isSymmetric);
    }
    public static boolean isMatrixSymmetric(int[][] m) {

        for(int r=0; r<m.length; r++){
            for(int c=r; c<m[0].length; c++){
                if(m[r][c] != m[c][r]) return false;
            }
        }
        return true;
    }
}
