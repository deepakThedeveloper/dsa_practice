package stacks;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args){
        String str = "3[a2[bc]]";
        String decode = decode(str);
    }

    private static String decode(String str){
        Stack<Integer> numbers = new Stack<>();
        Stack<String> characters = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            //System.out.println("c:"+c);

            if(c >= 48 && c <= 57){
                Data data = getNumber(str, i);
                numbers.push(data.str);
                i = data.idx-1;
            }
            else if(c == '[' || c >= 97 && c<= 122){
                characters.push(""+c);
            }
            else if(c == ']'){

                int num = numbers.pop();
                String str1 = getString(characters);
                //System.out.println("num:"+num+" str1:"+str1);

                StringBuilder builder = new StringBuilder();
                for(int j=0; j<num; j++){
                    builder.append(str1);
                }
                characters.push(builder.toString());
            }
        }
        return getString(characters);
    }

    private static String getString(Stack<String> chars){
        StringBuilder internal = new StringBuilder();
        while(!chars.isEmpty() && !chars.peek().equals("[")){
            String s = chars.pop();
            internal.insert(0, s);
        }
        if(!chars.isEmpty())chars.pop();
        return internal.toString();
    }

    private static Data getNumber(String str, int i){
        StringBuilder numbers = new StringBuilder();
        while(i < str.length()){
            char ch = str.charAt(i);
            if(ch >= 48 && ch <= 57){
                numbers.append(ch);
            }
            else break;
            i++;
        }
        String str1 = numbers.toString();

        return new Data(Integer.parseInt(str1), i);
    }

    static class Data{
        Integer str;
        int idx;

        Data(Integer str, int idx){
            this.str = str;
            this.idx = idx;
        }
    }
}
