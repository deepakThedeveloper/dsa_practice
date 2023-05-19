package algorithm.sorting;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] a = {1,1,0,1,0,2,2,1,1,2,1,2,0,1,0,2,1};
        sortOs1s2s(a);
    }

    private static void sortOs1s2s(int[] a) {
        int  ones=-1, twos = -1;

        for(int i=0; i<a.length;i++){
           if(a[i]==2 && twos == -1){
               twos = i;
           }
           if(a[i]==1){
               if(ones==-1){
                   ones = i;
               }
               if(twos !=-1){
                   swap(i, twos,a);
                   twos++;
               }

           }
           if(a[i]==0){
               if(ones!=-1 /*&& (twos==-1 || ones<twos)*/ ){
                   if(twos!=-1) {
                       swap(ones, twos, a);
                       twos++;
                   }
                   swap(i,ones,a);
                   ones++;
               }
               else if(twos != -1 && twos < ones){
                   swap(i,twos, a);
                   twos++;
               }
           }
        }

        Arrays.stream(a).forEach(v-> System.out.print(v+" "));
    }

    private static void swap(int i, int ones, int[] a) {
        int temp = a[i];
        a[i] = a[ones];
        a[ones] = temp;
    }
}
/*
1,1,0,1,0,2,2,1,1,2,1,2,0,1,0,2,1
0,0,0,0,0,1,1,1,1,1,1,1,2,2,2,2,2,1


0,0,2,0,0,1,1,0,2
0,0,1,0,0,2,0,1,0,2
0,0,0,0,0,1,1,2,0,2
0,0,0,0,0,1,1,2,2

 */