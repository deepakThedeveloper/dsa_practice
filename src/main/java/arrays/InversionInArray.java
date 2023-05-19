package arrays;

import java.util.Map;
import java.util.TreeMap;

//TODO: https://takeuforward.org/data-structure/count-inversions-in-an-array/
/*
Given an array of N integers, count the inversion of the array (using merge-sort).

What is an inversion of an array?
Definition: for all i & j < size of array, if i < j then you have to find pair (A[i],A[j]) such that A[j] < A[i].
* */
public class InversionInArray {
    public static void main(String[] args) {
        int array[] = {5,3,2,1,4};

        TreeMap<Integer, Integer> valueIndexMap = new TreeMap<>();
       /* IntStream.of(array).collect(Collectors.toMap(val->val, (v1,v2) ->v1, TreeMap::new))
        Arrays.stream(array).collect(Collectors.toMap(, (v1,v2) ->v1, TreeMap::new));*/

        for(int i=0; i<array.length; i++){
            valueIndexMap.put(array[i], i);
        }
        for(Map.Entry<Integer, Integer> map : valueIndexMap.entrySet()){

        }
    }
}
