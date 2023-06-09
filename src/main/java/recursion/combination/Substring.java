package recursion.combination;

public class Substring {
    public static void main(String[] args) {
        String str = "abc";
       // printSubstring(0, "", true, str);
        generate(str);
    }

    private static void printSubstring(int idx, String op, boolean execute, String ip){
        if(idx==ip.length()){
            System.out.println(op);
            return;
        }

        if(execute)
            printSubstring(idx+1, op+ip.charAt(idx), true, ip);

        printSubstring(idx+1, op, false, ip);
    }

    public static void generate(String word) {
        if (word.length() == 1) {
            System.out.println(word);
            return;
        }else{
            System.out.println(word);
            generate(word.substring(0, word.length()-1));
            generate(word.substring(1));
        }

    }
}
