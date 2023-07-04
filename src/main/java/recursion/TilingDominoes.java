package recursion;

// in a block of ht 2 and length n return all possible ways of arranging a domino with 2m ht and 1m length when arranging it in
// horizontal and vertical format
public class TilingDominoes {
    public static void main(String[] args){
        int blockHt = 2, blockL = 4;
        int tileHt = 2, tileL = 1;

        int noOfWays = arrangeDominoe(blockHt, blockL, tileHt, tileL, "");
        System.out.println(noOfWays);
        System.out.println("================================");
        int noOfWays1 = arrangeDominoeBetterApproach(blockL, "");
        System.out.println(noOfWays1);
        System.out.println("================================");
        int noOfWays2 = arrangeDominoeWithMByNBetterApproach(blockL, 3, "");
        System.out.println(noOfWays2);
    }

    private static int arrangeDominoeBetterApproach(int blockLength, String op){
        if(blockLength == 0){
            System.out.println(op);
            return 1;
        }
        if(blockLength < 0) return 0;
        int vArrangement = arrangeDominoeBetterApproach(blockLength - 1, op+"V");
        int hArrangement = arrangeDominoeBetterApproach(blockLength - 2, op+"H");

        return vArrangement + hArrangement;
    }

    private static int arrangeDominoeWithMByNBetterApproach(int blockLength, int tileLength, String op){
        if(blockLength == 0){
            System.out.println(op);
            return 1;
        }
        if(blockLength < 0) return 0;
        int vArrangement = arrangeDominoeWithMByNBetterApproach(blockLength - 1, tileLength, op+"V");
        int hArrangement = arrangeDominoeWithMByNBetterApproach(blockLength - tileLength, tileLength, op+"H");

        return vArrangement + hArrangement;
    }

    private static int arrangeDominoe(int blockHt, int blockL, int tileHt, int tileL, String op){
        if(blockL == 0){
            System.out.println(op);
            return 1;
        }
        if(blockL < 0) return 0;
        int vArrangement = arrangeDominoe(blockHt - tileHt, blockL - tileL, tileHt, tileL, op+"V");
        int hArrangement = arrangeDominoe(blockHt - tileL, blockL - tileHt, tileHt, tileL, op+"H");

        return vArrangement + hArrangement;
    }
}
