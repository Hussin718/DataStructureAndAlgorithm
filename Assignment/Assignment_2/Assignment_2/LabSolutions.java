package Assignment_2;

public class LabSolutions {

    // 1. Reverse a string using Stack
    public static String reverseString(String str) {
        MyStack stack = new MyStack();
        for (int i = 0; i < str.length(); i++) {
            stack.pushChar(str.charAt(i));
        }
        
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.popChar());
        }
        return reversed.toString();
    }

    // 2. Sort a stack using only another Stack
    
    public static void sortStack(MyStack input) {
        MyStack tempStack = new MyStack();
        while (!input.isEmpty()) {
            int current = input.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                input.push(tempStack.pop());
            }
            tempStack.push(current);
        }
        // إعادة العناصر للمكدس الأصلي لتكون مرتبة تصاعدياً
        while (!tempStack.isEmpty()) {
            input.push(tempStack.pop());
        }
    }

    // 3. Reverse a queue using a Stack
    
    public static void reverseQueue(MyQueue queue) {
        MyStack stack = new MyStack();
        while (!queue.isEmpty()) {
            stack.push(queue.dequeue());
        }
        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }
    }

    // 4. Merge two sorted queues into one sorted queue
    public static MyQueue mergeSortedQueues(MyQueue q1, MyQueue q2) {
        MyQueue result = new MyQueue();
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek() <= q2.peek()) {
                result.enqueue(q1.dequeue());
            } else {
                result.enqueue(q2.dequeue());
            }
        }
        while (!q1.isEmpty()) result.enqueue(q1.dequeue());
        while (!q2.isEmpty()) result.enqueue(q2.dequeue());
        return result;
    }

    public static void main(String[] args) {
        // اختبار عكس النص
        System.out.println("Reverse 'Hello': " + reverseString("Hello"));
    }
}