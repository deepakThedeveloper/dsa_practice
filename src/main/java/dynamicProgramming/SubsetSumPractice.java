package dynamicProgramming;

public class SubsetSumPractice {
    public static void main(String[] args)
    {
        int n = 4;
        int a[] = { 1, 2, 3, 4};
        int sum = 6;
        int tab[][] = new int[n + 1][sum + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                tab[i][j] = -1;
            }
        }
       // tab[0][0] = -1;
        if (subsetSum(a, n, sum, tab, 0) != 0) {
            System.out.println("YES\n");
        }
        else
            System.out.println("NO\n");
    }

    static int subsetSum(int[] a, int n, int sum, int[][] tab, int i)
    {
        if (sum == 0) return 1;
        if (n == i || sum <0) return 0;
        if (tab[i][sum] != -1) return tab[i][sum];

        int l1 = subsetSum(a, n, sum - a[i], tab, i+1);
        int l2 = subsetSum(a, n, sum, tab, i+1);
        if (l1 != 0 || l2 != 0) {
            tab[i][sum] = 1;
        }
        else {
            tab[i][sum] = 0;
        }
        return tab[i][sum];
    }
}
