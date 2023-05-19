package arrays;

import java.util.*;

public class MergeKSortedList {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(10,20, 30, 40, 50);
        List<Integer> l2 = Arrays.asList(5, 7, 9,11, 19, 55, 57);
        List<Integer> l3 = Arrays.asList(1,2, 3);
        List<Integer> l4 = Arrays.asList(32,39);

        List<List<Integer>> data = Arrays.asList(l1, l2, l3, l4);
        List<Integer> mergedSortedList = mergeList(data);
        System.out.println(mergedSortedList);
    }

    private static List<Integer> mergeList(List<List<Integer>> data){

        Comparator<Pair> comparator = Comparator.comparingInt(p -> p.data);
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(comparator);
        for(int i=0; i<data.size(); i++){
            Pair pair = new Pair(i, 0, data.get(i).get(0));
            priorityQueue.add(pair);
        }

        List<Integer> merged =  new ArrayList<>();
        while(!priorityQueue.isEmpty()){
            Pair p = priorityQueue.remove();
            merged.add(p.data);
            int li = p.listIndex;
            int nextDi = p.dataIdex+1;

            if (nextDi < data.get(li).size()) {
                int newData = data.get(li).get(nextDi);
                Pair newPair = new Pair(li, nextDi, newData);
                priorityQueue.add(newPair);
            }
        }

        return merged;
    }

    static class Pair{
        int listIndex;
        int dataIdex;
        int data;

        Pair(int li, int di, int data){
            this.listIndex = li;
            this.dataIdex = di;
            this.data = data;
        }
    }
}
