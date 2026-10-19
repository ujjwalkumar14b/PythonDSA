def maximum_element(lst):
    maximum = float("-inf")
    for num in lst:
        maximum = max(maximum, num)
    return maximum


def swap_number(lst, idx1, idx2):
    lst[idx1], lst[idx2] = lst[idx2], lst[idx1]


def most_water(height):
    left = 0
    right = len(height) - 1
    most_water_val = 0

    while left < right:
        min_height = min(height[left], height[right])
        width = right - left
        curr_area = min_height * width
        most_water_val = max(most_water_val, curr_area)

        if height[left] < height[right]:
            left += 1
        else:
            right -= 1
    return most_water_val


def pair_sum(arr, target):
    left = 0
    right = len(arr) - 1
    while left < right:
        total_sum = arr[left] + arr[right]
        if total_sum == target:
            return True
        elif total_sum < target:
            left += 1
        else:
            right -= 1
    return False


def sorted_rotated(arr, target):
    return False


if __name__ == "__main__":
    print("ArrayList Class")

    lst = []

    lst.append(0)
    lst.append(1)  # add element append
    lst.append(2)
    lst.append(3)
    lst.insert(4, 4)  # insert at index
    print(lst)
    print(len(lst))
    print(lst[0])  # get element O(1)
    lst.pop(0)  # remove element at index
    print(lst)
    lst[2] = 4  # set element at index
    print(lst)
    print(3 in lst)  # contains element
    print("Maximum Element:", maximum_element(lst))

    nums = [0, 1, 2]
    swap_number(nums, 1, 2)
    print(nums)

    # sorting
    nums.sort()  # ascending order
    print(nums)
    nums.sort(reverse=True)  # descending order
    print(nums)

    main_list = []
    list1 = [1, 2]
    list2 = [3, 4]
    main_list.append(list1)
    main_list.append(list2)

    print(main_list)

    for i in range(len(main_list)):
        curr_list = main_list[i]
        for j in range(len(curr_list)):
            print(curr_list[j], end=" ")
        print()

    height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    print(most_water(height))

    arr = [1, 2, 3, 4, 5]
    print(pair_sum(arr, 5))

    sorted_rotated_arr = [6, 5, 4, 1, 2, 3]
    print(sorted_rotated(sorted_rotated_arr, 5))
