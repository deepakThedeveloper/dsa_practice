package recursion;

import stacks.MinParanthesisRemoval;

import java.util.HashSet;
import java.util.Set;

public class PrintAllValidParenthesisByRemovingInvalidParenthesis {
    public static void main(String[] args) {
        String str = "()())()";
        int min = MinParanthesisRemoval.minParanthesisRemoval(str);
        System.out.println(min);
        printValidParenthesis(str, min, new HashSet<>());
    }

    private static void printValidParenthesis(String expr, int minRemoval, Set<String> expr1){
        if(minRemoval == 0){
            if(!expr1.contains(expr)) {
                int newMin = MinParanthesisRemoval.minParanthesisRemoval(expr);
                if (newMin == 0) {
                    expr1.add(expr);
                    System.out.println(expr);
                }
            }
            return;
        }
        for(int i=0; i<expr.length(); i++){
            String left = expr.substring(0, i);
            String right = expr.substring(i+1);

            printValidParenthesis(left+right, minRemoval-1, expr1);
        }
    }
}
