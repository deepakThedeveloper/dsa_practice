package binarysearch;

import javafx.util.Pair;

public class SearchElementInSortedMatrix {
    public static void main(String[] args){
        int[][] mat = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 45},
                {32, 33, 39, 50},
        };
        int ele = 23;
        Pair<Integer, Integer> pair = searchElementIterative(mat, ele);
        System.out.println(pair.getKey()+" "+pair.getValue());
    }

    public static Pair<Integer, Integer> searchElementIterative(int[][] mat, int ele){
        int r = mat.length, c = mat[0].length;
        int i = 0, j = c-1;
        while(i >= 0 && i < r && j >= 0 && j < c){
            if(mat[i][j] == ele){
                return new Pair<>(i, j);
            }
            else if(mat[i][j] > ele) j--;
            else i++;
        }
        return new Pair<>(-1, -1);
    }
}
