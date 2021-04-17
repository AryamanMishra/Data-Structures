package DS.Circular_LinkedList;

import DS.LinkedList.Node;

class Circular_LinkedList {

    public static void print(Node head) {
        if (head == null)
            return;
        if (head.next == head)
            System.out.println(head.data);
        else {
            System.out.print(head.data + " ");
            Node temp = head.next;
            while (temp != head) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static Node insert_at_front(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp = temp.next;
            head = temp;
        } else {
            Node t = head.next;
            head.next = temp;
            temp.next = t;
            int swap = head.data;
            head.data = temp.data;
            temp.data = swap;
        }
        return head;
    }

    public static Node insert_at_end(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp = temp.next;
            head = temp;
        } else {
            Node t = head.next;
            head.next = temp;
            temp.next = t;
            int swap = head.data;
            head.data = temp.data;
            temp.data = swap;
        }
        return temp;
    }

    public static Node pop_front(Node head) {
        if (head == null)
            return null;
        if (head.next == null)
            return null;
        head.data = head.next.data;
        head.next = head.next.next;
        return head;
    }
}

public class base {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = head;
        head = Circular_LinkedList.insert_at_front(head, 15);
        head = Circular_LinkedList.insert_at_end(head, 40);
        head = Circular_LinkedList.insert_at_end(head, 50);
        head = Circular_LinkedList.pop_front(head);
        head = Circular_LinkedList.pop_front(head);
        Circular_LinkedList.print(head);
    }
}