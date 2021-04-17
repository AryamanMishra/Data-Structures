package DS.Queue.ArrayImp;

class Queue {
    int capacity, size, front;
    int[] arr;

    Queue(int x) {
        arr = new int[x];
        size = 0;
        capacity = x;
        front = 0;
    }

    public boolean isFull() {
        return (size == capacity);
    }

    public boolean isempty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public int getFront() {
        if (isempty())
            return -1;
        return front;
    }

    public int getRear() {
        if (isempty())
            return -1;
        return (front + size - 1) % capacity;
    }

    public void enqueue(int x) {
        if (isFull())
            return;
        int rear = getRear();
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        ++size;
    }

    public void dequeue() {
        if (isempty())
            return;
        front = (front + 1) % capacity;
        --size;
    }

    public void print() {
        for (int i = front; i <= size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

public class base {
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue(10);
        // q.print();
        q.enqueue(20);
        // q.print();
        q.enqueue(30);
        // q.print();
        q.dequeue();
        q.print();
        boolean check = q.isempty();
        System.out.println(check);
    }
}
