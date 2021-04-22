/****************
 Tree data structure implementation in java  
 A tree is a hierarchial data structure containing parent nodes and child nodes
 A node is represented as a class in java containing the data value and the referebce to the child nodes
 
class Node {
    int key;
    Node left;
    Node right;

    Node(int key) {
        this.key = key;
    }
}
  
*****************/

package DS.Tree; // Appropriate package

class Tree {
    public static void preorder(Node root) { // first root then left child then right child
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(Node root) { // first left child then right child then root
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }

    public static int getsize(Node root) { // Count the number of nodes in the tree
        if (root == null)
            return 0;
        else
            return 1 + getsize(root.left) + getsize(root.right);
    }

    public int getmax(Node root) { // getting the maximum element in the tree
        if (root == null)
            return Integer.MIN_VALUE;
        else
            return Math.max(root.key, Math.max(getmax(root.left), getmax(root.right)));
    }

    public static int getmin(Node root) { // getting the minimum element in the tree
        if (root == null)
            return Integer.MAX_VALUE;
        else
            return Math.min(root.key, Math.min(getmin(root.left), getmin(root.right)));
    }

    public static int getheight(Node root) { // getting the height of the tree
        if (root == null)
            return 0;
        else
            return 1 + Math.max(getheight(root.left), getheight(root.right));
    }
}

public class base { // Public class
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.right.right = new Node(40);
        root.left.left = new Node(50);
        root.left.left.right = new Node(60);
        root.left.left.left = new Node(70);
        root.left.left.right.right = new Node(80);
        // obj.postorder(root);
        int x = Tree.getheight(root);
        System.out.println(x);
    }

    public static void inorder(Node root) { // first left child then root then right child
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

}
