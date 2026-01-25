package com.example.Structure.structurebase;

public class Heapq {
    private Node[] heap;
    private int length;
    private int capacity;

    public Heapq(int capacity) {
        this.capacity = capacity;
        this.heap = new Node[capacity];
        this.length = 0;
    }

    public void push(Node newNode) {
        if (length == capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[length] = newNode;
        heapifyUp(length);
        length++;
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;
        if (index > 0 && heap[index].getEvaluation() < heap[parent].getEvaluation()) {
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    public Node pop() {
        if (length == 0) {
            System.out.println("Heap is empty");
            return null;
        }
        Node root = heap[0];
        heap[0] = heap[length - 1];
        length--;
        heapifyDown(0);
        return root;
    }

    public void heapifyDown(int index) {
        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < length && heap[left].getEvaluation() < heap[smallest].getEvaluation()) {
            smallest = left;
        }
        if (right < length && heap[right].getEvaluation() < heap[smallest].getEvaluation()) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        Node temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public boolean isEmpty() {
        return length == 0;
}
}
