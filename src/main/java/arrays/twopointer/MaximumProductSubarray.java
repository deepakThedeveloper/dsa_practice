package arrays.twopointer;

// array will contain 0, +ve and -ve integer. return max subarray length whose product is max
public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] a = {2, 3, 0, -2, 4, -6, 3, 0, 5, -2, 0, 3};

        int prefix = 1, suffix = 1;
        int n = a.length, max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(a[i] == 0){
                prefix = 1;
                continue;
            }
            prefix = prefix * a[i];

            max = Math.max(max, prefix);
        }
        for(int j=n-1; j>=0; j--){
            if(a[j] == 0){
                suffix = 1;
                continue;
            }
            suffix = suffix * a[j];

            max = Math.max(max, suffix);
        }
        System.out.println("max:"+max);
    }
}
