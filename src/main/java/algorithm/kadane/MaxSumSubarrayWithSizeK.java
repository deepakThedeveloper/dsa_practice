package algorithm.kadane;

public class MaxSumSubarrayWithSizeK {
    public static void main(String[] args) {

        int[] a = {2, 3, 1, -7, 6, -5, -4, 4, 3, 3, 2, -9, -5, 6, 1, 2, 1 , 1};
        int k = 4;
        int sum = 0, max;
        for(int i=0; i<k; i++){
            sum += a[i];
        }
        max = sum;
        int prev = a[0];
        for(int i = k, j = 0; i<a.length; i++, j++){
            sum += a[i]-a[j];
            int temp = sum + prev;
            max = Math.max(temp, max);
            prev = prev<0? a[j+1] : prev+a[j+1];
        }
        System.out.println("max:"+max);
    }
}
