package recursion;

public class PrintPermutation {
    public static void main(String[] args) {
       // printPermutations("ABC", "");
        printPermutationsRevision("ABC", "");
    }

    private static void printPermutationsRevision(String s, String op) {
        if(s.length() == 0){
            System.out.println(op);
            return;
        }

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            String s1 = s.substring(0, i) + s.substring(i+1);
            printPermutationsRevision(s1, op+c);
        }
    }

    private static void printPermutations(String s, String op) {
        if(s.length() == 0){
            System.out.println(op);
            return;
        }
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            String s1 = s.substring(0, i) + s.substring(i+1);

            printPermutations(s1, op + c);
        }
    }
}
