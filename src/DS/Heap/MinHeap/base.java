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

    public void heapify(int i) {
        int left = getleft(i);
        int right = getright(i);
        if (Integer.min(arr[i], Integer.min(arr[left], arr[right])) == arr[i])
            return;
        else if (Integer.min(arr[i], Integer.min(arr[left], arr[right])) == arr[left]) {
            swap(arr[left], arr[i]);
            heapify(left);
        } else {
            swap(arr[right], arr[i]);
            heapify(right);
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
