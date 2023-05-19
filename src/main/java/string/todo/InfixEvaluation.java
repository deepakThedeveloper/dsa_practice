package string.todo;

import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        String expr = "2+(5-3*6/2)";
        int val = evaluateInfix(expr);
        System.out.println(val);
    }

    private static int evaluateInfix(String expr){
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for(char c : expr.toCharArray()){
            if((int)c>=48 && (int)c<=57){
                operand.push('0'-c);
            }
            else{
                operatorOps(operator, c);
            }
        }
        return 0;
    }

    private static void operatorOps(Stack<Character> operator, char c){
        if(operator.isEmpty()) {
            operator.push(c);
            return;
        }

        if(c     == '/'){

        }
    }
}
