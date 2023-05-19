package arrays;

import java.util.HashMap;

public class LongestSubarrayWithSumZero {
    public static void main(String[] args) {
        //int a[] = {9, -3, 3, -1, 6, -5};
        int a[] = {1,2,3,-2,-1};
       // int a[] = {6, -2, 2, -8, 1, 7, 4, -10};
        int len = maxLen(a, a.length);
        System.out.println("longest subarray with sum zero is:"+len);
    }
    static int maxLen(int A[], int n)
    {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        int maxi = 0;
        int sum = 0;
        for(int i = 0;i<n;i++) {
            sum += A[i];
            if(sum == 0) {
                maxi = i + 1;
            }
            else {
                if(mpp.get(sum) != null) {
                    maxi = Math.max(maxi, i - mpp.get(sum));
                }
                else {
                    mpp.put(sum, i);
                }
            }
        }
        return maxi;
    }
}
