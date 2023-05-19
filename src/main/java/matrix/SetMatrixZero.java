package matrix;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {{7,9,13},{4,2,0}};
        setZeros(matrix);
        System.out.println(matrix);
    }
    public static void setZeros(int[][] matrix) {
        int rLength = matrix.length;
        int cLength = matrix[0].length;

        int[] row = new int[rLength];
        int[] col = new int[cLength];
        Arrays.fill(row, -1);
        Arrays.fill(col, -1);
        int idx = 0;
        for(int i=0; i<rLength; i++){
            for(int j=0; j<cLength; j++){
                if(matrix[i][j] == 0){
                    row[i] = i;
                    if(idx<cLength){
                        col[idx] = j;
                        idx++;
                    }
                }
            }
        }
        for(int i=0; i<row.length; i++){
            if(row[i] == -1) continue;
            for(int j=0; j<cLength; j++){
                matrix[row[i]][j] = 0;
            }
        }
        for(int i=0; i<col.length; i++){
            if(col[i]==-1) continue;
            for(int j=0; j<rLength; j++){
                matrix[j][col[i]] = 0;
            }
        }
    }
}
