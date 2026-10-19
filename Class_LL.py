class Class_LL:

    class Node:

        def __init__(self, data):
            self.data = data
            self.next = None

    # Static-like class attributes to mirror Java implementation
    head = None
    tail = None

    def __init__(self):
        self.size = 0

    def add_first(self, data):
        new_node = self.Node(data)
        self.size += 1
        if Class_LL.head is None:
            Class_LL.head = Class_LL.tail = new_node
            return
        new_node.next = Class_LL.head
        Class_LL.head = new_node

    def add_last(self, data):
        new_node = self.Node(data)
        self.size += 1
        if Class_LL.head is None:
            Class_LL.head = Class_LL.tail = new_node
            return
        Class_LL.tail.next = new_node
        Class_LL.tail = new_node

    def add_at_index(self, index, data):
        if index == 0:
            self.add_first(data)
            return
        new_node = self.Node(data)
        self.size += 1
        temp = Class_LL.head
        i = 0
        while i < index - 1:
            temp = temp.next
            i += 1
        new_node.next = temp.next
        temp.next = new_node
        if new_node.next is None:
            Class_LL.tail = new_node

    def remove_first(self):
        if self.size == 0:
            print("Empty LinkedList")
            return float("-inf")
        elif self.size == 1:
            val = Class_LL.head.data
            Class_LL.head = Class_LL.tail = None
            self.size = 0
            return val
        val = Class_LL.head.data
        Class_LL.head = Class_LL.head.next
        self.size -= 1
        return val

    def remove_last(self):
        if self.size == 0:
            print("Empty LinkedList")
            return float("-inf")
        elif self.size == 1:
            val = Class_LL.head.data
            Class_LL.head = Class_LL.tail = None
            self.size = 0
            return val
        prev = Class_LL.head
        for i in range(self.size - 2):
            prev = prev.next
        val = prev.next.data
        prev.next = None
        Class_LL.tail = prev
        self.size -= 1
        return val

    def search(self, target):
        temp = Class_LL.head
        index = 0
        while temp is not None:
            if temp.data == target:
                return index
            temp = temp.next
            index += 1
        return -1

    def helper(self, node, target):
        if node is None:
            return -1
        if node.data == target:
            return 0
        index = self.helper(node.next, target)
        if index == -1:
            return -1
        return index + 1

    def search_recursive(self, target):
        return self.helper(Class_LL.head, target)

    def reverse(self):
        if Class_LL.head is None or self.size == 1:
            return
        prev = None
        curr = Class_LL.tail = Class_LL.head
        while curr is not None:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node
        Class_LL.head = prev

    def remove_nth_last(self, n):
        sz = 0
        temp = Class_LL.head
        while temp is not None:
            temp = temp.next
            sz += 1
        if n == sz:
            Class_LL.head = Class_LL.head.next
            self.size -= 1
            return
        index = sz - n
        prev = Class_LL.head
        i = 0
        while i < index - 1:
            prev = prev.next
            i += 1
        prev.next = prev.next.next
        if prev.next is None:
            Class_LL.tail = prev
        self.size -= 1

    def is_palindrome(self):
        if Class_LL.head is None or Class_LL.head.next is None:
            return True

        slow = Class_LL.head
        fast = Class_LL.head

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

        prev = None
        curr = slow

        while curr is not None:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node

        left = Class_LL.head
        right = prev

        while right is not None:
            if left.data != right.data:
                return False
            left = left.next
            right = right.next

        return True

    @staticmethod
    def detect_cycle():
        slow = Class_LL.head
        fast = Class_LL.head

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

            if slow == fast:
                return True
        return False

    @staticmethod
    def remove_cycle():
        slow = Class_LL.head
        fast = Class_LL.head
        cycle = False

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

            if slow == fast:
                cycle = True
                break
        if not cycle:
            return
        # find meeting point
        slow = Class_LL.head
        prev = None
        while slow != fast:
            prev = fast
            slow = slow.next
            fast = fast.next
        prev.next = None

    def print_list(self):
        temp = Class_LL.head
        while temp is not None:
            print(temp.data, end="-")
            temp = temp.next
        print("null")


if __name__ == "__main__":
    ll = Class_LL()
    ll.add_first(2)
    ll.add_first(1)
    ll.add_last(3)
    ll.add_at_index(0, 0)
    ll.add_at_index(4, 4)
    print("Adding Element: ", end="")
    ll.print_list()
    print("Size of LinkedList:", ll.size)

    ll.remove_first()
    ll.remove_last()
    ll.remove_nth_last(2)
    print("Removing Element: ", end="")
    ll.print_list()

    print("Iterative Search:", ll.search(3))
    print("Recursive Search:", ll.search_recursive(3))

    ll.reverse()
    print("Reversing LinkedList: ", end="")
    ll.print_list()

    ll.add_first(3)
    ll.add_first(1)
    ll.print_list()
    print("Is Palindrome:", ll.is_palindrome())

    Class_LL.head = Class_LL.Node(10)
    temp = Class_LL.Node(20)
    Class_LL.head.next = temp
    Class_LL.head.next.next = Class_LL.Node(30)
    Class_LL.head.next.next.next = temp
    print("Detect Cycle:", Class_LL.detect_cycle())
    Class_LL.remove_cycle()
    print("After removing Cycle:", Class_LL.detect_cycle())
