import java.util.*;

public class Class_BST2 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildTree(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.data) {
            root.left = buildTree(root.left, val);
        } else {
            root.right = buildTree(root.right, val);
        }
        return root;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Helper method to collect elements in sorted order
    public static void getInOrder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        getInOrder(root.left, list);
        list.add(root.data);
        getInOrder(root.right, list);
    }

    // Overloaded to work directly with ArrayList
    public static Node sortedToBalanced(ArrayList<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        Node root = new Node(list.get(mid));
        root.left = sortedToBalanced(list, left, mid - 1);
        root.right = sortedToBalanced(list, mid + 1, right);
        return root;
    }

    public static Node sortedToBalanced(int arr[], int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        Node root = new Node(arr[mid]);
        root.left = sortedToBalanced(arr, left, mid - 1);
        root.right = sortedToBalanced(arr, mid + 1, right);
        return root;
    }

    public static Node bstToBalancedBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        // 1. Store in-order traversal (gives a sorted list)
        getInOrder(root, list);

        // 2. Build a balanced BST from the sorted list
        return sortedToBalanced(list, 0, list.size() - 1);
    }

    public static void main(String[] args) {
        int sorted[] = {3, 5, 6, 8, 10, 12};
        Node root = null;

        for (int i : sorted) {
            root = buildTree(root, i);
        }

        System.out.print("InOrder: ");
        inOrder(root);
        System.out.println();

        Node sortedRoot = sortedToBalanced(sorted, 0, sorted.length - 1);
        System.out.print("Sorted to Balanced PreOrder: ");
        preOrder(sortedRoot);
        System.out.println();

        // Unbalanced BST set up manually
        Node bst = new Node(8);
        bst.left = new Node(6);
        bst.left.left = new Node(5);
        bst.left.left.left = new Node(3);

        bst.right = new Node(10);
        bst.right.right = new Node(11);
        bst.right.right.right = new Node(12);

        // Balance the skewed tree
        bst = bstToBalancedBST(bst);

        System.out.print("Balanced BST PreOrder: ");
        preOrder(bst);
        System.out.println();
    }
}