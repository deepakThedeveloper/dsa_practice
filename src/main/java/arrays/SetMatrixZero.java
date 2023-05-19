package arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        int matrix[][] = {{0,1,1}, {1,1,1},{1,1,1}};

        int rows = matrix.length;
        int col = matrix[0].length;
        System.out.println("rows:"+rows);
        System.out.println("columns:"+col);
        System.out.println("matrix before operations");
        //firstApproach(matrix);
        secondApproach(matrix);
        System.out.println("matrix after operations");
        for (int i=0; i<rows;i++){
            for (int j=0; j<col; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void secondApproach(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        boolean foundZero = false;
        for(int i=0; i<r; i++){
            for (int j = 0; j<c; j++){
                if(matrix[i][j]==0){
                    setRowColToZero(i, j, matrix, r, c);
                    foundZero = true;
                   // break;

                }
            }
            if(foundZero){
                break;
            }
        }
    }

    private static void setRowColToZero(int r, int c, int[][] matrix, int totalRows, int totalCols) {
        for(int i=0; i<totalCols; i++){
            matrix[r][i] = 0;
        }
        for(int j=0; j<totalRows; j++){
            matrix[j][c] = 0;
        }
    }

    private static void firstApproach(int[][] matrix) {
        int rows = matrix.length;
        int col = matrix[0].length;
        System.out.println("rows:"+rows);
        System.out.println("columns:"+col);
        System.out.println("matrix before operations");
        for (int i=0; i<rows;i++){
            for (int j=0; j<col; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        int rowValue = -1;
        int colValue = -1;
        boolean foundMatch = false;
        for(int i=0; i<rows; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == 0){
                    rowValue = i;
                    colValue = j;
                    foundMatch = true;
                    break;
                }
            }
            if (foundMatch) break;
        }
        for(int i = 0; i<rows; i++){
            if(rowValue == i){
                for(int j=0; j<col; j++){
                    matrix[i][j]=0;
                }
            }
            else {
                matrix[i][colValue] = 0;
            }
        }
        System.out.println("matrix after operations");
        for (int i=0; i<rows;i++){
            for (int j=0; j<col; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

}
