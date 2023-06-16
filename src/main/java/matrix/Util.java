package matrix;

import java.util.HashMap;
import java.util.Map;

public class Util {
    public static <T>void printMatrix(T[][] a) {
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

    public static void printMatrix(int[][] a) {
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

    public static void printMatrix(boolean[][] a) {
        int r = a.length;
        int c = a[0].length;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int v  = a[i][j] ? 1 : 0;
                System.out.print(v+"   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] getMatrix(int r, int c, int v){
        int[][] mat = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                mat[i][j]=v;
            }
        }
        return mat;
    }

    public static int[][] getTriangleMatrix(int[][] mat) {
        int col = mat[mat.length-1].length;
        int[][] m1 = new int[mat.length][col];
        for(int i=0; i< m1.length; i++){
            for(int j=0; j < col; j++){
                m1[i][j] = 0;
            }
        }
        return m1;
    }

    public static int[][][] get3DMatrix(int i1, int j1, int j2) {
        int[][][] mat = new int[i1][j1][j2];
        for(int i=0; i<i1; i++){
            for(int j=0; j<j1; j++){
                for(int k=0; k<j2; k++) {
                    mat[i][j][k] = -1;
                }
            }
        }
        return mat;
    }

    public static int[][][] get3DMatrix(int i1, int j1, int j2, int v) {
        int[][][] mat = new int[i1][j1][j2];
        for(int i=0; i<i1; i++){
            for(int j=0; j<j1; j++){
                for(int k=0; k<j2; k++) {
                    mat[i][j][k] = v;
                }
            }
        }
        return mat;
    }

    public static Map<Character, Integer> freqMap(String s1){
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        return map;
    }

    public static int[][] createCopy(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] m1 = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                m1[i][j] = mat[i][j];
            }
        }
        return m1;
    }

    public static void printMatrix(char[][] a) {
        int r = a.length;
        int c = a[0].length;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                char v  = a[i][j];
                System.out.print(v+"   ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
