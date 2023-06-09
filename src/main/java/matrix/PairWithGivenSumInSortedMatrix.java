package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairWithGivenSumInSortedMatrix {
    public static void main(String[] args) {
        int[][] mat1= {{1,5,6}, {8,10,11}, {15,16,18}};
        int[][] mat2= {{2, 4, 7}, {9,10,12}, {13,16,20}};
        int k = 21;
        List<List<Integer>> pairs = new ArrayList<>();
        for(int i=0; i<mat2.length; i++){
            for(int j=0; j<mat2[0].length; j++){
                int v = k-mat2[i][j];
                boolean b = pair(0, (mat1.length * mat1[0].length)-1, mat1, mat1.length, mat1[0].length, v);
                if(b) pairs.add(Arrays.asList(v, mat2[i][j]));
            }
        }
        System.out.println(pairs);
    }

    private static boolean pair(int start, int end, int[][] mat, int rlen, int clen, int k){
        if(start>=end) return false;
        int mid = (start + end)/2;
        int row = mid/rlen;
        int col = mid%clen;

        if(mat[row][col] == k){
            return true;
        }

        if(mat[row][col]>k){
            return pair(start, mid, mat, rlen, clen, k);
        }
        return pair(mid+1, end, mat, rlen, clen, k);
    }
}
