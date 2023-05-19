package arrays;

import java.util.Arrays;

//Todo
public class Sort012 {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};

        int start = 0, end = arr.length-1;

        for(int i=0; i<arr.length;){
           if(arr[i] == 0){
               i++;
           }
           if(arr[end] == 2){
               end --;
           }
           else {

           }
        }
        Arrays.stream(arr).forEach(v -> System.out.print(v+" "));
    }

    private static int swap(int i, int one, int two, int[] arr) {
        int index = i;
        if(one != Integer.MIN_VALUE){
            index = one;
        }
        else{
            if(two != Integer.MIN_VALUE){
                index = two;
            }
        }
        if(index !=i){
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
            return index;
        }
        return i;
    }
}
