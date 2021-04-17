package DS.BST;

import DS.Tree.*;

public class base {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root = insert(20, root);
        DS.Tree.base.inorder(root);
    }

    public static boolean search(int x, Node root) {
        if (root == null)
            return false;
        else if (root.key == x)
            return true;
        else if (root.key < x)
            return search(x, root.right);
        else
            return search(x, root.left);
    }

    public static Node insert(int x, Node root) {
        if (root == null)
            return new Node(x);
        else if (root.key < x)
            root.right = insert(x, root.right);
        else
            root.left = insert(x, root.left);
        return root;
    }
}