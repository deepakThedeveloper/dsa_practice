package recursion;

public class StringEncoding {
    public static void main(String[] args) {
        String str = "123";

        printEncodedString(str, "");
    }

    private static void printEncodedString(String str, String op){
        if(str.length()==0){
            System.out.println(op);
            return;
        }

        for(int i=0; i<str.length(); i++){
            String newString = str.substring(i+1);
            String temp = str.substring(0, i+1);
            int v = Integer.valueOf(temp);
            if(v>26) continue;
            char c = (char)(v + 96);
            printEncodedString(newString, op+c);
        }
    }
}
