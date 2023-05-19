package algorithm.sorting;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int a[] = {5,1,3,9,7,0, -1, 4,2};
        heapsort(a, a.length);
    }

    private static void heapsort(int[] a, int length) {
        buildHeap(a, length);
        System.out.println("after building heap:");
        Arrays.stream(a).forEach(val -> System.out.print(val+","));

    }

    private static void buildHeap(int[] arr, int n) {
        boolean isSwapped;
        while (true) {
            isSwapped = false;
            for (int i = 1; i < n; i++) {
                int parentPos = getParentNodePosition(i);
                if (arr[parentPos] > arr[i]) {
                    swap(arr, i, parentPos);
                    isSwapped = true;
                }
            }
            if(!isSwapped) break;
        }
    }

    //Todo: to be built recursively
    private static void buildHeapRecursively(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            recursion(arr, i, arr[i]);

        }
    }
    private static int recursion(int[] arr, int i, int val){
        if(i == 0) return i;
        int parentPos = getParentNodePosition(i);
        if (arr[parentPos] > val) {
            int posToBeReplaced = recursion(arr, parentPos, val);
            swap(arr, i, posToBeReplaced);
        }
        return 0;
    }

    static void swap(int a[], int child, int parent){
        int temp = a[parent];
        a[parent] = a[child];
        a[child] = temp;
    }

    static int getParentNodePosition(int currPos){
        if(currPos % 2 ==0){
            currPos -= 2;
        }
        else{
            currPos -=1;
        }
        return currPos / 2;
    }
}
