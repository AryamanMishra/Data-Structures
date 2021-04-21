/************************

    Java Code for a Binary Search Tree

    A BST is a Tree where each node have atmost 2 children nodes.

    In a BST the left subtree of a node have all nodes less than the parent node's key
    and the right subtree have all nodes greater than the parent node's key.

*************************/

package DS.BST; // Appropriate package declaration

import DS.Tree.*; // Importing Tree implementation Node to be used 

class BST { // The BST class having all methods to be implemented
    Node root;

    public boolean search(int x, Node root) { // Search method in a BST
        if (root == null) // Checking for an empty tree
            return false;
        else if (root.key == x) // Value found and we return true
            return true;
        else if (root.key < x)
            return search(x, root.right);
        else
            return search(x, root.left);
    }

    public Node insert(int x, Node root) { // Insert method in a BST
        if (root == null) // Insertion of the value
            return new Node(x);
        else if (root.key < x)
            root.right = insert(x, root.right);
        else
            root.left = insert(x, root.left);
        return root;
    }

    public Node getSuccfodelete(Node root) { // Getting successor of a node for the delete method
        Node curr = root.right;
        while (curr.left != null && curr != null)
            curr = curr.left;
        return curr; // First right then left until null is reached
    }

    public Node deleteNode(Node root, int x) { // Delete method in a BST
        if (root == null)
            return null;
        if (root.key > x)
            root.left = deleteNode(root.left, x);
        else if (root.key < x)
            root.right = deleteNode(root.right, x);

        // Real implementation block
        else {
            if (root.left == null) // For leaf nodes or nodes having one child
                return root.right;
            else if (root.right == null) // For leaf nodes or nodes having one child
                return root.left;
            else {
                Node succ = getSuccfodelete(root);
                root.key = succ.key; // Assigning just greater value to the value to be deleted
                root.right = deleteNode(root.right, succ.key); // Deleting successor(leaf node)
            }
        }
        return root;
    }
}

public class base { // Public class
    public static void main(String[] args) {
        BST obj = new BST();
        obj.root = new Node(10);
        obj.root.left = new Node(5);
        obj.root.right = new Node(15);
        obj.root = obj.insert(20, obj.root);
        obj.root = obj.insert(12, obj.root);
        obj.root = obj.deleteNode(obj.root, 20);
        DS.Tree.base.inorder(obj.root);
        /*
         * 10 / \ 5 15 \ \ 12 20
         */
    }

}