package arrays;

import java.util.Stack;

//array of histograms each with different length but with same width 1 is present.
//There is no gap between any 2 histogram
//pblm: find the largest rectangle histogram, i.e. rectangle area. e.g. 2,5,4,5,1 - largest area is 12 . 4*3.
//soln: to solve this for each number we need left and right boundary. Boundary means smaller height than current histogram
public class LargestAreaHistogram {
    public static void main(String[] args) {
        int[] leftSmallBoundary;
        // in above array will get small index left and right to current number. then do
        // area = (([(currentNumIndex - rightIndex-1) + (currentNumIndex - leftIndex-1)]+1)*currentNum);
    }

    // similar to next greater number problem. only change is instead of next great number we need to find
    // next small number and save its index in array.
    private static int[] leftSmallBoundary(int[] histograms){
        Stack<Integer> stack =new Stack<>();
        return null;
    }
}
