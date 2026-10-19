class ClassPattern:
    @staticmethod
    def main():
        # ---- Pattern printing (inverted triangle) ----
        # for i in range(4):
        #     for j in range(4 - i):
        #         print("*", end="")
        #     print()

        # ---- Data types and basic operations ----
        # bytes_val = 8
        # ch = 'u'
        # string_val = "u"
        # is_equal = None
        #
        # a = 10
        # b = 20
        # sum_val = a + b
        # print(sum_val)

        # This is a single-line comment
        """
        This is a multi-line comment
        """

        # ---- Input in Python ----
        # user_input = input("Enter number: ")
        # print(user_input)

        # a9 = int(input())
        # b9 = int(input())
        # print(a9 + b9)
        # print(a9 * b9)

        # ---- Type conversion / Type casting ----
        # marks = int(99.99)
        # print(marks)
        #
        # a_char = 'a'
        # anum = ord(a_char)
        # print(anum)
        # print(ord(a_char))

        # ---- Increment operators (Note: Python doesn't support ++/--) ----
        # incr = 0
        # print(incr)
        # incr += 1  # Equivalent to post/pre increment handling
        # print(incr)

        # ---- Square pattern ----
        # for i in range(4):
        #     for j in range(4):
        #         print("*", end="")
        #     print()

        # ---- Reverse a number ----
        # num = 10899
        # reversed_num = 0
        # while num > 0:
        #     rem = num % 10
        #     reversed_num = reversed_num * 10 + rem
        #     num = num // 10
        # print(reversed_num)

        # ---- Check whether a number is prime or not ----
        # num = 7
        # is_prime = True
        # for i in range(2, num):
        #     if num % i == 0:
        #         is_prime = False
        #         break
        # if is_prime:
        #     print("It is prime")
        # else:
        #     print("It is not prime")

        # ---- Active Character Pattern Generation ----
        # *
        # **
        # ***
        # **** (using incrementing characters)
        character_ord = ord('A')
        for i in range(4):
            for j in range(i + 1):
                print(chr(character_ord), end="")
                character_ord += 1
            print()


if __name__ == "__main__":
    ClassPattern.main()
