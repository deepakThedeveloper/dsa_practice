package dynamicProgramming;

public class PaintFence {
    public static void main(String[] args) {
        int fence = 5;
        char[] color = {'r','g','b'};

        paintFence(fence, color, "");
        int sum1 = paintFenceCount(fence, color, "", 0);
        System.out.println(sum1);
//
        int sum = paintFenceCountDP(fence, color);
        System.out.println(sum);
    }

    private static int paintFenceCountDP(int fence, char[] color) {
        if(fence == 1) return color.length;
        int[][] dp = new int[2][fence-1];
        dp[0][0] = 3;  //rr,gg,bb
        dp[1][0] = 6;  //rg,rb,gr,gb,br,bg

        for(int i=1; i<fence-1; i++){
            dp[0][i] = dp[1][i-1];
            dp[1][i] = (dp[0][i-1] + dp[1][i-1])*(color.length-1);
        }

        return dp[0][fence-2] + dp[1][fence-2];
    }

    //paint fence such that not more than two fence has same color
    private static void paintFence(int fence, char[] color, String op) {
        if(op.length()>2){
            char c1 = op.charAt(op.length()-3);
            char c2 = op.charAt(op.length()-2);
            char c = op.charAt(op.length()-1);
            if(c1==c2 && c2 == c){
                return;
            }
        }
        if(fence == 0){
            System.out.println(op);
            return;
        }

        for(int i=0; i<color.length;i++) {
            paintFence(fence - 1, color, op + color[i]);
        }
    }
    //paint fence such that not more than two fence has same color
    private static int paintFenceCount(int fence, char[] color, String op, int count) {
        if(op.length()>2){
            char c1 = op.charAt(op.length()-3);
            char c2 = op.charAt(op.length()-2);
            char c = op.charAt(op.length()-1);
            if(c1==c2 && c2 == c){
                return 0;
            }
        }
        if(fence == 0){
            //System.out.println(op);
            return 1;
        }

        int sum = 0;
        for(int i=0; i<color.length;i++) {
            sum += paintFenceCount(fence - 1, color, op + color[i], count+1);
        }
        return sum;
    }
}
