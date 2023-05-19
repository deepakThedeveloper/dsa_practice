package arrays;

import java.util.Arrays;

public class CountTriplets {
    public static void main(String[] args) {
        int[] arr = {1,5,3,2};

        int count = countTriplets(arr);
        System.out.println("total triplets:"+count);
    }

    private static int countTriplets(int[] arr) {
        Arrays.sort(arr);
       /* int n = arr.length;
        int j=n-2;
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j = n-2; j>)
            int k = n-1;
            if(arr[i]+arr[j] == arr[k]){
             count++;
            }
        }*/
        return 0;
    }
}
