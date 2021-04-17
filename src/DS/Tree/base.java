package DS.Tree;

public class base {
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
        int x = base.getheight(root);
        System.out.println(x);
    }

    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }

    public static int getsize(Node root) {
        if (root == null)
            return 0;
        else
            return 1 + getsize(root.left) + getsize(root.right);
    }

    public int getmax(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        else
            return Math.max(root.key, Math.max(getmax(root.left), getmax(root.right)));
    }

    public static int getmin(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;
        else
            return Math.min(root.key, Math.min(getmin(root.left), getmin(root.right)));
    }

    public static int getheight(Node root) {
        if (root == null)
            return 0;
        else
            return 1 + Math.max(getheight(root.left), getheight(root.right));
    }
}
