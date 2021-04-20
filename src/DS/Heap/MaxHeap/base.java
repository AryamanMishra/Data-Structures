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

    public void maxheapify(int i) {
        int left = getleft(i);
        int right = getright(i);
        int largest = i;
        if (left < size && arr[left] > arr[i])
            largest = left;
        if (right < size && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            int c = arr[i];
            arr[i] = arr[largest];
            arr[largest] = c;
            maxheapify(largest);
        }
    }

    public int extractMax() {
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
        this.maxheapify(0);
        return this.arr[size];
    }

    public void changeKey(int i, int x) {
        arr[i] = x;
        while (arr[i] > arr[getparent(i)] && i != 0) {
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
        while (arr[i] > arr[getparent(i)] && i != 0) {
            int s = arr[i];
            arr[i] = arr[getparent(i)];
            arr[getparent(i)] = s;
            i = getparent(i);
        }
    }

    public void buildHeap() {
        for (int i = (size - 2) / 2; i >= 0; i--)
            maxheapify(i);
    }
}

public class base {
    public static void main(String[] args) {
        MaxHeap minheap = new MaxHeap(5);
        minheap.insert(1);
        minheap.insert(2);
        minheap.insert(3);
        minheap.insert(4);
        minheap.print();

    }
}
