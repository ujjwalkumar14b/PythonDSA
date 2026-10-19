def even_or_odd(num):
    if (num & 1) == 0:
        return "Even"
    return "Odd"


# Bit Manipulation Operations
# Get ith bit
def get_ith(n, i):
    bit_mask = 1 << i
    if (n & bit_mask) == 0:
        return 0
    return 1


# Set ith bit
# Clear ith bit


if __name__ == "__main__":
    print("AND:", 5 & 6)
    print("OR:", 5 | 6)
    print("XOR:", 5 ^ 6)
    print("1's:", ~5)  # -6
    print("Num to Binary:", bin(5)[2:])  # bin(5) returns '0b101', slice removes '0b'
    print("Left Shift:", 5 << 2)
    print("Right Shift:", 5 >> 2)
    print(even_or_odd(5))

    print(get_ith(5, 2))
