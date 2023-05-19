package algorithm.sorting;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


// count sort is stable sort.
// stable sort is sort in which if two objects has same value then their original position is mainted
// count sort is helpful when even if from n numbers there is certain range of numbers. e.g.: from 500000 number there is range
// between suppose 1-500. then this sort is helpful
public class CountSort {
    public static void main(String[] args) {
        Data[] data = {new Data('a',9),new Data('b',6),new Data('c',3),new Data('d',5),
                new Data('e',3),new Data('f',4),new Data('g',4),new Data('h',9),new Data('i',6)
                ,new Data('j',4),new Data('k',6),new Data('l',5),new Data('m',8),new Data('n',9)
                ,new Data('o',9)};
        int[] a = {9,6,3,5,3,4,3,9,6,4,6,5,8,9,9};
        countSort(data);
    }

    private static void countSort(Data[] a) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<a.length;i++){
            min = Math.min(min, a[i].val);
            max = Math.max(max, a[i].val);
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i=0; i<a.length; i++){
            frequencyMap.put(a[i].val, frequencyMap.getOrDefault(a[i].val, 0)+1);
        }

        int temp = 0;
        for(Map.Entry<Integer, Integer> map : frequencyMap.entrySet()){
            temp = map.getValue()+temp;
            frequencyMap.put(map.getKey(), temp-1);
        }

        Data[] ansArr = new Data[a.length];
        for(int i=a.length-1; i>=0; i--){
            int pos = frequencyMap.get(a[i].val);
            ansArr[pos] = a[i];
            frequencyMap.put(a[i].val, pos-1);
        }

        System.out.println(frequencyMap);
        Arrays.stream(ansArr).forEach(v-> System.out.println(v+" "));
    }
}

@AllArgsConstructor
@ToString
class Data{
    char c;
    int val;
}
