package trees;

public class ValidPreorderSerialization {

    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        boolean isValid = isValidSerialization(preorder);
        System.out.println(isValid);
    }
    public static boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }

    // myapproach using stack. it fails for second last test case 151/152. for input 1,#,#,#,#
    /*
    * public boolean isValidSerialization(String preorder) {
        String[] cArray = preorder.split(",");
        int length = cArray.length;
       // System.out.println("length:"+length);

        if(length == 1 && cArray[0].equals("#")) return true;
        if(cArray.length<3 || !cArray[length-1].equals("#") || !cArray[length-2].equals("#")){
            System.out.println("in first if");
            return false;
        }
        Stack<Data> nodeValues = new Stack<>();
        for(int i=0; i<cArray.length; i++){
            String c = cArray[i];
            if(nodeValues.isEmpty() && c.equals("#")) return false;
            //System.out.println("string:"+c);
            if(!c.equals("#")){
                //System.out.println("in if");
                stackOps(nodeValues);
                Data data = new Data(Integer.parseInt(c), 0);
                nodeValues.push(data);
            }
            else{
               // System.out.println("in else");
                stackOps(nodeValues);
            }
        }
       // System.out.println(nodeValues);
        return nodeValues.isEmpty();
    }

    private void stackOps(Stack<Data> nodeValues){
        if(!nodeValues.isEmpty()){
            Data prev = nodeValues.peek();
            prev.count++;
            if(prev.count >= 2){
                nodeValues.pop();
            }

        }
    }
    class Data{
        int val;
        int count;
        Data(int val, int count){
            this.val = val;
            this.count = count;
        }

        public String toString(){
            return "val:"+val+" count:"+count;
        }
    }
    * */
}
