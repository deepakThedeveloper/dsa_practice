package dynamicProgramming.string;

//todo
public class NumberToStringCombinations {
    public static void main(String[] args) {
        String s ="123";
        printCombinations(s, "");
    }

    private static void printCombinations(String s, String op) {

        for(int i=0; i<s.length(); i++){
            String v = s.substring(0,i)+s.charAt(i);
            String s1 = s.substring(i);
           // printCombinations(s1, );
        }
    }

    static char[] val = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l','m','n','o','p','q','r','s','t','u','v','w','x'
    ,'y','z'};
}
