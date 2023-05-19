package string;

//https://www.codingninjas.com/codestudio/problems/encode-the-message_699836?utm_source=youtube&utm_medium=affiliate&utm_campaign=parikh_youtube&leftPanelTab=0
public class StringEncoding {
    public static void main(String[] args) {
        String encoded = encode("abbdcaas");
        System.out.println(encoded);
    }
    public static String encode(String message) {
        StringBuilder builder = new StringBuilder();
        char c = message.charAt(0);
        int count=1;
        for(int i=1; i<message.length(); i++){
            char c1 = message.charAt(i);
            if(c == c1)count++;
            else{
                builder.append(""+c+count);
                c=c1;
                count=1;
            }
        }
        builder.append(""+c+count);
        return builder.toString().trim();
    }
}
