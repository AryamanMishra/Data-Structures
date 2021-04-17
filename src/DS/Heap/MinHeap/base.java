package DS.Heap.MinHeap;

class MinHeap {
    int[] arr;
    int size;
    int capacity;

    MinHeap(int c) {
        arr = new int[c];
        capacity = c;
        size = 0;
    }

    public void swap(int a, int b) {
        int c = a;
        a = b;
        b = c;
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
        while (arr[getparent(a)] > arr[a] && a != 0) {
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

    public void minheapify(int i) {
        int left = getleft(i);
        int right = getright(i);
        int smallest = i;
        if (left < size && arr[left] < arr[i])
            smallest = left;
        if (right < size && arr[right] < arr[smallest])
            smallest = right;
        if (smallest != i) {
            int c = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = c;
            minheapify(smallest);
        }
    }
}

public class base {
    public static void main(String[] args) {
        MinHeap minheap = new MinHeap(5);
        minheap.insert(2);
        minheap.insert(4);
        minheap.insert(3);
        minheap.insert(1);
        minheap.print();

    }
}
