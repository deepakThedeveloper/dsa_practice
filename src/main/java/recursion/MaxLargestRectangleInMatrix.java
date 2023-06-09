package recursion;

import stacks.todo.LargestHistogram;

public class MaxLargestRectangleInMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1,0,1,0,0}, {1,0,1,1,1}, {1,1,1,1,1},{1,0,0,1,0}};
        int maxArea = maxRectangle(mat);
        System.out.println(maxArea);
    }
    private static int maxRectangle(int[][] a){

        int[] histogram = new int[a[0].length];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                if(a[i][j]==1) histogram[j] +=1;
                else histogram[j] = 0;
            }
            max = Math.max(max, LargestHistogram.findMaxRectangleAreaInHistogram(histogram));
        }
        return max;
    }
}
