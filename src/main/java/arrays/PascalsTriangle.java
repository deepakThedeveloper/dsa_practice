package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        List<Integer> val = new ArrayList<>();
        val.add(1);
        for(int i=1; i<=5; i++){
            val = printStar(i,5, val);
            System.out.println();
        }
    }

    private static List<Integer> printStar(int s, int k1, List<Integer> prevVal) {
        int i1=0;
        int j1 = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=k1-s; i>0;i--){
            System.out.print(" ");
        }
        for(int k = 0; k<s; k++){
            if(k==0 || k==s-1){
                System.out.print("1 ");
                list.add(1);
            }
            else{
                i1 = j1;
                j1 = i1+1;
                int val = prevVal.get(i1)+prevVal.get(j1);
                list.add(val);
                System.out.print(val+" ");
            }
        }
        for(int i=k1-s; i>0;i--){
            System.out.print(" ");
        }
        return list;
    }
}
