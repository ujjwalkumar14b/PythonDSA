def binary_search(arr, target, left, right):
    if left > right:
        return -1
    mid = left + (right - left) // 2

    if arr[mid] == target:
        return mid
    elif arr[mid] > target:
        return binary_search(arr, target, left, mid - 1)
    else:
        return binary_search(arr, target, mid + 1, right)


def linear_search(arr, target):
    for i in range(len(arr)):
        if arr[i] == target:
            return i
    return -1


def find_max(arr):
    max_num = float("-inf")
    for num in arr:
        if num > max_num:
            max_num = num
    return max_num


def print_reversed(arr):
    print("Reversed Array: ", end="")
    for i in range(len(arr) - 1, -1, -1):
        print(arr[i], end=" ")
    print()


def print_pairs(arr):
    print("Pairs in array:")
    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            print(f"({arr[i]},{arr[j]})", end=" ")
        print()


def max_subarray_brute_force(arr):
    max_sum = float("-inf")
    for i in range(len(arr)):
        current_sum = 0
        for j in range(i, len(arr)):
            current_sum += arr[j]
            max_sum = max(max_sum, current_sum)
    return max_sum


def max_subarray_prefix_sum(arr):
    if not arr:
        return 0
    prefix = [0] * len(arr)
    prefix[0] = arr[0]
    for i in range(1, len(arr)):
        prefix[i] = prefix[i - 1] + arr[i]

    max_sum = float("-inf")
    for i in range(len(arr)):
        for j in range(i, len(arr)):
            current_sum = prefix[j] if i == 0 else prefix[j] - prefix[i - 1]
            max_sum = max(max_sum, current_sum)
    return max_sum


def trapping_water(heights):
    if not heights:
        return 0
    trapped_water = 0
    n = len(heights)
    left_max = [0] * n
    right_max = [0] * n
    left_max[0] = heights[0]
    right_max[n - 1] = heights[n - 1]

    for i in range(1, n):
        left_max[i] = max(heights[i], left_max[i - 1])

    for i in range(n - 2, -1, -1):
        right_max[i] = max(heights[i], right_max[i + 1])

    for i in range(n):
        water_level = min(left_max[i], right_max[i])
        trapped_water += water_level - heights[i]
    return trapped_water


def best_time_to_buy_stocks(prices):
    if not prices:
        return 0
    min_price = float("inf")
    max_profit = 0

    for i in range(1, len(prices)):
        profit = prices[i] - min_price
        max_profit = max(max_profit, profit)
        min_price = min(min_price, prices[i])
    return max_profit


def bubble_sort(nums):
    n = len(nums)
    for i in range(n - 1):
        for j in range(n - i - 1):
            if nums[j] > nums[j + 1]:
                nums[j], nums[j + 1] = nums[j + 1], nums[j]
    return nums


def selection_sort(nums):
    n = len(nums)
    for i in range(n - 1):
        min_pos = i
        for j in range(i + 1, n):
            if nums[min_pos] > nums[j]:
                min_pos = j
        nums[min_pos], nums[i] = nums[i], nums[min_pos]
    return nums


def insertion_sort(nums):
    n = len(nums)
    for i in range(1, n):
        key = nums[i]
        j = i - 1
        while j >= 0 and nums[j] > key:
            nums[j + 1] = nums[j]
            j -= 1
        nums[j + 1] = key
    return nums


if __name__ == "__main__":
    nums1 = [1, 2, 3, 4]
    nums2 = [1, 2]

    print(nums1)
    print(nums2)

    target = 3
    print("Linear Search index:", linear_search(nums1, target))
    print("Max number:", find_max(nums1))
    print("Binary Search index:", binary_search(nums1, target, 0, len(nums1) - 1))

    print_reversed(nums1)
    print_pairs(nums1)
    print("Max Subarray (Brute Force):", max_subarray_brute_force(nums1))
    print("Max Subarray (Prefix Sum):", max_subarray_prefix_sum(nums1))

    heights = [4, 2, 0, 6, 3, 2, 5]
    print(trapping_water(heights))

    prices = [7, 1, 5, 3, 6, 4]
    print(trapping_water(prices))

    array = [5, 4, 1, 3, 2]
    print("Bubble Sort:", bubble_sort(array.copy()))
    print("Selection Sort:", selection_sort(array.copy()))
    print("Insertion Sort:", insertion_sort(array.copy()))

    array.sort()
    print("Inbuilt Sort:", array)
