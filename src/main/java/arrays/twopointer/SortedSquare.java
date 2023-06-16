package arrays.twopointer;

public class SortedSquare {
    public static void main(String[] args){
        int[] nums = {-4,-1,0,3,10};
        int[] sortedSquares = sortedSquares(nums);
        System.out.println(sortedSquares);
    }

    // leetcode verified https://leetcode.com/problems/squares-of-a-sorted-array/description/
    public static int[] sortedSquares(int[] a) {
        int pos = -1, neg = -1;
        int n = a.length;

        int[] square = new int[n];
        for(int i=0, j=n-1, k=n-1; i<=j; k--){
            int square1 = a[i] * a[i];
            int square2 = a[j] * a[j];
            if(square1 > square2){
                square[k] = square1;
                i++;
            }
            else{
                square[k] = square2;
                j--;
            }
        }

        return square;
    }
}
