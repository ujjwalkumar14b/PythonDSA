from collections import deque


class Node:

    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


class BinaryTree:

    @staticmethod
    def build_tree(nodes):
        # Using a helper class or list wrapper to hold mutable index state
        if not hasattr(BinaryTree, "_idx"):
            BinaryTree._idx = -1

        BinaryTree._idx += 1
        if BinaryTree._idx >= len(nodes) or nodes[BinaryTree._idx] == -1:
            return None

        new_node = Node(nodes[BinaryTree._idx])
        new_node.left = BinaryTree.build_tree(nodes)
        new_node.right = BinaryTree.build_tree(nodes)
        return new_node

    @staticmethod
    def pre_order(root):
        if root is None:
            return
        print(root.data, end=" ")
        BinaryTree.pre_order(root.left)
        BinaryTree.pre_order(root.right)

    @staticmethod
    def in_order(root):
        if root is None:
            return
        BinaryTree.in_order(root.left)
        print(root.data, end=" ")
        BinaryTree.in_order(root.right)

    @staticmethod
    def post_order(root):
        if root is None:
            return
        BinaryTree.post_order(root.left)
        BinaryTree.post_order(root.right)
        print(root.data, end=" ")

    @staticmethod
    def level_order(root):
        if root is None:
            return
        q = deque()
        q.append(root)
        q.append(None)

        while q:
            curr_node = q.popleft()
            if curr_node is None:
                print()
                if not q:
                    break
                else:
                    q.append(None)
            else:
                print(curr_node.data, end=" ")
                if curr_node.left is not None:
                    q.append(curr_node.left)
                if curr_node.right is not None:
                    q.append(curr_node.right)

    @staticmethod
    def height(root):
        if root is None:
            return 0
        lh = BinaryTree.height(root.left)
        rh = BinaryTree.height(root.right)
        return max(lh, rh) + 1

    @staticmethod
    def count_node(root):
        if root is None:
            return 0
        lcount = BinaryTree.count_node(root.left)
        rcount = BinaryTree.count_node(root.right)
        return lcount + rcount + 1

    @staticmethod
    def sum_node(root):
        if root is None:
            return 0
        lsum = BinaryTree.sum_node(root.left)
        rsum = BinaryTree.sum_node(root.right)
        return lsum + rsum + root.data

    class Info:

        def __init__(self, diam, ht):
            self.diam = diam
            self.ht = ht

    @staticmethod
    def diameter(root):
        if root is None:
            return BinaryTree.Info(0, 0)
        left_info = BinaryTree.diameter(root.left)
        right_info = BinaryTree.diameter(root.right)

        diam = max(
            max(left_info.diam, right_info.diam),
            left_info.ht + right_info.ht + 1,
        )
        ht = max(left_info.ht, right_info.ht) + 1
        return BinaryTree.Info(diam, ht)

    @staticmethod
    def k_level(root, level, k):
        if root is None:
            return
        if level == k:
            print(root.data, end=" ")
            return
        BinaryTree.k_level(root.left, level + 1, k)
        BinaryTree.k_level(root.right, level + 1, k)

    @staticmethod
    def lca(root, n1, n2):
        if root is None or root.data == n1 or root.data == n2:
            return root
        left_lca = BinaryTree.lca(root.left, n1, n2)
        right_lca = BinaryTree.lca(root.right, n1, n2)

        if left_lca is None:
            return right_lca
        if right_lca is None:
            return left_lca
        return root


if __name__ == "__main__":
    print("Binary Tree")
    nodes = [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]

    BinaryTree._idx = -1  # Reset index for tree builder
    tree = BinaryTree()
    root = tree.build_tree(nodes)
    print("Root Node:", root.data)

    print("Pre-order: ", end="")
    tree.pre_order(root)
    print()

    print("In-order: ", end="")
    tree.in_order(root)
    print()

    print("Post-order: ", end="")
    tree.post_order(root)
    print()

    print("Level-order:")
    tree.level_order(root)

    print("Max height:", tree.height(root))
    print("Count nodes:", tree.count_node(root))
    print("Sum nodes:", tree.sum_node(root))

    # Diameter is number of nodes in longest path between 2 leaves
    print("Diameter:", tree.diameter(root).diam)

    k = 3
    BinaryTree.k_level(root, 1, k)
    print()
    print(tree.lca(root, 4, 5).data)
