package string;

import java.util.Stack;

//https://www.codingninjas.com/codestudio/problems/mnfrj_1075018?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube&leftPanelTab=0
public class MinParanthesisToAdd {
    public static void main(String[] args) {
        int minParToAdd = minimumParentheses(")((()");
        System.out.println(minParToAdd);
    }
    public static int minimumParentheses(String pattern) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            if(c == '('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty() || stack.peek() == ')'){
                    stack.push(c);
                }
                else{
                    stack.pop();
                }
            }

        }
        return stack.size();
    }
}
