package stacks;

import java.util.Stack;

public class MinParanthesisRemoval {
    public static void main(String[] args) {
        String s = "()())()";
        int min = minParanthesisRemoval(s);
        System.out.println(min);
    }
    public static int minParanthesisRemoval(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(stack.isEmpty() || c == '(') stack.push(c);
            else {
                boolean removed = false;
                if (stack.peek()=='(') {
                    stack.pop();
                    removed = true;
                }
                if(!removed) stack.push(c);

            }
        }
        return stack.size();
    }
}
