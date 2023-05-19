package arrays;

//5,7,2,9,8,4,1,3,10
//0,1,2,3,4,5,6,7,8
//TODO: optimized approach implementation
public class MissingNumber {
    public static void main(String[] args) {
        int arr[] = {1,2,3,5};
        //int arr[] = {6,1,2,8,3,4,7,10,5};
        //int arr[] = {2};
        //int missing = missingNumber(arr, 2);
        int missing = missingNumberOptimised(arr, 5);
        System.out.println("missing number:"+missing);
    }

    private static int missingNumberOptimised(int[] arr, int n) {
        for(int i=0; i<arr.length; i++){
            if(arr[i]-1 == i || arr[i]-2==i){
                continue;
            }
            else{
                int temp = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i] = temp;
            }
        }
        /*if(arr[arr.length-1] != arr.length-1 || arr[arr.length-1] != n){
            int val = arr[arr.length-1];
            int temp = arr[val-1];
            arr[val-1] = val;
            arr[arr.length-1] = temp;
        }*/

        if(n != arr[arr.length-1]){
            return n;
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
            if(arr[i]-1 != i){
                int val = arr[arr[i]-1];
                if(val-1 != i) {
                    return i + 1;
                }
            }
        }
        System.out.println();
        return 0;
    }

    static int missingNumber(int array[], int n) {
        for(int i=0; i<array.length; i++){
            if(array[i]-1 == i || array[i]-2==i){
                continue;
            }
            else{
                while(array[i]-1 != i){
                    System.out.println("in while:"+array[i]);
                    if(array[i] == n){
                        int temp = array[array[i]-2];
                        array[array[i]-2] = array[i];
                        array[i] = temp;
                    }
                    else{
                        int temp = array[array[i]-1];
                        array[array[i]-1] = array[i];
                        array[i] = temp;
                    }
                }
            }
        }

        if(n != array[array.length-1]){
            return n;
        }
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
            if(array[i]-1 != i){
                return i+1;
            }
        }
        System.out.println();
        return 0;
    }
}
