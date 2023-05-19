package arrays;

public class StockBuySell {
    public static void main(String[] args) {
        //int arr[] = {7,1,5,3,6,4};
        //int arr[] = {7,5,6,4,6};
        //int arr[] = {7,5,4,3,2,1};
        //int arr[] = {1,2,3,4,5,6};
        //int arr[] = {1,2,3,4,5,4,5,6,7,8,9,10};
        int arr[] = {1,2,3,4,5,0,5,6,7,8,9,10};
        int min = 0;
        int max = 0;
        int sum = 0;
        int finalMax= 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i]<arr[min]){
                min = i;
                max = i;
            }
            else if(arr[i]>arr[max]){
                max = i;
                sum = arr[max] - arr[min];
                if(finalMax < sum){
                    finalMax = sum;
                }
            }
        }
        System.out.println(finalMax);
    }
}
