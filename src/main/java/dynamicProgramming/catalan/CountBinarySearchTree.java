package dynamicProgramming.catalan;

public class CountBinarySearchTree {
    public static void main(String[] args) {
        int n  = 3;
        int[] dp = CatalanNumber.catalanNumber(n);
        System.out.println(dp[n]);
    }
}
/**
 *   n = 3 [10, 20, 30]
 *   n=0 []      = 1
 *   n=1 [10]    = 1
 *   n=2 [10,20] = 2
 *
 *        10                  20            30
 *       / \                /   \          /  \
 *      n  [20,30]       [10]  [30]    [10,20] n
 *
 *  for 10 ;  left = 1, right = 2 = 1*2 = 2
 *  for 20; left = 1, right = 1 = 1*1 = 1
 *  for 30; left = 2, right = 1 = 2*1 = 2
 *
 *  total n=3 ;  1*2 + 1*1 + 2*1 = 5
 *
 *  n=4 = 14
 *  ....catalan number[1,1,5,14]
 */
