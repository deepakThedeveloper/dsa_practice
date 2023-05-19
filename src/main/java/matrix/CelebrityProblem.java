package matrix;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] mat = {{0,1,1,1,1},{1,0,1,1,0},{1,0,0,1,0},{0,0,0,0,0},{0,1,0,1,0}};

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<mat.length; i++) stack.push(i);

        while (stack.size()>1){
            int i1 = stack.pop();
            int i2 = stack.pop();
            if(mat[i1][i2] == 1){
                stack.push(i2);
            }
            else stack.push(i1);
        }
        System.out.println(stack.size());
        int i1 = stack.pop();
        boolean isCelebrity = true;
        for(int j=0; j<mat.length-1;j++){
            if(i1==j)continue;
            if(mat[j][i1] != 1 || mat[i1][j]!=0){
                isCelebrity = false;
                break;
            }
        }
        if(isCelebrity) System.out.println(i1);
        else System.out.println("null");
    }
}
