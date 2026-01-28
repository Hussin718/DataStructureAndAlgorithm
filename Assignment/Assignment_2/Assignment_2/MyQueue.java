package Assignment_2;

public class MyQueue {
    private Node front, rear;

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        int data = front.data;
        front = front.next;
        if (front == null) rear = null;
        return data;
    }

    public int peek() {
        return isEmpty() ? -1 : front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}