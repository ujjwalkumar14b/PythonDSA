public class Class_BST1 {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node buildTree(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val < root.data){
            root.left = buildTree(root.left, val);
        }else{
            root.right = buildTree(root.right, val);
        }
        return root;
    }
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static boolean isFound(Node root, int val){
        if(root == null){
            return false;
        }
        if(root.data == val){
            return true;
        }
        if(val < root.data){
            return isFound(root.left, val);
        }else{
            return isFound(root.right, val);
        }
    }
    public static Node delete(Node root, int val){
        if(val < root.data){
            root.left = delete(root.left, val);
        }else if(val > root.data){
            root.right = delete(root.right, val);
        }else{
            return null;
        }
        return root;
    }
    public static Node mirrorBST(Node root){
        if(root == null){
            return root;
        }
        Node temp = mirrorBST(root.left);
        root.left = mirrorBST(root.right);
        root.right = temp;

        return root;
    }
    public static void main(String[] args){
        
        int values[] = {8,5,3,6,10,11};
        Node root = null;

        for (int i : values) {
            root = buildTree(root, i);
        }
        

        inOrder(root);
        System.out.println();
        System.out.println(isFound(root, 7));

        mirrorBST(root);
        inOrder(root);
    }
}
