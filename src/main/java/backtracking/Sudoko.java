package backtracking;

import java.util.*;
/*
3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9
 */
public class Sudoko {
    public static void main(String[] args) {
        int[][] sudoku = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        List<Set<Integer>> rowData = new ArrayList<>();
        List<Set<Integer>> colData = new ArrayList<>();

        for(int r=0; r<sudoku.length; r++){
            Set<Integer> set = new HashSet<>();
            for(int c=0; c<sudoku.length; c++){
                if(sudoku[r][c]!=0) {
                    set.add(sudoku[r][c]);
                }
            }
            rowData.add(set);
        }

        for(int c=0; c<sudoku.length; c++){
            Set<Integer> set = new HashSet<>();
            for(int r=0; r<sudoku.length; r++){
                if(sudoku[r][c]!=0) {
                    set.add(sudoku[r][c]);
                }
            }
            colData.add(set);
        }

        solveSudoku(sudoku, 0,0,rowData, colData);
        //printMatrix(sudoku);
    }

    private static void printMatrix(int[][] sudoku) {
        for(int i=0; i<sudoku.length; i++){
            for (int j=0; j<sudoku.length; j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void solveSudoku(int[][] sudoku, int r, int c, List<Set<Integer>> rowValues, List<Set<Integer>> colValues) {
        if(r==sudoku.length){
            printMatrix(sudoku);
           return;
       }
       int ni = 0;
       int nj = 0;
       if(c == sudoku.length-1){
         ni = r+1;
         nj = 0;
       }
       else{
           ni =  r;
           nj = c+1;
       }
       if(sudoku[r][c]!=0){
           solveSudoku(sudoku, ni, nj, rowValues, colValues);
       }
       else{
           for(int i = 1; i<=9; i++) {
               if (!rowValues.get(r).contains(i) && !colValues.get(c).contains(i) && isValid(sudoku, r, c, i)) {
                    sudoku[r][c] = i;
                    rowValues.get(r).add(i);
                    colValues.get(c).add(i);
                    solveSudoku(sudoku, ni, nj, rowValues, colValues);
                    sudoku[r][c] = 0;
                    rowValues.get(r).remove(i);
                    colValues.get(c).remove(i);
               }
           }
       }
    }

    private static boolean isValid(int[][] sudoku, int r, int c, int pos){
        int subMatrixR = r/3 *3;
        int subMatrixC = c/3 *3;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(sudoku[subMatrixR+i][c=subMatrixC+j] == pos){
                    return false;
                }
            }
        }
        return true;
    }
}
