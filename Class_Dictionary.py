if __name__ == "__main__":
    hm = {}

    hm[1] = 1
    hm[2] = 4
    hm[3] = 9
    hm[4] = 16

    print(hm)
    print(hm.get(2))
    print(2 in hm)
    print(hm.pop(2, None))  # Removes key and returns its value (or None if not found)
    print(2 in hm)
