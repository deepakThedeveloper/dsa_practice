package java8.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class ArrayComprator {
    public static void main(String[] args) {
        int[][] val = {{1,3},{4,6},{4,5}};

        Comparator<int[]> fun = (a1, a2) -> {
            if(a1[0] == a2[0]){
                return Integer.compare(a1[1], a2[1]);
            }
            return Integer.compare(a1[0], a2[0]);
        };

        Arrays.sort(val, fun);
        for(int i=0; i<val.length; i++){
            System.out.println(val[i][0]+" "+val[i][1]);
        }
    }
}
