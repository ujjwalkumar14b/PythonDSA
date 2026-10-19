import math


class ClassString:

    @staticmethod
    def is_palindrome(string_val):
        left = 0
        right = len(string_val) - 1

        while left < right:
            if string_val[left] != string_val[right]:
                return False
            left += 1
            right -= 1
        return True

    @staticmethod
    def shortest_path(path):
        x = 0
        y = 0
        for i in range(len(path)):
            if path[i] == 'N':
                y += 1
            elif path[i] == 'E':
                x += 1
            elif path[i] == 'S':
                y -= 1
            else:
                x -= 1
        return float(math.sqrt(int(math.pow(x - 0, 2)) + int(math.pow(y - 0, 2))))

    @staticmethod
    def sub_string(s_str, start, end):
        sub_str = ""
        for i in range(start, end):
            sub_str += s_str[i]
        return sub_str

    @staticmethod
    def main():
        # str1 = "abcd"
        # str2 = "abcd"
        # Strings are immutable i.e., they do not change

        # name1 = input()
        # name2 = input()  # Note: input() handles newlines automatically in Python
        # print(f"{name1} {name2}")

        # full_name = "Ujjwal Kumar"
        # print(len(full_name))

        # Concatenation
        first_name = "Ujjwal"
        last_name = "Kumar"
        full_name = first_name + " " + last_name
        print(full_name)
        print(full_name[0])
        print(ClassString.is_palindrome("racecar"))
        print(ClassString.is_palindrome("madam"))
        print(ClassString.shortest_path("WNEENESENNN"))

        # Substring
        text_str = "HelloWorld"
        print(ClassString.sub_string(text_str, 0, 5))
        print(text_str[0:5])  # Pythonic slicing alternative


if __name__ == "__main__":
    ClassString.main()
