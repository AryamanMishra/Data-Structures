package DS.Stack;

import DS.LinkedList.Node;

class Stack {
    // Stack(Node head) {
    // head = null;
    // }
    int size = 0;
    Node head;

    public void push(int x) {
        Node obj = new Node(x);
        obj.next = head;
        head = obj;
        ++this.size;
    }

    public int pop() {
        if (head == null)
            return -1;
        int ans = head.data;
        head = head.next;
        --this.size;
        return ans;
    }

    public void size() {
        System.out.println(this.size);
    }

    public void print() {
        if (head == null)
            return;
        while (head != null) {
            Node temp = head;
            System.out.println(temp.data);
            head = head.next;
        }
    }
}

public class base {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.size();

        stack.print();
    }
}