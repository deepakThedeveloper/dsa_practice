package graphs.disjointset;

import javafx.scene.paint.Paint;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationToReachEnd {
    public static void main(String[] args) {
        int[] nos = {3, 4, 65};
        int start = 7, end = 66175;
        int minMuls = minMulToReachEnd(nos, start, end);
        System.out.println(minMuls);
    }

    private static int minMulToReachEnd(int[] nos, int start, int end){
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(start, 0));

        while (!queue.isEmpty()){
            Pair<Integer, Integer> stepResultPair = queue.poll();
            int prevNum = stepResultPair.getKey();
            int prevStep = stepResultPair.getValue();
            for(int i=0; i<nos.length; i++){
                int num = (prevNum * nos[i])%100000;
                int step = prevStep + 1;
                if(num == end) return step;
                if(num > end) continue;
                queue.add(new Pair<>(num, step));
            }
        }
        return -1;
    }
}
