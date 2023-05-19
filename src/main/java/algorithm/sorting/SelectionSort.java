package algorithm.sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {6,8,2,4,1};
        selectionSort(a);
    }
    public static void selectionSort(int arr[]) {
        for(int i=0; i<arr.length; i++){
            int minPos = getMinPos(arr, i+1);
            if(minPos==-1 || arr[i]<arr[minPos])continue;
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
    }
    private static int getMinPos(int[] arr, int start){
        //System.out.println("start:"+start);
        if(start>=arr.length) return -1;
        int minPos = start;
        for(int i=start; i<arr.length; i++){
            if(arr[minPos]>arr[i]){
                minPos = i;
            }
        }
        //System.out.println("minPos:"+minPos);
        return minPos;
    }
}
