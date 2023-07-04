package recursion.subset.permutation;

import java.util.Arrays;

//refer: /resources/permutation_approaches.jpg
// 4 boxes are available and need to place 2 items in it. Need to print all possible permutations of same
public class DifferentPermutationFindingTechnique {
    public static void main(String[] args){
        int items = 2;
        int totalBoxes = 4;
        printAllPermutationsApproach1(new int[totalBoxes], items, 1);

        // currentBox = 1 because there is no zero box and execution starts from 1st box. it is first to select
        printAllPermutationsApproach2CombinationTechnique(1, totalBoxes, new int[items], 0, "");
    }

    private static void printAllPermutationsApproach1(int[] boxes, int items, int idx){
        if(idx > items){
            Arrays.stream(boxes).forEach(v -> System.out.print(v+" "));
            System.out.println();
            return;
        }
        for(int i=0; i<boxes.length; i++){
            if(boxes[i] == 0){
                boxes[i] = idx;
                printAllPermutationsApproach1(boxes, items, idx+1);
                boxes[i] = 0;
            }
        }
    }

    private static void printAllPermutationsApproach2CombinationTechnique(int currentBox, int totalBox, int[] items,
                                                                          int idx, String op){
        if(currentBox > totalBox){
            // this check because multiple permutations likes 1__, ___, _2_ kind of will get generated but we need only
            // those with 2 items
            if(idx  == items.length) {
                System.out.println(op);
            }
            return;
        }
        for(int i=0; i<items.length; i++){
            if(items[i] == 0){
                items[i] = 1; // nothing significance, just kind of visited arry which showcase item has been picked by
                // lower box so that high box should not pick it up
                printAllPermutationsApproach2CombinationTechnique(currentBox + 1, totalBox, items,
                                                                        idx+1, op+(i+1));
                items[i] = 0;
            }
        }
        printAllPermutationsApproach2CombinationTechnique(currentBox+1, totalBox, items, idx, op+"_");
    }
}
