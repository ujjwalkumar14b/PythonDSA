class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class ClassLL2:
    head = None

    # Helper method to print custom linked list
    @staticmethod
    def print_list(node_head):
        temp = node_head
        while temp is not None:
            print(f"{temp.data} -> ", end="")
            temp = temp.next
        print("null")

    # Accepts head as a parameter
    @staticmethod
    def get_mid(node_head):
        if node_head is None:
            return node_head
        
        slow = node_head
        fast = node_head.next

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
        return slow

    @staticmethod
    def merge(head1, head2):
        merge_ll = Node(-1)
        temp = merge_ll

        while head1 is not None and head2 is not None:
            if head1.data <= head2.data:
                temp.next = head1
                head1 = head1.next
            else:
                temp.next = head2
                head2 = head2.next
            temp = temp.next
        
        while head1 is not None:
            temp.next = head1
            head1 = head1.next
            temp = temp.next
        
        while head2 is not None:
            temp.next = head2
            head2 = head2.next
            temp = temp.next
        
        return merge_ll.next
    
    @staticmethod
    def merge_sort(node_head):
        # Base condition checks if list is empty or has 1 node
        if node_head is None or node_head.next is None:
            return node_head

        # Find mid
        mid = ClassLL2.get_mid(node_head)

        # Divide list into left and right halves
        right_head = mid.next
        mid.next = None

        new_left = ClassLL2.merge_sort(node_head)
        new_right = ClassLL2.merge_sort(right_head)

        # Merge sorted halves
        return ClassLL2.merge(new_left, new_right)

    @staticmethod
    def zig_zag(node_head):
        if node_head is None or node_head.next is None:
            return node_head

        # Find mid Node
        mid = ClassLL2.get_mid(node_head)
        
        # Reverse 2nd half
        curr = mid.next
        mid.next = None
        prev = None

        while curr is not None:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node

        # Alternate merge - zig zag merge
        left = node_head
        right = prev

        while left is not None and right is not None:
            next_l = left.next
            left.next = right
            next_r = right.next
            right.next = next_l

            left = next_l
            right = next_r
            
        return node_head


if __name__ == "__main__":
    # Build custom linked list: 4 -> 1 -> 2 -> 3
    ClassLL2.head = Node(4)
    ClassLL2.head.next = Node(1)
    ClassLL2.head.next.next = Node(2)
    ClassLL2.head.next.next.next = Node(3)

    print("Original List: ", end="")
    ClassLL2.print_list(ClassLL2.head)

    ClassLL2.head = ClassLL2.merge_sort(ClassLL2.head)

    print("Sorted List: ", end="")
    ClassLL2.print_list(ClassLL2.head)

    # Zig-zag linked list
    ClassLL2.head = ClassLL2.zig_zag(ClassLL2.head)
    ClassLL2.print_list(ClassLL2.head)
