package string;

public class FaultyKeyboard {
    public static void main(String[] args){
        String name = "alex";
        String typed = "aaleexa";
        boolean isValid = isLongPressedName(name, typed);
        System.out.println(isValid);
    }

    //leetcode pass
    public static boolean isLongPressedName(String name, String typed) {
        int i=0, j=0;
        for(; i<name.length() && j<typed.length(); ){
            if(name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }
            else {
                if(j>0 && typed.charAt(j) == typed.charAt(j-1)) j++;
                else return false;
            }
        }
        if(i<name.length()) return false;
        while(j<typed.length()){
            if(typed.charAt(j) != typed.charAt(j-1)) return false;
            j++;
        }
        return true;
    }
}
