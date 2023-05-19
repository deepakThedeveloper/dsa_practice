package backtracking;

import java.util.ArrayList;
import java.util.List;

public class MinSubsetDiff {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};

        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();
        getMinSubsetDiff(arr, 0, 0, 0, set1, set2);
        System.out.println(minDiff);
    }

    static int minDiff = Integer.MAX_VALUE;
    private static void getMinSubsetDiff(int[] a, int sum1, int sum2, int i,
                                         List<Integer> set1,  List<Integer> set2){

        if(i==a.length){
            int diff = Math.abs(sum1 - sum2);
            System.out.print(set1+" ");
            System.out.print(set2+" ");
            System.out.print(diff+" ");
            System.out.println();
            if(diff<minDiff){
                minDiff = diff;

            }
            return;
        }

        if(set1.size() < (a.length+1)/2) {
            set1.add(a[i]);
            getMinSubsetDiff(a, sum1 + a[i], sum2, i + 1, set1, set2);
            set1.remove(set1.size() - 1);
        }
        if(set2.size() < (a.length+1)/2) {
            set2.add(a[i]);
            getMinSubsetDiff(a, sum1, sum2 + a[i], i + 1, set1, set2);
            set2.remove(set2.size() - 1);
        }
    }
}
