//*  Documentation and commenting left  *//

package DS.BST;

import DS.Tree.*;

class BST {
    Node root;

    public boolean search(int x, Node root) {
        if (root == null)
            return false;
        else if (root.key == x)
            return true;
        else if (root.key < x)
            return search(x, root.right);
        else
            return search(x, root.left);
    }

    public Node insert(int x, Node root) {
        if (root == null)
            return new Node(x);
        else if (root.key < x)
            root.right = insert(x, root.right);
        else
            root.left = insert(x, root.left);
        return root;
    }

    public Node getSuccfodelete(Node root) {
        Node curr = root.right;
        while (curr.left != null && curr != null)
            curr = curr.left;
        return curr;
    }

    public Node deleteNode(Node root, int x) {
        if (root == null)
            return null;
        if (root.key > x)
            root.left = deleteNode(root.left, x);
        else if (root.key < x)
            root.right = deleteNode(root.right, x);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                Node succ = getSuccfodelete(root);
                root.key = succ.key;
                root.right = deleteNode(root.right, succ.key);
            }
        }
        return root;
    }
}

public class base {
    public static void main(String[] args) {
        BST obj = new BST();
        obj.root = new Node(10);
        obj.root.left = new Node(5);
        obj.root.right = new Node(15);
        obj.root = obj.insert(20, obj.root);
        obj.root = obj.deleteNode(obj.root, 20);
        DS.Tree.base.inorder(obj.root);
    }

}