package algorithm.sorting;

import java.util.Arrays;

public class Sort01 {
    public static void main(String[] args) {
        int[] a = {0,0,0,1,0,0,0};
        sortOs1s(a);
    }

    private static void sortOs1s(int[] a) {
        int  j=0;
        for(;j<a.length;j++){
            if(a[j]==1)
                break;
        }
        for(int i=j+1; i<a.length;i++){
            if(a[i]==0){
                int temp = a[j];
                a[j]=a[i];
                a[i]=temp;
                j++;
            }
        }

        Arrays.stream(a).forEach(v-> System.out.print(v+" "));
    }
}
