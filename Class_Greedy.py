def min_absolute_difference(a, b):
    a.sort()
    b.sort()
    pairs = [0] * 4

    for i in range(len(pairs)):
        pairs[i] = abs(a[i] - b[i])
    return pairs


def indian_coins(price):
    deno = [2000, 500, 100, 50, 20, 10, 5, 2, 1]
    count = 0

    while price > 0:
        for coin in deno:
            if coin <= price:
                price -= coin
                count += 1
                break
    return count


if __name__ == "__main__":
    a = [4, 1, 8, 7]
    b = [2, 3, 6, 5]
    print("Min Absolute Diff:", min_absolute_difference(a, b))
    print(indian_coins(121))

    n = 4
    m = 6

    cost_ver = [2, 1, 3, 1, 4]
    cost_hor = [4, 1, 2]

    cost_ver.sort(reverse=True)
    cost_hor.sort(reverse=True)

    h = 0
    v = 0
    hp = 1
    vp = 1
    cost = 0

    while h < len(cost_hor) and v < len(cost_ver):
        if cost_ver[v] <= cost_hor[h]:  # first horizontal cut because of min cost
            cost += cost_hor[h] * vp
            hp += 1
            h += 1
        else:
            cost += cost_ver[v] * hp
            vp += 1
            v += 1

    while h < len(cost_hor):
        cost += cost_hor[h] * vp
        hp += 1
        h += 1

    while v < len(cost_ver):
        cost += cost_ver[v] * hp
        vp += 1
        v += 1

    print(cost)
