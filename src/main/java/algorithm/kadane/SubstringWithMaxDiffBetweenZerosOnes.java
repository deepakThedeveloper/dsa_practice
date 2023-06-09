package algorithm.kadane;

// need to find such substring where difference between zeros and ones is maximium.
// we can use kadane's algo because it gives subarray with maximum sum. so, if in this problem,
// if we find subarray with max sum then that will be our answer but for applying kadane we need negative and positive val
// so we need to assign -1 to 1 and 1 to zero.
public class SubstringWithMaxDiffBetweenZerosOnes {
    public static void main(String[] args) {
        String str = "11000010001";
        int[] a = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            int v = str.charAt(i) - '0';
            a[i] = v == 1 ? -1 : 1;
        }
        //-1,-1,1,1,1,1,-1,1,1,1,-1
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<a.length; i++){
            if((sum+a[i]) > 0){
                sum += a[i];
                max = Math.max(sum, max);
            }
        }
        System.out.println("max difference = "+max);
    }
}
