package recursion;

import java.util.Arrays;
import java.util.Comparator;

// it again falls under LargestIncreasingSubsequence
public class LongestStringChain {
    public static void main(String[] args) {
        // int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        String[] a = {"bca","bda","a","b","ba","bcea","bdea","bdeaf"};
        Arrays.sort(a, Comparator.comparing(String::length));
        int lsc = lscApproach2OfLis(a);
        System.out.println("iteration lsc:"+lsc);
    }

    // better approach
    private static int lscApproach2OfLis(String[] a){
        int[] count = new int[a.length];
        System.out.println();
        Arrays.fill(count, 1);
        int max = 1;
        for(int i=0; i<a.length; i++){
            for(int j=0; j<i; j++){
                if(compare(a[i],a[j]) && 1+count[j] > count[i]){
                    count[i] = 1+count[j];
                }
            }
            max = Math.max(max, count[i]);
        }
        return max;
    }

    private static boolean compare(String s1, String s2){
        if(s1.length()!=s2.length()+1) return false;
        int first = 0, second = 0;
        while (second<s2.length()){
            if(Math.abs(second-first)>1)return false;
            if(s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }
            else {
                first++;
            }
        }
        return true;
    }
}
