class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None


class ClassLL3:
    head = None
    tail = None
    size = 0

    def print_list(self):
        temp = ClassLL3.head
        while temp is not None:
            print(f"{temp.data}<->", end="")
            temp = temp.next
        print("null")

    def print_reverse(self):
        temp = ClassLL3.tail
        while temp is not None:
            print(f"{temp.data}<->", end="")
            temp = temp.prev
        print("null")

    def add_first(self, data):
        new_node = Node(data)
        if ClassLL3.head is None:
            ClassLL3.head = ClassLL3.tail = new_node
            ClassLL3.size += 1
            return
        
        new_node.next = ClassLL3.head
        ClassLL3.head.prev = new_node
        ClassLL3.head = new_node
        ClassLL3.size += 1


if __name__ == "__main__":
    ll = ClassLL3()
    ll.add_first(3)
    ll.add_first(2)
    ll.add_first(1)
    ll.print_list()
    ll.print_reverse()
