package DS.Queue.LLImp;

import DS.LinkedList.Node;

class Queue {
    static Node front, rear;

    Queue() {
        front = rear = null;
    }

    public void enqueue(int x) {
        Node temp = new Node(x);
        if (front == null)
            front = rear = temp;
        else {
            rear.next = temp;
            rear = temp;
        }
    }

    public void dequeue() {
        if (front == null)
            return;
        front = front.next;
        if (front == null)
            front = rear = null;
    }

    public boolean isempty() {
        if (front == null)
            return true;
        return false;
    }

    public void print() {
        while (front != rear.next) {
            System.out.print(front.data + " ");
            front = front.next;
        }
        System.out.println();
    }
}

public class base {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.dequeue();
        q.print();
        boolean check = q.isempty();
        System.out.println(check);
    }
}
