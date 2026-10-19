class ClassRecursion:

    @staticmethod
    def print_inc(n):
        if n == 0:
            return
        ClassRecursion.print_inc(n - 1)
        print(n, end=" ")

    @staticmethod
    def print_dec(n):
        if n == 0:
            return
        print(n, end=" ")
        ClassRecursion.print_dec(n - 1)

    @staticmethod
    def factorial(n):
        if n == 1:
            return 1
        return n * ClassRecursion.factorial(n - 1)

    @staticmethod
    def sum_no(n):
        if n == 1:
            return 1
        return n + ClassRecursion.sum_no(n - 1)

    @staticmethod
    def fibonacci(n, a, b):
        if n == 0:
            return
        print(a, end=" ")
        ClassRecursion.fibonacci(n - 1, b, a + b)

    @staticmethod
    def sorted_array(arr, i):
        if i == len(arr) - 1:
            return True
        if arr[i] > arr[i + 1]:
            return False
        return ClassRecursion.sorted_array(arr, i + 1)

    @staticmethod
    def first_occurrence(nums, i, target):
        if i == len(nums):
            return -1
        if nums[i] == target:
            return i
        return ClassRecursion.first_occurrence(nums, i + 1, target)

    @staticmethod
    def last_occurrence(nums, i, target):
        if i < 0:
            return -1
        if nums[i] == target:
            return i
        return ClassRecursion.last_occurrence(nums, i - 1, target)

    @staticmethod
    def x_pow_n(x, n):
        if n == 1:
            return x
        return x * ClassRecursion.x_pow_n(x, n - 1)

    @staticmethod
    def tilling_problem(n):
        if n == 1 or n == 2:
            return n
        return ClassRecursion.tilling_problem(n - 1) + ClassRecursion.tilling_problem(n - 2)

    @staticmethod
    def remove_duplicates(s, i, new_str_list, seen_map):
        if i == len(s):
            print("".join(new_str_list))
            return
        
        curr_char = s[i]
        idx = ord(curr_char) - ord('a')
        
        if seen_map[idx]:
            ClassRecursion.remove_duplicates(s, i + 1, new_str_list, seen_map)
        else:
            seen_map[idx] = True
            new_str_list.append(curr_char)
            ClassRecursion.remove_duplicates(s, i + 1, new_str_list, seen_map)

    @staticmethod
    def friends_pairing(n):
        if n == 1 or n == 2:
            return n
        return ClassRecursion.friends_pairing(n - 1) + (n - 1) * ClassRecursion.friends_pairing(n - 2)

    @staticmethod
    def string_without_consecutive_1s(n, last_place, s):
        if n == 0:
            print(s)
            return
        ClassRecursion.string_without_consecutive_1s(n - 1, 0, s + "0")
        if last_place == 0:
            ClassRecursion.string_without_consecutive_1s(n - 1, 1, s + "1")


if __name__ == "__main__":
    print("Increasing: ", end="")
    ClassRecursion.print_inc(10)
    print()

    print("Decreasing: ", end="")
    ClassRecursion.print_dec(10)
    print()

    print("Factorial:", ClassRecursion.factorial(5))
    print("Sum of n natural no:", ClassRecursion.sum_no(5))
    
    print("Fibonacci: ", end="")
    ClassRecursion.fibonacci(5, 0, 1)
    print()

    nums = [0, 1, 2, 3, 3, 4, 5]
    print(ClassRecursion.sorted_array(nums, 0))
    print(ClassRecursion.first_occurrence(nums, 0, 3))
    print(ClassRecursion.last_occurrence(nums, len(nums) - 1, 3))
    print(ClassRecursion.x_pow_n(4, 4))
    print(ClassRecursion.tilling_problem(4))
    
    ClassRecursion.remove_duplicates("aabbcc", 0, [], [False] * 26)
    print(ClassRecursion.friends_pairing(3))
    
    ClassRecursion.string_without_consecutive_1s(3, 0, "")
