package arrays;

public class MissingAndRepeatingNumber {
    public static void main(String[] args){
        int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
        int[] ans = findMissingRepeatingNumbersOptimized(a);
        System.out.println("The repeating and missing numbers optimized approach are: {"
                + ans[0] + ", " + ans[1] + "}");

        int[] ans1 = findMissingRepeatingNumbersBetterApproach(a);
        System.out.println("The repeating and missing numbers better approach are: {"
                + ans1[0] + ", " + ans1[1] + "}");

        int[] ans2 = findMissingRepeatingNumbersBruteForce(a);
        System.out.println("The repeating and missing numbers brute force approach are: {"
                + ans2[0] + ", " + ans2[1] + "}");
    }

    // refer striver a2z dsa playlist
    public static int[] findMissingRepeatingNumbersOptimized(int[] a) {
        long n = a.length; // size of the array
        // Find Sn and S2n:
        long SN = (n * (n + 1)) / 2;
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        // Calculate S and S2:
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += a[i];
            S2 += (long)a[i] * (long)a[i];
        }

        //S-Sn = X-Y:
        long val1 = S - SN;

        // S2-S2n = X^2-Y^2:
        long val2 = S2 - S2N;

        //Find X+Y = (X^2-Y^2)/(X-Y):
        val2 = val2 / val1;

        //Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
        // Here, X-Y = val1 and X+Y = val2:
        long x = (val1 + val2) / 2;
        long y = x - val1;

        // int[] ans = {(int)x, (int)y};
        return new int[]{(int)x, (int)y};
    }

    //tc: O(n)+O(n)  sc:O(n)
    public static int[] findMissingRepeatingNumbersBetterApproach(int []a) {
        int n = a.length;
        int[] result = new int[2];
        int[] hash = new int[n+1];
        for(int i=0; i<n; i++){
            hash[a[i]]++;
        }

        for(int i=1; i<=n; i++){
            if(hash[i] == 0) result[1] = i;
            else if(hash[i]>1) result[0] = i;
        }
        return result;
    }

    //tc: O(n2)
    public static int[] findMissingRepeatingNumbersBruteForce(int []a) {
        boolean isMissing;
        int n = a.length, count = 0;
        int[] result = new int[2];
        for(int i=1; i<=n; i++){
            isMissing = true;
            count = 0;
            for(int j=0; j<n; j++){
                if(a[j] == i){
                    count++;
                    isMissing = false;
                }
            }
            if(count > 1)result[0] = i;
            else if(isMissing)result[1] = i;
        }
        return result;
    }
}
