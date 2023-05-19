package recursion;

public class PrintKeypadCombinations {
    static String[] vals = {"abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz", "!,"};
    public static void main(String[] args) {
        printKeypadCombinations("234", "");
        System.out.println();
        keypadComboRevision1("234",0,"");
    }

    private static void keypadComboRevision1(String nums, int i, String op){
        if(i==nums.length()){
            System.out.print(op+", ");
            return;
        }

        char c = nums.charAt(i);
        String s = vals[c - '0'];
        for(int j=0; j<s.length(); j++){
            keypadComboRevision1(nums, i+1, op+s.charAt(j));
        }
    }
    private static void printKeypadCombinations(String str, String op) {
        if(str.length() == 0){
            System.out.print(op+", ");
            return;
        }
        char c = str.charAt(0); //6
        String s = str.substring(1);  //78

        String val = vals[c-'0'];  //pqr
        for(int i=0; i<val.length(); i++){
            printKeypadCombinations(s, op+val.charAt(i)); //78, p
        }
    }
}
