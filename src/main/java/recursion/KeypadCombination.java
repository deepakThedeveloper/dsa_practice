package recursion;

import java.util.ArrayList;

public class KeypadCombination {
    public static void main(String[] args) {
        String[] characters = {"!?", "abc", "def", "ghi", "jkl", "mno", "pqr", "uvw", "xyz", ".,"};

        String s = "576";
        ArrayList<String> combinations  = getCombinations(s, s.length()-1, characters);
        System.out.println("total combinations:"+combinations.size());
        combinations.forEach(System.out::println);
    }

    //Expectations: find all possible combinations character on numbers provided. e.g: 576 has (mno, uvw, pqr). so return all
    //combinations of mno, uvw, pqr.
    //Faith: function returns all combinations of 0-n-1 char i.e( combinations of 57).
    //EF: I need to add char of last nth char to all combinations returned from faith
    private static ArrayList<String> getCombinations(String s, int n, String[] mp) {

        if(n == -1){
            ArrayList<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        ArrayList<String> combinations = getCombinations(s, n-1, mp);
        ArrayList<String> combinations1 = new ArrayList<>();
        for(String comb : combinations){
            String characters = mp[Integer.parseInt(""+s.charAt(n))];
            for(char c: characters.toCharArray()){
                combinations1.add(comb+c);
            }
        }

        return combinations1;
    }
}
