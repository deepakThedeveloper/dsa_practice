package recursion;

import javax.swing.plaf.IconUIResource;

public class PaintFence {
    public static void main(String[] args) {
        int fences = 5;
        char[] color = {'r','g','b'};

        int count = colorCombo(fences, color, "");
        System.out.println(count);
    }

    private static int colorCombo(int fence, char[] color, String op){
        if(op.length()>=3){
            int len = op.length()-1;
            char c1 = op.charAt(len);
            char c2 = op.charAt(len-1);
            char c3 = op.charAt(len-2);
            if(c1 == c2 && c2 == c3) return 0;
        }
        if(fence==0){
            System.out.println(op);
            return 1;
        }
        int count = 0;

        for(int j = 0; j<color.length; j++) {
            count += colorCombo(fence-1, color, op + color[j]);
        }
        return count;
    }
}
