package priorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MaxHeapUsingArrays {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        //int arr[] = {4,1,3,9,7};
        maxHeap(arr, arr.length);
        Arrays.stream(arr).forEach(v->System.out.print(v+", "));
        System.out.println();

        List<Integer> data = new ArrayList<>();
        IntStream.rangeClosed(1,6).forEach(v->data.add(v));
        System.out.println("before adding:"+data);
        addRevision(data, 4);
        System.out.println("after adding:"+data);
        addRevision(data, 3);
        System.out.println("after adding:"+data);
        addRevision(data, 0);
        System.out.println("after adding:"+data);
        int remove1 = removeRevision(data);
        System.out.println("remove 1:"+remove1);
        System.out.println("after first removal:"+data);
        int remove2 = removeRevision(data);
        System.out.println("remove 2:"+remove2);
        System.out.println("after second removal:"+data);
    }

    private static void addRevision(List<Integer> a, int val){
        a.add(val);
        for(int i=a.size()-1; i>=0;){
            int parent = (i-1)/2;
            if(a.get(parent)>val){
                int temp = a.get(parent);
                a.set(parent,val);
                a.set(i, temp);
                i=parent;
            }
            else break;
        }
    }

    private static int removeRevision(List<Integer> data){
        int peekElement = data.get(0);
        data.set(0, data.get(data.size()-1));
        data.remove(data.size()-1);

        for(int i=0; i<data.size();){
            int c1 = 2*i+1;
            int c2 = 2*i+2;

            int parentData = data.get(i);
            int c1Data = c1<data.size() ? data.get(c1) : Integer.MAX_VALUE;
            int c2Data = c2 < data.size() ? data.get(c2) : Integer.MAX_VALUE;

            if(c1Data < c2Data && parentData > c1Data){
                data.set(c1, parentData);
                data.set(i, c1Data);
                i=c1;
            }
            else if(c2Data < c1Data && parentData > c2Data){
                data.set(c2, parentData);
                data.set(i, c2Data);
                i=c2;
            }
            else break;
        }
        return peekElement;
    }

    private static void maxHeap(int[] arr, int length) {
        int parentNodeIndex = (length/2) - 1;
        heapify(arr, parentNodeIndex, length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    //1,3,5,4,6,13,10,9,8,15,17
    //17,1,13,9,3,5,10,4,8,15,6
    //17,15,13,9,6,5,10,4,8,3,1
    private static void heapify(int[] arr, int parentNodeIndex, int last) {
        boolean isSwapped = false;
        for(int i = parentNodeIndex; i>=0; i--) {
            int valIndex = arr[last] > arr[last - 1] ? last : last - 1;
            if (arr[i] < arr[valIndex]) {
                int temp = arr[i];
                arr[i] = arr[valIndex];
                arr[valIndex] = temp;
                isSwapped = true;
            }
            last=last -2;
        }
        if(isSwapped) {
            heapify(arr, parentNodeIndex, arr.length - 1);
        }
    }
}
