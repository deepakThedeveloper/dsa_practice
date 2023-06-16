package stacks;

import java.util.Stack;

public class DuplicateBraces {
    public static void main(String[] args) {
        String s = "((a+b)+(c+d))";
        //String s = "(a+b)+((c+d))";
        boolean isDuplicateParanthesis = isDuplicateParanthesis(s);
        System.out.println(isDuplicateParanthesis);
    }

    private static boolean isDuplicateParanthesis(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c1 : c){
            if(c1==')'){
                int count = 0;
                while (!stack.isEmpty()){
                    char val = stack.pop();
                    count++;
                    if(val == '(') break;
                }
                if(count==1) return true;
            }
            else{
                stack.push(c1);
            }
        }
        return !stack.isEmpty();
    }
}
