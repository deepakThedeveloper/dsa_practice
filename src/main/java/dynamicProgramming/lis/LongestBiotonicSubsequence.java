package dynamicProgramming.lis;

import java.util.Arrays;

//1,2,10,4,5,1 - is biotonic. //1,2,3,4,5,6 or 6,5,4,3,2,1 - is also biotonic
public class LongestBiotonicSubsequence {
    public static void main(String[] args) {
       // int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] a = {1,11,2,10,4,5,2,1};

        int max = longestBiotonicSubsequenceTabulation(a);
        System.out.println("max length:"+max);
    }

    private static int longestBiotonicSubsequenceTabulation(int[] a){
        int[] leftLIS = biotonicFromLeft(a);
        int[] rightLIS = biotonicFromRight(a);

        int max = 1;
        for(int i=0; i<leftLIS.length; i++){
            max = Math.max(max, leftLIS[i]+rightLIS[i]-1);
        }
        return max;
    }

    private static int[] biotonicFromLeft(int[] a){
        int[] count = new int[a.length];
        Arrays.fill(count, 1);
        for(int i=0; i<a.length; i++){
            for(int j=0; j<i; j++){
                if(a[i]>a[j] && 1+count[j] > count[i]){
                    count[i] = 1+count[j];
                }
            }
        }
        return count;
    }
    private static int[] biotonicFromRight(int[] a){
        int[] count = new int[a.length];
        Arrays.fill(count, 1);
        for(int i=a.length-1; i>=0; i--){
            for(int j= a.length-1; j>i; j--){
                if(a[i]>a[j] && 1+count[j] > count[i]){
                    count[i] = 1+count[j];
                }
            }
        }
        return count;
    }
}
