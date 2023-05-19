package string;

public class IsStringAnagram {
    public static void main(String[] args) {
        boolean isAnagram = areAnagram("abc","cba");
        System.out.println(isAnagram);
    }

    public static boolean areAnagram(String str1, String str2){
        if(str1.length() != str2.length()) return false;

        int[] freq = new int[26];
        for(int i=0; i<str1.length(); i++){
            freq[str1.charAt(i) - 'a'] ++;
            freq[str2.charAt(i) - 'a'] --;
        }
        for(int i=0; i<26; i++){
            if(freq[i] !=0) return false;
        }
        return true;
    }
}
