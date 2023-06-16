package recursion.subset.partition;

public class MinimumPalindromePartitioning {
    public static void main(String[] args) {
        char[] c = {'b','a','b','a','b','c','b','a','d','c','e','d','e'};
        int minPartition = minPartition(c, 0, c.length);
        System.out.println(minPartition-1);
    }

    private static int minPartition(char[] a, int idx, int n){
        if(idx==n) return 0;
        int min = Integer.MAX_VALUE;
        for(int i=idx; i<n; i++){
            if(isPalindrome(a, idx, i)){
                min = Math.min(min, 1+minPartition(a, i+1, n));
            }
        }
        return min;
    }

    private static boolean isPalindrome(char[] a, int start, int end){
        int i = start, j=end;
        while (start<end){
            if(a[start]!=a[end]) return false;
            start++;
            end--;
        }
        if(i == 0){
        }
        return true;
    }
}
