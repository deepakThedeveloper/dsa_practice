package trees.bst;

import trees.BinaryTreeNode;
import trees.BinaryTreePrinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueBSTCount {
    public static void main(String[] args) {
        int count = test(3, new HashMap<>());
        System.out.println("count:"+count);
    }

    private static int test(int n, Map<Integer, Integer> dp){
        if(n==0 || n==1) {
            return 1;
        }
        if(dp.containsKey(n)) return dp.get(n);
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += test(i-1, dp) * test(n-i, dp);
        }
        dp.put(n, sum);
        return sum;
    }
}
