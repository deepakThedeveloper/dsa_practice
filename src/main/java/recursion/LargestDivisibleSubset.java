package recursion;

import java.util.Arrays;

//striver dp-44
public class LargestDivisibleSubset {
    public static void main(String[] args) {
        // int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] a = {1,16,7,8,4,14,28,56,112,224};
        Arrays.sort(a);
        int lds = ldsApproach2OfLis(a);
        System.out.println("iteration lds:"+lds);
    }

    // better approach
    private static int ldsApproach2OfLis(int[] a){
        int[] count = new int[a.length];
        int[] hash = new int[a.length];
        System.out.println();
        Arrays.fill(count, 1);
        int max = 1, maxIndex = 1;
        for(int i=0; i<a.length; i++){
            hash[i] = i;
            for(int j=0; j<i; j++){
                if(a[i]%a[j]==0 && 1+count[j] > count[i]){
                    count[i] = 1+count[j];
                    hash[i] = j;
                }
            }
            if(count[i]>max) {
                max = count[i];
                maxIndex = i;
            }
        }
        int i=maxIndex;
        while(i>0){
            System.out.print(a[i]+" ");
            i=hash[i];
        }
        System.out.print(a[i]+"\n ");
        return max;
    }
}
