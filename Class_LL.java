public class Class_LL{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;
    public static Node tail;
    public int size;

    public void addFirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }

    public void addAtIndex(int index,int data){
        if(index==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        if(newNode.next==null){
            tail=newNode;
        }
    }

    public int removeFirst(){
        if(size==0){
            System.out.println("Empty LinkedList");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size==0){
            System.out.println("Empty LinkedList");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }

    public int search(int target){
        Node temp=head;
        int index=0;
        while(temp!=null){
            if(temp.data==target){
                return index;
            }
            temp=temp.next;
            index++;
        }
        return -1;
    }

    public int helper(Node head,int target){
        if(head==null){
            return -1;
        }
        if(head.data==target){
            return 0;
        }
        int index=helper(head.next,target);
        if(index==-1){
            return -1;
        }
        return index+1;
    }

    public int searchRecursive(int target){
        return helper(head,target);
    }

    public void reverse(){
        if(head==null||size==1){
            return;
        }
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public void removeNthLast(int n){
        int sz=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        if(n==sz){
            head=head.next;
            size--;
            return;
        }
        int index=sz-n;
        Node prev=head;
        int i=0;
        while(i<index-1){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        if(prev.next==null){
            tail=prev;
        }
        size--;
    }

    public boolean isPalindrome(){
        if(head==null||head.next==null){
            return true;
        }

        Node slow=head;
        Node fast=head;

        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        Node prev=null;
        Node curr=slow;

        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node left=head;
        Node right=prev;

        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }

        return true;
    }

    public static boolean detectCycle(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    } 

    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }
        // find meeting point
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    } 

    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data + "-");
            temp=temp.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args){

        Class_LL ll=new Class_LL();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addAtIndex(0,0);
        ll.addAtIndex(4,4);
        System.out.print("Adding Element: ");
        ll.print();
        System.out.println("Size of LinkedList: "+ll.size);

        
        ll.removeFirst();
        ll.removeLast();
        ll.removeNthLast(2);
        System.out.print("Removing Element: ");
        ll.print();

        System.out.println("Iterative Search: " + ll.search(3));
        System.out.println("Recursive Search: " + ll.searchRecursive(3));

        ll.reverse();
        System.out.print("Reversing LinkedList: ");
        ll.print();

        ll.addFirst(3);
        ll.addFirst(1);
        ll.print();
        System.out.println("Is Palindrome: "+ ll.isPalindrome());


        head = new Node(10);
        Node temp = new Node(20);
        head.next = temp;
        head.next.next = new Node(30);
        head.next.next.next = temp;
        System.out.println("Detect Cycle: " + detectCycle());
        removeCycle();
        System.out.println("After removing Cycle: " + detectCycle());
    }
}