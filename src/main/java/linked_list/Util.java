package linked_list;

public class Util {

    public static Node1 getSinglyLinkedList(int size){
        Node1 head = null, prev = null;
        for(int i=0; i<size; i++){
            Node1 node = new Node1(i+1);
            if(prev != null) prev.next = node;
            prev = node;
            if(head == null) head = node;
        }
        return head;
    }

    public static void traverseSingly(Node1 head){
        System.out.println();
        System.out.println("=========================================");
        while (head!=null){
            System.out.print(head.val+"-->");
            head = head.next;
        }
        System.out.println();
        System.out.println("=========================================");
    }

    public static void traverseSingly(NodeRandom head){
        System.out.println();
        System.out.println("=========================================");
        while (head!=null){
            System.out.print(head.val+"-->");
            head = head.random;
        }
        System.out.println();
        System.out.println("=========================================");
    }

    public static Node1 getSortedList(int size, int start) {
        Node1 head = null, prev = null;
        int lastVal = start;
        for(int i=0; i<size; i++){
            Node1 node = new Node1(lastVal);
            if(head == null){
                head = node;
                prev = node;
            }
            else {
                prev.next = node;
                prev = prev.next;
            }
            lastVal += 3;
        }
        return head;
    }
}
