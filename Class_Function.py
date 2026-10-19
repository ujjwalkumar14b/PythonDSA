import math


def sum_nums(a, b):  # parameters
    return a + b


def factorial(n):
    if n <= 1:
        return 1
    return n * factorial(n - 1)


def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(math.isqrt(n)) + 1):
        if n % i == 0:
            return False
    return True


def primes_range(n):
    for i in range(2, n):
        if is_prime(i):
            print(i, end=" ")
    print()


def bin_to_dec(n):
    power = 0
    decimal = 0

    while n > 0:
        last = n % 10
        decimal = decimal + (last * int(math.pow(2, power)))
        power += 1
        n = n // 10
    print(decimal)


def dec_to_bin(n):
    power = 0
    binary = 0

    while n > 0:
        last = n % 2
        binary = binary + (last * int(math.pow(10, power)))
        power += 1
        n = n // 2
    print(binary)


if __name__ == "__main__":
    # print(sum_nums(1, 2))  # arguments
    # print(factorial(5))
    # print(is_prime(16))
    # primes_range(16)
    bin_to_dec(101)
    dec_to_bin(5)
