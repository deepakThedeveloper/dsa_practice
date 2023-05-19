package arrays;

import java.util.HashSet;
import java.util.Set;

//https://www.codingninjas.com/codestudio/problems/first-missing-positive_699946?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] a = {3, 2, -6, 1, 0};
        int missingVal = firstMissing(a, a.length);
        System.out.println(missingVal);
    }
    public static int firstMissing(int[] arr, int n) {
        Set<Integer> map = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(max, arr[i]);
            map.add(arr[i]);
        }
        if(max<=0) return 1;
        for(int i=1; i<=max; i++){
            if(!map.contains(i)){
                return i;
            }
        }
        return max+1;
    }
}
