class Node:

    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def build_tree(root, val):
    if root is None:
        return Node(val)
    if val < root.data:
        root.left = build_tree(root.left, val)
    else:
        root.right = build_tree(root.right, val)
    return root


def in_order(root):
    if root is None:
        return
    in_order(root.left)
    print(root.data, end=" ")
    in_order(root.right)


def is_found(root, val):
    if root is None:
        return False
    if root.data == val:
        return True
    if val < root.data:
        return is_found(root.left, val)
    else:
        return is_found(root.right, val)


def delete(root, val):
    if root is None:
        return None
    if val < root.data:
        root.left = delete(root.left, val)
    elif val > root.data:
        root.right = delete(root.right, val)
    else:
        return None
    return root


def mirror_bst(root):
    if root is None:
        return root
    temp = mirror_bst(root.left)
    root.left = mirror_bst(root.right)
    root.right = temp
    return root


if __name__ == "__main__":
    values = [8, 5, 3, 6, 10, 11]
    root = None

    for i in values:
        root = build_tree(root, i)

    in_order(root)
    print()
    print(is_found(root, 7))

    mirror_bst(root)
    in_order(root)
    print()
