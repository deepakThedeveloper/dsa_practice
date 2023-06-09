package recursion.todo;

/**
 * 000-Pep, 001-Pe1, 010-P1p, 011-p2, 100-1ep, 101-1e1, 110-2p, 111-3
 */
public class StringAbbrevation {
    public static void main(String[] args) {
        printAbbrevation("000","pep", "","");
    }

    // not able to get number greater than 2. i.e. p2 for 011 is not getting but instead getting p12. so need to look
    // into string truncating logic
    private static void printAbbrevation(String number, String str, String op, String op1){
        if(number.length() == 0){
            System.out.println(op +" "+ op1);
            return;
        }

        char newChar = str.charAt(0);
        String newStr = number.substring(1);
        String newStr1 = str.substring(1);
        printAbbrevation(newStr, newStr1, op+"0", op1+newChar);
        int count = 1;
        int i=0;
        for(i = op1.length()-1; i>=0; i--){
            if(op1.charAt(i) == '1'){
                count++;
            }
            else break;
        }
        printAbbrevation(newStr, newStr1, op+"1", op1+count);
    }
}
