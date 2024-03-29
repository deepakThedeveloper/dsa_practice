package recursion;

public class PrintEncoding {
    public static void main(String[] args) {
        String num = "303";
        printEncodingRevision(num, "");
//        String v = num.substring(4);
//        System.out.println(v);
//        printEncoding(num, "");
    }

    private static void printEncodingRevision(String num, String op){
        if(num.length() == 0){
            System.out.println(op);
            return;
        }
        char ch = num.charAt(0);
        if( ch - '0' > 0) {
            printEncodingRevision(num.substring(1), op+(char)(ch - '0' + 96));
        }
        if(num.length() >= 2) {
            int v = Integer.parseInt(num.substring(0, 2));
            if (v > 10 && v < 26) {
                printEncodingRevision(num.substring(2), op +(char)(v + 96));
            }
        }
    }

    private static void printEncoding(String num, String op){
        if(num.length() == 0){
            System.out.println(op);
            return;
        }
        if(num.length() == 1){
            if(num.charAt(0) == '0'){
                return;
            }
            int v = num.charAt(0) - '0';
            char c = (char)('a' + v - 1);
            System.out.println(op + c);
        }
        else {
            char c = num.charAt(0);
            String temp = num.substring(1);

            if(c == '0'){
                return;
            }
            else {
                int v = c - '0';
                char code = (char) ('a' + v - 1);
                printEncoding(temp, op + code);
            }
            String ch12 = num.substring(0,2);
            String temp12 = num.substring(2);

            int ch12v = Integer.parseInt(ch12);
            if(ch12v <= 26){
                char code = (char)('a' + ch12v - 1);
                printEncoding(temp12, op + code);
            }
        }
    }
}
