package arrays;

import java.util.Arrays;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return (2 * index) + 1;
    }

    private int getRightChildIndex(int index) {
        return (2 * index) + 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private void heapifyUp(int index) {
        int parentIndex = getParentIndex(index);
        if (parentIndex >= 0 && heap[index] < heap[parentIndex]) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        int smallest = index;
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);

        if (leftChildIndex < size && heap[leftChildIndex] < heap[smallest]) {
            smallest = leftChildIndex;
        }

        if (rightChildIndex < size && heap[rightChildIndex] < heap[smallest]) {
            smallest = rightChildIndex;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }

        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    public int extractMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int minValue = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);

        return minValue;
    }

    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(4);
        minHeap.insert(2);
        minHeap.insert(7);
        minHeap.insert(1);
        minHeap.insert(9);

        minHeap.printHeap(); // Output: [1, 2, 7, 4, 9]

        int min = minHeap.extractMin();
        System.out.println("Minimum value extracted: " + min); // Output: 1

        minHeap.printHeap(); // Output: [2, 4, 7, 9]
    }
}
