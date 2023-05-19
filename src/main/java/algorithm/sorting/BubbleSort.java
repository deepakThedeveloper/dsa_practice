package algorithm.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {6,8,2,4,1};
        bubbleSort(a, a.length);
    }
    public static void bubbleSort(int[] arr, int n) {
        for(int i=0; i<n; i++){
            int idx = 0;
            for(int j=idx+1; j<n-i; j++, idx++){
                if(arr[idx]>arr[j]){
                    int temp = arr[idx];
                    arr[idx] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
