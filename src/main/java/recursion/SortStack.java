package recursion;

import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> stack  = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        sortStack(stack);

        while(!stack.isEmpty())
        System.out.println(stack.pop());
    }

    private static void sortStack(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }
        int n = stack.pop();
        sortStack(stack);

        insertStack(n, stack);
    }

    private static void insertStack(int n, Stack<Integer> stack) {
        if(stack.isEmpty() || n>stack.peek()){
            stack.push(n);
            return;
        }

        int temp = stack.pop();

        insertStack(n, stack);
        stack.push(temp);
    }
}
