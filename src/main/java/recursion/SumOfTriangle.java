package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SumOfTriangle {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        List<List<Integer>> intList = printSumInTriangle(a, 0);
        intList.forEach(System.out::println);
    }

    private static List<List<Integer>> printSumInTriangle(int[] a, int n) {
        if(n==a.length){
            List<List<Integer>> intList = new ArrayList<>();
            List<Integer> subList = new ArrayList<>();
            intList.add(subList);
            return intList;
        }

        List<List<Integer>> list =  printSumInTriangle(a, n+1);

        list.get(0).add(a[n]);
        for(int i=1; i<list.size(); i++){
            List<Integer> curr = list.get(i);
            List<Integer> prev = list.get(i-1);
            int sum = prev.get(prev.size()-1)+prev.get(prev.size()-2);
            curr.add(sum);
        }

        List<Integer> list2 = new ArrayList<>();

        List<Integer> integers = list.get(list.size()-1);
        for(int i=0, j=1; j<integers.size(); i++, j++){
            int sum = integers.get(i)+integers.get(j);
            list2.add(sum);
        }
        list.add(list2);
        return list;
    }
}
