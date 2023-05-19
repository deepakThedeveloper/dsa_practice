package recursion;

/**
 * Given a string that contains only digits from 0 to 9, and an integer value, target.
 * Find out how many expressions are possible which evaluate to target using binary operator +, – and * in given string of digits.
 * Input : "123",  Target : 6
 * Output : {“1+2+3”, “1*2*3”}
 *
 * Input : “125”, Target : 7
 * Output : {“1*2+5”, “12-5”}
 */
//todo
public class PossibleExpression {
    public static void main(String[] args) {
        String s = "125";
        int target = 7;

        printExpressions(s, target, "", 0);
    }

    private static void printExpressions(String s, int target, String op, int sum) {
        if(sum == target){
            System.out.println(op);
            return;
        }
        if(s.length() == 0 || sum>target){
            return;
        }
        for(int i=0; i<s.length(); i++){
            String c = s.substring(0,i+1);
            String s1 = s.substring(i+1);
//            printExpressions(s1, target, check(op)?op+c:op+"+"+c, sum+(Integer.parseInt(c)));
//            printExpressions(s1, target, check(op)?op+c:op+"*"+c, sum*(Integer.parseInt(c)));
//            printExpressions(s1, target, check(op)?op+c:op+"-"+c, sum-(Integer.parseInt(c)));
//
            c = c.length()==0 ? "0":c;
            printExpressions(s1, target,op+"+"+c, sum+(Integer.parseInt(c)));
            printExpressions(s1, target, op+"*"+c, sum*(Integer.parseInt(c)));
            printExpressions(s1, target, op+"-"+c, sum-(Integer.parseInt(c)));
        }
    }

    private static boolean check(String op){
        int n = op.length();
        if(n==0) return true;
        int c = op.charAt(n-1)-'0';
        if( c >=0 && c<=9) return true;

        return false;
    }
}
