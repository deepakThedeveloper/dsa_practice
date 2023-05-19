package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
    public static void main(String[] args) {
        int[][] b = {{10,1,1,1}, {20,1,1,1}, {3,2,0,7}};

        printElementsBySpiralTraversal(b, b.length, b[0].length);
    }

    private static void printElementsBySpiralTraversal(int[][] b, int rows, int cols) {
        int r=0, c=0, k=0;
        boolean finish = false;
        while(!finish) {
            finish = true;
            for (int i = k; i < rows; i++) {
                System.out.print(b[i][c] + " ");
                r = i;
                finish = false;
            }
            for (int i = c + 1; i < cols; i++) {
                System.out.print(b[r][i] + " ");
                c = i;
                finish = false;
            }
            for (int i = r-1; i>=k; i--) {
                System.out.print(b[i][c] + " ");
                r = i;
                finish = false;
            }
            for (int i = c -1; i > k; i--) {
                System.out.print(b[r][i] + " ");
                c = i;
                finish = false;
            }
            k++;
            rows--;
            cols--;
        }
    }

    public static List<Integer> spiralOrderLeetCode(int[][] matrix) {

        List<Integer> elements = new ArrayList<>();
        int startRP = 0;
        int endRP = matrix.length-1;
        if(endRP==0){
            for(int i=0; i<=matrix[0].length-1; i++){
                elements.add(matrix[0][i]);
            }
            return elements;
        }
        int startCP = 0;
        int endCP = matrix[0].length-1;

        boolean canTraverse = true;
        while(canTraverse){
            canTraverse = false;
            int temp = 0;
            for(int i=startCP; i<=endCP && startRP<=endRP; i++){
                elements.add(matrix[startRP][i]);
                canTraverse = true;
            }
            startRP++;

            for(int i=startRP; i<=endRP && startCP<=endCP; i++){
                elements.add(matrix[i][endCP]);
                canTraverse = true;
            }
            endCP--;

            for(int i=endCP; i>=startCP && startRP<=endRP; i--){
                elements.add(matrix[endRP][i]);
                canTraverse = true;
            }
            endRP--;

            for(int i=endRP; i>=startRP && startCP <=endCP; i--){
                elements.add(matrix[i][startCP]);
                canTraverse = true;
            }
            startCP++;
        }
        return elements;
    }
}
