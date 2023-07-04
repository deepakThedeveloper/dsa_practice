package util;

public class GlobalUtil {

    public static void swap(int i, int j, int[] coins){
        int temp = coins[i];
        coins[i] = coins[j];
        coins[j] = temp;
    }
}
