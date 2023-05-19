package matrix;

//Todo
public class ExitPoint {
    public static void main(String[] args) {
        int[][] b = {{0,0,1,0}, {1,0,0,0}, {0,0,0,0}, {1,0,1,0}};

        findExitPoint(b);
    }

    // user will enter from 0,0 position and moves straight till he keeps finding 0.
    // as soon as user finds 1 he will take right turn. this will continue till it doesn't get out of matrix.
    // need to display the point where he has exited.
    private static void findExitPoint(int[][] a) {
        int rLen = a.length;
        int cLen = a[0].length;
        int r = 0, c = 0;
        int direction = 0; // 0-> R, 1->D, 2->L, 3->U
        while(true){
            direction = (direction+a[r][c])%4;
            if(direction == 0){
               c++;
            }
            else if(direction == 1){
                r++;
            }
            else if(direction == 2){
                c--;
            }
            else if(direction == 3){
                r--;
            }
            if(r>=rLen || c>=cLen || r<0 || c<0){
                System.out.println("r:"+r+" c:"+c);
                break;
            }
        }
//        while(true) {
//            if(!completed) {
//                completed = true;
//                while (c < cLen) {
//                    op.append("R");
//                    pos[0] = r;
//                    pos[1] = c;
//                    if (a[r][c] == 1) {
//                        r++;
//                        completed = false;
//                        break;
//                    }
//                    c++;
//                }
//            }
//            if(!completed) {
//                completed = true;
//                while (r < rLen) {
//                    pos[0] = r;
//                    pos[1] = c;
//                    op.append("D");
//                    if (a[r][c] == 1) {
//                        c--;
//                        completed = false;
//                        break;
//                    }
//                    r++;
//                }
//            }
//            if(!completed) {
//                completed = true;
//                while (c >= 0) {
//                    pos[0] = r;
//                    pos[1] = c;
//                    op.append("L");
//                    if (a[r][c] == 1) {
//                        r--;
//                        completed = false;
//                        break;
//                    }
//                    c--;
//                }
//            }
//            if(!completed) {
//                completed = true;
//                while (r >= 0) {
//                    pos[0] = r;
//                    pos[1] = c;
//                    op.append("U");
//                    if (a[r][c] == 1) {
//                        c++;
//                        completed = false;
//                        break;
//                    }
//                    r--;
//                }
//            }
//            if(completed) break;
//        }
    }

    private static void printElementsBySpiralTraversal(int[][] b, int rows, int cols) {
        int r=0, c=0, k=0;
        boolean finish = false;
        while(!finish) {
            finish = true;
            for (int i = c ; i < cols; i++) {
                c = i;
                if(b[r][i] == 1) break;

                finish = false;
            }
            for (int i = k+1; i < rows; i++) {
                r = i;
                if(b[i][c] == 1) break;
                finish = false;
            }
            for (int i = c - 1; i > k; i--) {
                c = i;
                if(b[r][i] == 1) break;
                finish = false;
            }
            for (int i = r-1; i>=k; i--) {
                r = i;
                if(b[i][c] == 1) break;
                finish = false;
            }
            k++;
            rows--;
            cols--;
        }
    }
}
