import java.util.*;

public class Class_BT {
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
    
    static class BinaryTree{

        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
        public static void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        } 
        public static void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }  
        public static void levelOrder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data + " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        } 
        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);

            return Math.max(lh, rh) + 1;
        }   
        public static int countNode(Node root){
            if(root == null){
                return 0;
            }
            int lcount = countNode(root.left);
            int rcount = countNode(root.right);

            return lcount + rcount + 1;
        } 
        public static int sumNode(Node root){
            if(root == null){
                return 0;
            }
            int lsum = sumNode(root.left);
            int rsum = sumNode(root.right);

            return lsum + rsum + root.data;
        } 
        static class Info{
            int diam;
            int ht;

            public Info(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }
        public static Info diameter(Node root){
            if(root == null){
                return new Info(0,0);
            }
            Info leftInfo = diameter(root.left);
            Info rightInfo = diameter(root.right);

            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

            return new Info(diam, ht);
        }
        public static void kLevel(Node root, int level, int k){
            if(root == null){
                return;
            }
            if(level == k){
                System.out.print(root.data + " ");
                return;
            }
            kLevel(root.left, level+1, k);
            kLevel(root.right, level+1, k);
        }
        public static Node lca(Node root, int n1, int n2){
            if(root == null || root.data == n1 || root.data == n2){
                return root;
            }
            Node leftLCA = lca(root.left, n1, n2);
            Node rightLCA = lca(root.right, n1, n2);

            if(leftLCA == null){
                return rightLCA;
            }
            if(rightLCA == null){
                return leftLCA;
            }
            return root;
        }
    }
    public static void main(String[] args){
        System.out.println("Binary Tree");
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Root Node: " + root.data);

        System.out.print("Pre-order: ");
        tree.preOrder(root);
        System.out.println();
        System.out.print("In-order: ");
        tree.inOrder(root);
        System.out.println();
        System.out.print("Post-order: ");
        tree.postOrder(root);
        System.out.println();
        System.out.println("Level-order: ");
        tree.levelOrder(root);
        System.out.println();
        System.out.println("Max height: " + tree.height(root));
        System.out.println("Count nodes: " + tree.countNode(root));
        System.out.println("Sum nodes: " + tree.sumNode(root));
        // Diameter is no of nodes in longest path btw 2 leaves
        System.out.println("Diameter: " + tree.diameter(root).diam);

        int k = 3;
        BinaryTree.kLevel(root, 1, k);
        System.out.println();
        System.out.println(tree.lca(root, 4, 5).data);
    }
}
