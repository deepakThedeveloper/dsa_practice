package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3 types of questions
 * 1. given row and col and need to find exact value from that location
 * 2. given row. need to print that row
 * 3. given n. need to print complete pascals triangle till n
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        int r = 7, c = 5;
        int val = printValueOfCell(r, c);
        System.out.println(val);

        int[] values = printValuesForRow(r);
        Arrays.stream(values).forEach(v->System.out.print(v+" "));
        System.out.println();

        List<int[]> pascalTriangle = getPascalTriangleTill(r);
        for(int[] rowVal : pascalTriangle){
            Arrays.stream(rowVal).forEach(v->System.out.print(v+" "));
            System.out.println();
        }
    }

    private static List<int[]> getPascalTriangleTill(int r){
        List<int[]> result = new ArrayList<>();
        for(int i=1; i<=r; i++){
            result.add(printValuesForRow(i));
        }
        return result;
    }
    /**
     * row = no of elements
     * ignore 1st and nth element because those will be 1
     * consider column in row as zero based indexing.
     * formula: ans * (row-col)/col
     */
    private static int[] printValuesForRow(int row){
        int[] result = new int[row];
        result[0] = result[row-1] = 1;
        int ans = 1;
        for(int i=1; i<row-1; i++){
            ans =  ans * (row - i) / i;
            result[i] = ans;
        }
        return result;
    }

    // every value in pascals triangle comes under nCr combination.
    private static int printValueOfCell(int row, int col){
        row = row-1;
        col = col-1;
        // now we need to find rowCcol = row!/col! * (row-col)! e.g.: 7C3 = 7!/3!*4!. 4 gets cutoff so remaining is
        // 7*6*5/3*2*1   i.e. the value in col will be equal to that many multiplication in numerator

        int res = 1;
        for(int i=0; i<col; i++){
            // 7/1, 6/2, 5/3
            res = res * (row-i);
            res = res / (i+1);
        }
        return res;
    }

    private static List<Integer> printStar(int s, int k1, List<Integer> prevVal) {
        int i1=0;
        int j1 = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=k1-s; i>0;i--){
            System.out.print(" ");
        }
        for(int k = 0; k<s; k++){
            if(k==0 || k==s-1){
                System.out.print("1 ");
                list.add(1);
            }
            else{
                i1 = j1;
                j1 = i1+1;
                int val = prevVal.get(i1)+prevVal.get(j1);
                list.add(val);
                System.out.print(val+" ");
            }
        }
        for(int i=k1-s; i>0;i--){
            System.out.print(" ");
        }
        return list;
    }
}
