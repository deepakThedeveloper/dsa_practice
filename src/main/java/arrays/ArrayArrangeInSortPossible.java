package arrays;

public class ArrayArrangeInSortPossible {
    public static void main(String[] args) {
        //int[] arr = {-78, -68, -51, -20, 187, -182, 42, 64, 66, 93};
        int[] arr = {8,4,6};
        //int[] arr = {-90, -70, -61, -57, -246, -28, 1, 14, 35, 63};

        boolean isPossible = test(arr, arr.length);

        System.out.println(isPossible);
    }

    private static boolean test(int[] arr, int n){
        int pos = -1;
        for(int i=0, j=i+1; j<n;i++, j++){
            if(arr[j]<arr[i]){
                if(pos > -1) return false;
                if(j+1<n && arr[j+1]<arr[i]) return false;
                pos = i;
            }
        }
        return true;
    }
}
