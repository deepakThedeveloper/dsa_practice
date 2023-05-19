package recursion.todo;

public class DominoesInMatrix {
    public static void main(String[] args) {
        int mw = 3; // mat is 2*mh
        int count = dominoes(mw,"");
        System.out.println(count);
    }
    static int dh = 1;
    static int dw = 2;

    private static int dominoes(int mw, String op){
        if(mw<0) return 0;
        if(mw==0){
            System.out.println(op);
            return 1;
        }

        return dominoes(mw-dh, op+"v") + dominoes(mw-dw, op+"h");
    }
}
