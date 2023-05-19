package recursion;

import java.util.ArrayList;
import java.util.List;

public class GetKeypadCombinations {
    public static void main(String[] args) {
        GetKeypadCombinations gc = new GetKeypadCombinations();
        String digits = "237";
        gc.letterCombinations(digits);
    }
    private String[] keypad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        getCombinations(digits, combinations, 0, "");

        System.out.println(combinations);
        return combinations;
    }

    private void getCombinations(String digits, List<String> combinations, int idx, String op){
        if(digits.length()==0){
            combinations.add(op);
            return;
        }

        for(int i=0; i<digits.length(); i++){
            if(!digits.substring(0, i).isEmpty()) break;
            char c = digits.charAt(i);
            String s1 = digits.substring(i+1);

            String keys = keypad[(c-'0')-2];
            for(int j=0; j<keys.length(); j++){
                getCombinations(s1, combinations, i+1, op+keys.charAt(j));
            }
        }
    }
}
