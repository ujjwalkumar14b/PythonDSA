public class Class_LL2 {
    
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    // Helper method to print custom linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Fixed: Accepts head as a parameter
    public static Node getMid(Node head) {
        if (head == null) return head;
        
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node merge(Node head1, Node head2) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        
        // Fixed: Used head2 instead of head1
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        
        return mergeLL.next;
    }
    
    public static Node mergeSort(Node head) {
        // Fixed: Base condition now checks if list is empty or has 1 node
        if (head == null || head.next == null) {
            return head;
        }

        // Find mid
        Node mid = getMid(head);

        // Divide list into left and right halves
        Node rightHead = mid.next;
        mid.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Merge sorted halves
        return merge(newLeft, newRight);
    }
    public static Node zigZag(Node head){
        if(head == null || head.next == null){
            return head;
        }

        // find mid Node
        Node mid = getMid(head);
        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //alternate merge - zig zag merge
        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        while(left != null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
        return head;
    }
    public static void main(String[] args) {
        // Build custom custom linked list: 4 -> 1 -> 2 -> 3
        head = new Node(4);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);

        System.out.print("Original List: ");
        printList(head);

        head = mergeSort(head);

        System.out.print("Sorted List: ");
        printList(head);

        // zig zag linked list

        head = zigZag(head);
        printList(head);
    } 
}