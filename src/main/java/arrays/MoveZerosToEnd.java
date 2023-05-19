package arrays;

import java.util.ArrayList;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(0);
        list.add(4);
        list.add(1);
        list.add(3);
        list.add(0);
        list.add(28);
        pushZerosAtEnd(list);
    }
    public static void pushZerosAtEnd(ArrayList<Integer> arr)
    {
        int size = arr.size();
        int count = 0;
        for(int i=0; i<size; i++){
            if(arr.get(i) == 0) count++;
            else
            if(count >0 && i-count>=0)arr.set((i-count),arr.get(i));
        }
        for(int i=size-count; count>0 && i<size; i++){
            arr.set(i,0);
        }
    }
}
