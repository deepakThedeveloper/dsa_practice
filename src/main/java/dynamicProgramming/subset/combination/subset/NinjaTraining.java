package dynamicProgramming.subset.combination.subset;

import lombok.AllArgsConstructor;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] training = {{10,50,1}, {5,100,11}, {5,100,110}};

        int max = findMaxPointsScored(training, 0, 0);
        System.out.println(max);
    }

    private static int findMaxPointsScored(int[][] t, int idx, int lastIndex) {
        if(lastIndex == 3) return 0;
        if(idx == t.length-1){
            int max = 0;
            for(int i=0; i<3; i++){
                if(i!=lastIndex){
                    max  = Math.max(max, t[idx][i]);
                }
            }
            return max;
        }

        int b = findMaxPointsScored(t, idx+1, lastIndex) + t[idx][lastIndex];
        int a = findMaxPointsScored(t, idx, lastIndex+1);
        return Math.max(a,b);
    }

    private static Data1 getNextMax(Data1 curr, int[][] t, int row) {
        int max = Integer.MIN_VALUE;
        int maxPos = -1;
        for(int j=0; j<3; j++){
            if(t[row][j] >= curr.max){
                continue;
            }
            if(t[row][j] > max){
                max = t[row][j];
                maxPos = j;
            }
        }
        return new Data1(maxPos, max);
    }

    private static Data1 getMax(int[][] t, int i){
        int max = Integer.MIN_VALUE;
        int maxPos = -1;
        for(int j=0; j<3; j++){
            if(max<t[i][j]){
                max = t[i][j];
                maxPos = j;
            }
        }
        return new Data1(maxPos, max);
    }
}
@AllArgsConstructor
class Data1{
    int index;
    int max;
}
