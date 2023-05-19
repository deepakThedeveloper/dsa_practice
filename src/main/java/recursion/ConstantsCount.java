package recursion;

public class ConstantsCount {
    public static void main(String[] args) {
        String str = "deepak agrawal";

        int count = countConstants(str);
        System.out.println(count);
    }

    private static int countConstants(String str) {
        if(str.length()==0){
            return 0;
        }
        int sum = countConstants(str.substring(0,str.length()-1));
        char c = str.charAt(str.length()-1);
        if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u'){
            return sum+1;
        }
        return sum;
    }
}
