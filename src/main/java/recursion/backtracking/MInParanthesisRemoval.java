package recursion.backtracking;

import java.util.Stack;

public class MInParanthesisRemoval {
    public static void main(String[] args) {
        String str = "()())()";

        int minRemoval = getMinRemoval(str);
        printAllCombinations(str, minRemoval, 0);
    }

    private static int getMinRemoval(String str){
        Stack<Character> invalidParanthesis = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == ')'){
                if(invalidParanthesis.isEmpty() || invalidParanthesis.peek() == ')'){
                    invalidParanthesis.push(c);
                }
                else if(invalidParanthesis.peek() == '('){
                    invalidParanthesis.pop();
                }
            }
            else{
                invalidParanthesis.push('(');
            }
        }
        return invalidParanthesis.size();
    }
    private static void printAllCombinations(String str, int totalRemoval, int totalRemoved){

        if(totalRemoved == totalRemoval){
            boolean isValid = isValidString(str);
            if (isValid) {
                System.out.println(str);
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if(i>0){
                char prevChar = str.charAt(i-1);
                char currChar = str.charAt(i);
                if(prevChar == currChar) continue;
            }
            String remainingString = str.substring(0, i) + str.substring(i+1);

            printAllCombinations(remainingString, totalRemoval, totalRemoved+1);
        }
    }

    private static boolean isValidString(String remainingString) {
        return getMinRemoval(remainingString)==0;
    }
}
