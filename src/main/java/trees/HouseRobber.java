package trees;

//https://leetcode.com/problems/house-robber-iii/description/
public class HouseRobber {
    public static void main(String[] args) {
        BinaryTreeNode node = getTree();
        Data data = test(node);
        System.out.println(Math.max(data.excl, data.incl));
    }
    private static Data test(BinaryTreeNode node){
        if(node == null){
            return new Data(0,0);
        }
        Data left = test(node.left);
        Data right = test(node.right);

        int myIncl = node.data + left.excl + right.excl;
        int myExcl = Math.max(left.incl, left.excl) + Math.max(right.incl, right.excl);

        return new Data(myIncl, myExcl);
    }

    static class Data{
        int incl;
        int excl;

        Data(int incl, int excl){
            this.incl = incl;
            this.excl = excl;
        }
    }

    private static BinaryTreeNode getTree(){
        BinaryTreeNode mid6 = new BinaryTreeNode(6);
        BinaryTreeNode mid7 = new BinaryTreeNode(7);
        BinaryTreeNode mid8 = new BinaryTreeNode(8);
        BinaryTreeNode mid9 = new BinaryTreeNode(9);
        BinaryTreeNode mid5 = new BinaryTreeNode(5);
        BinaryTreeNode mid4 = new BinaryTreeNode(4);
        BinaryTreeNode mid2 = new BinaryTreeNode(2);
        BinaryTreeNode mid3 = new BinaryTreeNode(3);
        BinaryTreeNode root = new BinaryTreeNode(1);

        mid5.left = mid6;
        mid5.right = mid7;
        mid4.left = mid8;
        mid4.right = mid9;
        mid3.left = mid4;
        mid3.right = mid5;
        root.left = mid2;
        root.right = mid3;

        return root;
    }
}
