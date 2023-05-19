package stacks;

import java.util.Stack;

//Todo
public class Conversion {
    public static void main(String[] args) {
        String exp = "a*(b-c)/d+e";
        String prefix = convertInfixToPrefix(exp, exp.length());
    }

    private static String convertInfixToPrefix(String exp, int n) {
        Stack<String> operand = new Stack<>();
        Stack<String> operator = new Stack<>();
        for(char c : exp.toCharArray()){
            if(c >= 97 && c<=122){ // operand
                operand.push(""+c);
            }
            else{
                while(!operator.isEmpty() && isLessPrivilege(operator.peek(), ""+c)){

                }
                operator.push(""+c);
            }
        }
        return null;
    }

    private static boolean isLessPrivilege(String peek, String s) {
        switch(peek){
            case "(" : return false;
            case ")" : return true;
           // case  "-"
        }
        if(s.equals("(") || (peek.equals("-") || peek.equals("+") && s.equals("*") || s.equals("/"))) return false;
        if(s.equals(")") || (peek.equals("*") || peek.equals("/") && s.equals("-") || s.equals("+"))) return true;
        if(peek.equals("+") && s.equals("-")) return true;
        if(peek.equals("-") && s.equals("+")) {
            return true;
        }
        return false;
    }
}
//operator - +/*a-bcde
//operand  -