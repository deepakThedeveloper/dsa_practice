package recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int noOfPlates = 3;
        towerOfHanoi(noOfPlates, 'a', 'b', 'c');
    }

    private static void towerOfHanoi(int noOfPlates, char a, char b, char c) {
        if(noOfPlates == 0) return;

        towerOfHanoi(noOfPlates-1, a, c, b);
        System.out.println("moving :"+noOfPlates +" from:"+a+" to:"+b+" via:"+c);
        towerOfHanoi(noOfPlates-1, c, b, a);

    }
}
