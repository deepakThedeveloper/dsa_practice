package recursion;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] mat = {{1,50,10}, {11,100,2}, {6,200,3}};
        int maxPoints = train(mat, 0, mat.length-1);
        System.out.println("max points:"+maxPoints);
    }

    private static int train(int[][] mat, int c, int j){
        if(j == 0){
            int max = Integer.MIN_VALUE;
            for(int i=0; i<3; i++){
                if(i==c) continue;
                max = Math.max(max, mat[j][i]);
            }
            return max;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if(i==c)continue;;
            int a = train(mat, i, j-1) + mat[j][i];
            max = Math.max(max, a);
        }
        return max;
    }
}
