class ClassStack:

    # Custom Stack using Python List
    class StackA:
        def __init__(self):
            self.list = []

        def is_empty(self):
            return len(self.list) == 0

        def push(self, data):
            self.list.append(data)

        def pop(self):
            if self.is_empty():
                return -1
            return self.list.pop()

        def peek(self):
            if self.is_empty():
                return -1
            return self.list[-1]

    # Node class for StackB
    class Node:
        def __init__(self, data):
            self.data = data
            self.next = None

    # Custom Stack using Linked List
    class StackB:
        def __init__(self):
            self.head = None

        def is_empty(self):
            return self.head is None

        def push(self, data):
            new_node = ClassStack.Node(data)
            new_node.next = self.head
            self.head = new_node

        def pop(self):
            if self.is_empty():
                return -1
            top = self.head.data
            self.head = self.head.next
            return top

        def peek(self):
            if self.is_empty():
                return -1
            return self.head.data

    # Prints stack elements without destroying the stack
    @staticmethod
    def print_stack(s):
        for i in range(len(s) - 1, -1, -1):
            print(s[i])

    # Pushes element to the bottom using a helper stack
    @staticmethod
    def push_bottom(s, data):
        helper = []
        while len(s) > 0:
            helper.append(s.pop())
        s.append(data)
        while len(helper) > 0:
            s.append(helper.pop())

    # Reverses string using Stack
    @staticmethod
    def reverse_string(string_val):
        s = []
        sb = []

        for char in string_val:
            s.append(char)
        while len(s) > 0:
            sb.append(s.pop())
        return "".join(sb)

    # Reverses a stack in-place using recursion
    @staticmethod
    def reverse_stack(s):
        if len(s) == 0:
            return
        top = s.pop()
        ClassStack.reverse_stack(s)
        ClassStack.push_bottom(s, top)

    @staticmethod
    def stock_span(stocks, span):
        s = []
        span[0] = 1
        s.append(0)

        for i in range(1, len(stocks)):
            curr_price = stocks[i]
            while len(s) > 0 and curr_price > stocks[s[-1]]:
                s.pop()
            if len(s) == 0:
                span[i] = i + 1
            else:
                prev_high = s[-1]
                span[i] = i - prev_high
            s.append(i)

    @staticmethod
    def greater_element(arr, next_greater):
        s = []
        for i in range(len(arr) - 1, -1, -1):
            while len(s) > 0 and arr[s[-1]] <= arr[i]:
                s.pop()
            if len(s) == 0:
                next_greater[i] = -1
            else:
                next_greater[i] = arr[s[-1]]
            s.append(i)

    @staticmethod
    def valid_parenthesis(str_val):
        s = []
        for char in str_val:
            if char in ('(', '{', '['):
                s.append(char)
            else:
                if len(s) == 0:
                    return False
                top = s[-1]
                if (top == '(' and char == ')') or \
                   (top == '{' and char == '}') or \
                   (top == '[' and char == ']'):
                    s.pop()
                else:
                    return False
        return len(s) == 0

    @staticmethod
    def duplicate_parentheses(str_val):
        s = []
        for char in str_val:
            if char == ')':
                count = 0
                while len(s) > 0 and s[-1] != '(':
                    s.pop()
                    count += 1
                if len(s) > 0:
                    s.pop()  # remove opening parenthesis
                if count < 1:
                    return True
            else:
                s.append(char)
        return False

    @staticmethod
    def max_area(arr):
        max_area_val = 0
        n = len(arr)
        nsr = [0] * n
        nsl = [0] * n
        s = []

        # Next Smaller Right
        for i in range(n - 1, -1, -1):
            while len(s) > 0 and arr[s[-1]] >= arr[i]:
                s.pop()
            if len(s) == 0:
                nsr[i] = n
            else:
                nsr[i] = s[-1]
            s.append(i)

        # Next Smaller Left
        s = []
        for i in range(n):
            while len(s) > 0 and arr[s[-1]] >= arr[i]:
                s.pop()
            if len(s) == 0:
                nsl[i] = -1
            else:
                nsl[i] = s[-1]
            s.append(i)

        # Current Area
        for i in range(n):
            height = arr[i]
            width = nsr[i] - nsl[i] - 1
            curr_area = height * width
            max_area_val = max(curr_area, max_area_val)

        return max_area_val


if __name__ == "__main__":
    s = []
    s.append(1)
    s.append(2)
    s.append(3)

    ClassStack.push_bottom(s, 0)
    print("Stack contents top-to-bottom:")
    ClassStack.print_stack(s)  # Outputs: 3, 2, 1, 0

    print("\nReversing stack in-place...")
    ClassStack.reverse_stack(s)
    ClassStack.print_stack(s)  # Outputs: 0, 1, 2, 3

    reversed_str = ClassStack.reverse_string("Ujjwal Kumar")
    print(f"\nReversed string: {reversed_str}")

    stocks = [100, 80, 60, 70, 60, 85, 100]
    span = [0] * len(stocks)
    ClassStack.stock_span(stocks, span)
    print(" ".join(map(str, span)))

    arr = [6, 8, 0, 1, 3]
    next_greater = [0] * len(arr)
    ClassStack.greater_element(arr, next_greater)
    print(" ".join(map(str, next_greater)))

    print("Valid Parenthesis:", ClassStack.valid_parenthesis("(){}[]"))
    print("Valid Parenthesis:", ClassStack.valid_parenthesis("[{()}]"))
    print("Valid Parenthesis:", ClassStack.valid_parenthesis("[{(}}]"))
    print("Duplicate Parenthesis:", ClassStack.duplicate_parentheses("((a+b))"))  # True
    print("Duplicate Parenthesis:", ClassStack.duplicate_parentheses("(a+b)"))  # False

    heights = [2, 1, 5, 6, 2, 3]
    print("Max Area in Histogram:", ClassStack.max_area(heights))
