def print_2d(matrix):
    for row in matrix:
        print(" ".join(map(str, row)))


# Returns both row and column indices, or None if not found
def search_2d(matrix, target):
    if not matrix or not matrix[0]:
        return None
    row = len(matrix)
    column = len(matrix[0])

    for i in range(row):
        for j in range(column):
            if matrix[i][j] == target:
                return [i, j]  # Return list with coordinates
    return None  # Target not found


def spiral_matrix(grid):
    result = []
    if not grid or not grid[0]:
        return result

    top = 0
    bottom = len(grid) - 1
    left = 0
    right = len(grid[0]) - 1

    while top <= bottom and left <= right:
        # Traverse top row from left to right
        for i in range(left, right + 1):
            result.append(grid[top][i])
        top += 1

        # Traverse right column from top to bottom
        for i in range(top, bottom + 1):
            result.append(grid[i][right])
        right -= 1

        # Traverse bottom row from right to left (if still valid)
        if top <= bottom:
            for i in range(right, left - 1, -1):
                result.append(grid[bottom][i])
            bottom -= 1

        # Traverse left column from bottom to top (if still valid)
        if left <= right:
            for i in range(bottom, top - 1, -1):
                result.append(grid[i][left])
            left += 1

    return result


def search_sorted_grid(sorted_grid, target):
    if not sorted_grid or not sorted_grid[0]:
        return [-1, -1]

    row = 0
    col = len(sorted_grid[0]) - 1

    while row < len(sorted_grid) and col >= 0:
        if sorted_grid[row][col] == target:
            return [row, col]
        elif target < sorted_grid[row][col]:
            col -= 1
        else:
            row += 1
    return [-1, -1]


if __name__ == "__main__":
    # Equivalent to Java's Scanner input for a 2x3 matrix
    print("Enter 6 integers for a 2x3 matrix (e.g., enter space-separated numbers per row):")
    matrix = []
    for i in range(2):
        row_input = list(map(int, input(f"Row {i + 1}: ").split()))
        matrix.append(row_input)

    print("\nMatrix:")
    print_2d(matrix)

    target = 3
    result = search_2d(matrix, target)

    if result is not None:
        print(f"\nTarget {target} found at row {result[0]}, column {result[1]}")
    else:
        print(f"\nTarget {target} not found.")

    grid = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    print(spiral_matrix(grid))

    sorted_grid = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]
    print(search_sorted_grid(sorted_grid, 7))
