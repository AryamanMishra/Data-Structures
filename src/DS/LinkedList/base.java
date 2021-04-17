package DS.LinkedList;

public class base {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);
        head.next = second;
        second.next = third;
        third.next = fourth;
        Node h = reverse(head);
        print(h);
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void Recprint(Node head) {
        if (head == null)
            return;
        System.out.println(head.data);
        Recprint(head.next);
    }

    public static int search(Node head, int x) {
        Node temp = head;
        int c = 0;
        while (temp != null) {
            if (temp.data == x)
                return c;
            temp = temp.next;
            ++c;
        }
        return -1;
    }

    public static int Rsearch(Node head, int x) {
        if (head == null)
            return -1;
        if (head.data == x)
            return 1;
        else {
            int res = Rsearch(head.next, x);
            if (res == -1)
                return -1;
            else
                return (res + 1);
        }
    }

    public static Node insert_at_front(Node head, int x) {
        Node obj = new Node(x);
        obj.next = head;
        head = obj;
        return head;
    }

    public static Node insert_at_end(Node head, int x) {
        Node obj = new Node(x);
        if (head == null)
            return obj;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = obj;
        return head;
    }

    public static Node delete_first_node(Node head) {
        if (head == null)
            return null;
        return head.next;
    }

    public static Node delete_last_node(Node head) {
        Node temp = head;
        if (head == null)
            return null;
        if (temp.next == null)
            return null;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node insert_at_given_position(Node head, int position, int data) {
        Node obj = new Node(data);
        Node temp = head;
        int c = 0;
        while (temp != null) {
            ++c;
            temp = temp.next;
        }
        if (position > c + 1)
            return head;
        if (position == 1)
            head = insert_at_front(head, data);
        temp = head;
        c = 1;
        while (temp != null) {
            if (c == position - 1) {
                obj.next = temp.next;
                temp.next = obj;
                break;
            }
            ++c;
            temp = temp.next;
        }
        return head;
    }

    public static Node insert_in_sorted(Node head, int data) {
        Node obj = new Node(data);
        if (head == null)
            return obj;
        if (obj.data <= head.data) {
            Node x = insert_at_front(head, data);
            return x;
        }
        Node temp = head;
        while (temp.next != null && temp.data < data) {
            temp = temp.next;
        }
        obj.next = temp.next;
        temp.next = obj;
        return head;
    }

    public static Node give_middle(Node head) {
        if (head == null)
            return null;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverse(Node head) {
        Node first = head;
        Node prev = null;
        while (first != null) {
            Node next = first.next;
            first.next = prev;
            prev = first;
            first = next;
        }
        return prev;
    }

    public static Node nth_from_end(Node head, int n) {
        if (head == null)
            return null;
        Node first = head, second = head;

        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        for (Node i = first; i != null; i = i.next) {
            second = second.next;
        }
        return second;
    }
}