package recursion;

public class PrintEncodings {
    static char[] val = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static void main(String[] args) {
        printEncoding("12103", "");
    }

    private static void printEncoding(String str, String op) {
        if(str.length() == 0){
            System.out.println(op);
            return;
        }
        if(str.charAt(0) == '0') return;
        /*if(Integer.parseInt(str)>val.length){
            return;
        }*/

        char c = str.charAt(0);
        printEncoding(str.substring(1), op+val[(c-'0')-1]);
        if(str.length()>=2) {
            String c1 = str.substring(0, 2);
            if (Integer.parseInt(c1) < val.length) {
                printEncoding(str.substring(2), op + val[Integer.parseInt(c1) - 1]);
            }
        }
    }
}
