package DS.Heap.MaxHeap;

class MaxHeap {
    int[] arr;
    int size;
    int capacity;

    MaxHeap(int c) {
        arr = new int[c];
        capacity = c;
        size = 0;
    }

    public static int getleft(int i) {
        return (2 * i + 1);
    }

    public static int getright(int i) {
        return (2 * i + 2);
    }

    public static int getparent(int i) {
        return ((i - 1) / 2);
    }

    public void insert(int x) {
        if (size == capacity)
            return;
        ++size;
        arr[size - 1] = x;
        int a = size - 1;
        while (arr[getparent(a)] < arr[a] && a != 0) {
            int c = arr[getparent(a)];
            arr[getparent(a)] = arr[a];
            arr[a] = c;
            a = getparent(a);
        }
    }

    public void print() {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

public class base {
    public static void main(String[] args) {
        MaxHeap minheap = new MaxHeap(5);
        minheap.insert(4);
        minheap.insert(2);
        minheap.insert(3);
        minheap.insert(1);
        minheap.print();

    }
}
