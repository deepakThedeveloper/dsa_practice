package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintPermutations {
    public static void main(String[] args) {
        int space=4;
        int value=2;

        List<Character> list = new ArrayList<>();
        for(int i=0; i<space; i++){
            list.add('-');
        }
        printArrangements(space, value, "____",1);
    }

    private static void printArrangements(int space, int value, String op,  int val){
        if(val > value){
            System.out.println(op);
            return;
        }
        for (int i = 0; i < space; i++) {
            if(op.charAt(i) != '_') continue;
            printArrangements(space, value, replaceValue(op, val, i),  val+1);
        }
    }

    private static String replaceValue(String str, int j, int i){
        String left = str.substring(0, i);
        String right = str.substring(i+1);

        return left + ""+j + right;
    }
}
