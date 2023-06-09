package hashmap;

import java.util.Arrays;

// equals zero and one means difference between sum of zeros = sum of ones.
// think in this way: equals zeros and ones means if there are 10 zeros then there should be 10 ones i.e. total length = 20
//e.g.: 5 ones and 5 zeros = 10 ones and zeros.
// 1111100000 = 10 ones and zeros but if I try to find their sum it will be 5.
// if I somehow try to make their sum 0 then I can apply algorithm of max sum subarray with zero sum.
// in order to achieve it if I make 0's as -1 then 11111-1-1-1-1-1 = 5-5 = 0;
// NOTE: when equals is asked means their sum should be zero so somehow convert values sum to zero.
//e.g. in place of equals 0 and 1 if the question would be equals 1 and 2. then converting 2 with -1 would solve our problem
public class LongestSubarrayWithEquals0And1 {
    public static void main(String[] args) {
        int[] a = {0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1};

        int[] change = new int[a.length];
        for(int i=0; i<a.length; i++){
            change[i] = a[i] == 0 ? -1 : a[i];
        }
        Arrays.stream(change).forEach(v-> System.out.print(v+" "));
        System.out.println();
        int max = MaximumSubarrayWithSumZero.largestSubarrayWithZeroSum(change);
        System.out.println("max:"+max);
    }
}
