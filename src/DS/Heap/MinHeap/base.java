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

    public int extractMin() {
        if (size == 0)
            return Integer.MAX_VALUE;
        if (size == 1) {
            --this.size;
            return this.arr[0];
        }
        int swap = this.arr[0];
        this.arr[0] = this.arr[size - 1];
        this.arr[size - 1] = swap;
        --this.size;
        this.minheapify(0);
        return this.arr[size];
    }

    public void changeKey(int i, int x) {
        arr[i] = x;
        while (arr[i] < arr[getparent(i)] && i != 0) {
            int swap = arr[i];
            arr[i] = arr[getparent(i)];
            arr[getparent(i)] = swap;
            i = getparent(i);
        }
    }

    public void deleteKey(int i) {
        if (i >= size || i < 0)
            return;
        int swap = arr[i];
        arr[i] = arr[size - 1];
        arr[size - 1] = swap;
        --size;
        while (arr[i] < arr[getparent(i)] && i != 0) {
            int s = arr[i];
            arr[i] = arr[getparent(i)];
            arr[getparent(i)] = s;
            i = getparent(i);
        }
    }

    public void buildHeap() {
        for (int i = (size - 2) / 2; i >= 0; i--)
            minheapify(i);
    }
}

public class base {
    public static void main(String[] args) {
        MinHeap minheap = new MinHeap(9);
        minheap.insert(10);
        minheap.insert(20);
        minheap.insert(30);
        minheap.insert(40);
        minheap.insert(50);
        minheap.insert(35);
        minheap.insert(38);
        minheap.insert(45);
        // minheap.changeKey(3, 5);
        // minheap.deleteKey(3);
        minheap.print();

    }
}
