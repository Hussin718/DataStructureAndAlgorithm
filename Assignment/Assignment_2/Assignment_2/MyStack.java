package Assignment_2;
import Assignment_2.Node;
@SuppressWarnings("unused")
public class MyStack {
    private Node top;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public void pushChar(char data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) return -1;
        int data = top.data;
        top = top.next;
        return data;
    }

    public char popChar() {
        char data = top.charData;
        top = top.next;
        return data;
    }

    public int peek() {
        return isEmpty() ? -1 : top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}