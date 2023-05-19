package recursion;

import java.util.Stack;

public class ReverseStackWithoutLoop {
    public static void main(String[] args) {
        Stack<Integer> stack  = new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        reverseStack(stack);

        while(!stack.isEmpty())
        System.out.println(stack.pop());
    }

    private static void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }
        int n = stack.pop();
        reverseStack(stack);

        insertStack(n, stack);
    }

    private static void insertStack(int n, Stack<Integer> stack) {
        if(stack.isEmpty()){
            stack.push(n);
            return;
        }

        int temp = stack.pop();
        insertStack(n, stack);
        stack.push(temp);
    }
}
