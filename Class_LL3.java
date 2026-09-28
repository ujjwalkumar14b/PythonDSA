public class Class_LL3 {

    public static class Node{
        int data;
        Node prev;
        Node next;

        public Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void printReverse(){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    
    public static void main(String[] args){
        
        Class_LL3 ll = new Class_LL3();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();
        ll.printReverse();
    }
}
