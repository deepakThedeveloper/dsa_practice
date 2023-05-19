package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfZeros {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(2,2);
        List<Integer> list2 = Arrays.asList(1,0);
        List<Integer> list3 = Arrays.asList(0,1);

        List<List<Integer>> mati = Arrays.asList(list1, list2, list3);
        int count = coverageOfMatrix(mati);
        System.out.println(count);

    }
    public static Integer coverageOfMatrix(List<List<Integer>> mati) {
        int rLength = mati.size();
        int cLength = mati.get(0).size();

        int[][] mat = getMatrix(mati);
        int count =0;
        for(int row=0; row<rLength; row++){
            for(int col=0; col<cLength; col++){
                if(mat[row][col]==0){
                    if((row!=0) && (mat[row-1][col]==1)) count++;
                    if(col!=0 && mat[row][col-1]==1) count++;
                    if(col<cLength-1 && mat[row][col+1]==1) count++;
                    if(row<rLength-1 && mat[row+1][col]==1) count++;
                }
            }
        }
        return count;
    }
    private static int[][] getMatrix(List<List<Integer>> mat){
        int rLength = mat.size();
        int cLength = mat.get(0).size();

        int[][] matrix = new int[rLength][cLength];
        for(int i=0; i<rLength; i++){
            for(int j=0; j<cLength; j++){
                matrix[i][j] = mat.get(i).get(j);
            }
        }
        return matrix;
    }
}
