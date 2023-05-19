package backtracking;

public class CrosswordPuzzle {
    static String[] words = {"DELHI", "ICELAND", "ANKARA", "LONDON"};

    public static void main(String[] args) {
        char[][] arr = {{'+','-','+','+','+','+','+','+','+','+'},
                        {'+','-','+','+','+','+','+','+','+','+'},
                        {'+','-','+','+','+','+','+','+','+','+'},
                        {'+','-','-','-','-','-','+','+','+','+'},
                        {'+','-','+','+','+','-','+','+','+','+'},
                        {'+','-','+','+','+','-','+','+','+','+'},
                        {'+','+','+','+','+','-','+','+','+','+'},
                        {'+','+','-','-','-','-','-','-','+','+'},
                        {'+','+','+','+','+','-','+','+','+','+'},
                        {'+','+','+','+','+','-','+','+','+','+'}};


        solveCrossword(arr,0, 0, 0, 0);
    }

    private static void solveCrossword(char[][] arr, int r, int c, int i, int j) {
        if(r== arr.length){
            return;
        }
        int ni = 0;
        int nj = 0;
        if(c == arr.length-1){
            ni = r+1;
            nj = 0;
        }
        else{
            ni = r;
            nj = c+1;
        }
        if(arr[r][c] == '+' &&  j==0){
            solveCrossword(arr, ni, nj, i, j);
        }
        else if(arr[r][c] == '+' && j>0 || arr[r][c] == '-' && j==words[i].length() || (arr[r][c] != '+' && arr[r][c]!='-')){
            return;
        }
        else{
            String word = words[i];
            if(arr[r][c] == '-'){
                arr[r][c] = word.charAt(j);
                solveCrossword(arr, ni, nj, i, j+1);
                arr[r][c] = '-';
            }
            else{
                char c1 = arr[r][c];
                if(c1 == word.charAt(j)){
                    arr[r][c] = word.charAt(j);
                    solveCrossword(arr, ni, nj, i, j+1);
                    arr[r][c] = c1;
                }
            }
        }

    }
}
