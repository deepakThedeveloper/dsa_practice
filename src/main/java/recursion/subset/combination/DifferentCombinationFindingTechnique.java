package recursion.subset.combination;

import java.util.Arrays;

// 4 boxes are available and need to place 2 items in it. Need to print all possible combinations of same
public class DifferentCombinationFindingTechnique {
    public static void main(String[] args){
        int items = 2;
        int totalBoxes = 3;
        printAllCombinationsApproach1(1, 0, items, totalBoxes, "");
        System.out.println("===============================");
        printAllCombinationsApproach2PermutationApproach(new int[totalBoxes], 1, items, 0);
    }

    // as it is take not take so in total 8 combinations for 3 boxes will be generate, 2^3. but our question states we need
    // to print all combinations where 2 items will be fitted on 3 boxes.
    // so ideally all are generates iii, ii_, i_i, i__, _ii, _i_, __i, ___ i,e, 8 combinations but of this we need for 2 items
    // so we are printing only those combinations with 2 items with this condition if(currentItem == items)
    private static void printAllCombinationsApproach1(int currentBox, int currentItem, int items, int totalBoxes, String op){
        if(currentBox > totalBoxes){
            if(currentItem == items) System.out.println(op);
            return;
        }
        printAllCombinationsApproach1(currentBox+1, currentItem+1, items, totalBoxes, op+"i");
        printAllCombinationsApproach1(currentBox+1, currentItem, items, totalBoxes, op+"_");
    }

    private static void printAllCombinationsApproach2PermutationApproach(int[] boxes, int item, int totalItems, int idx){
        if(item > totalItems){
            Arrays.stream(boxes).forEach(v->System.out.print(v+" "));
            System.out.println();
            return;
        }
        for(int i=idx; i<boxes.length; i++){
            if(boxes[i] == 0){
                boxes[i] = item; // marking box as taken
                printAllCombinationsApproach2PermutationApproach(boxes, item+1, totalItems, i+1);
                boxes[i] = 0;
            }
        }
    }
}
