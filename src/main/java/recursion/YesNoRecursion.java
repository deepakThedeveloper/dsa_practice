package recursion;

public class YesNoRecursion {
    public static void main(String[] args) {
        String str = "abc";

        //printValues(str, "");
        //printValues1(str, "");
        //printValues2(str, "");
        //printValues4(str, "");
        //printValues5(str, "");
        substring("abc", "");
        //printValues3(str, "");
        //loopValues(0);
    }
    //op: 3, 2 3, 1 3 2 3
    private static void loopValues(int i){
//        if(i==5) {
//            System.out.println();
//            return;
//        }
         while(i<3){
            i++;
            loopValues(i);
            System.out.print(i+" ");

        }
    }

    //op: abc, ab, ac, a, bc, b, c
    private static void printValues(String str, String op) {
        if(str.length()==0){
            System.out.println(op);
            return;
        }
        char c = str.charAt(0);
        String s1 = str.substring(1);
        printValues(s1, op+c);
        printValues(s1, op);
    }

    //op: abc, ab, ac, a
    private static void printValues3(String str, String op) {
        if(str.length()==0){
            System.out.println(op);
            return;
        }
        char c = str.charAt(0);
        String s1 = str.substring(1);
        printValues3(s1, op+c);
    }

    //op: abc, ac, bc, c
    private static void printValues1(String str, String op) {
        if(str.length()==0){
            System.out.println(op);
            return;
        }
        for(int i=0; i<str.length();i++) {
            char c = str.charAt(i);
            String s1 = str.substring(i+1);
            printValues1(s1, op + c);
        }
    }

    //op: abc, ab, ac, a
    private static void printValues2(String str, String op) {
        if(str.length()==0){
            System.out.println(op);
            return;
        }
        for(int i=0; i<str.length();i++) {
            char c = str.charAt(0);
            String s1 = str.substring(i+1);
            printValues2(s1, op + c);
        }
    }

    //op: abc, bac, cab
    private static void printValues4(String str, String op) {
        if(str.length()==0){
            System.out.println(op);
            return;
        }
        for(int i=0; i<str.length();i++) {
            char c = str.charAt(i);
            String s1 = str.substring(0,i)+str.substring(i+1);
            printValues4(s1, op + c);
            if(op.length()==1) return;
        }
    }

    //op: abc, bac, cab
    private static void printValues5(String str, String op) {
        if(str.length()==0){
            System.out.println(op);
            return;
        }
        for(int i=0; i<str.length();i++) {
            char c = str.charAt(i);
            String s1 = str.substring(0,i)+str.substring(i+1);
            printValues5(s1, op + c);
        }
    }

    private static void substring(String str, String op) {
        if(str.length()==0){
            System.out.println(op);
            return;
        }
        for(int i=0; i<str.length();i++) {
            char c = str.charAt(i);
            String s1 = str.substring(i+1);
            substring(s1, op + c);
            if(op.length()>=1) return;
        }
    }

}
