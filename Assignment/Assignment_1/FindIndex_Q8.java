public class FindIndex_Q8 {
    // تعريف نود القائمة المرتبطة
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        // إنشاء قائمة مرتبطة للاختبار: 10 -> 20 -> 30 -> 40 -> 50
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        
        int valueToFind = 30; // القيمة التي نريد إيجاد موقعها
        
        FindIndex_Q8 finder = new FindIndex_Q8();
        int index = finder.findIndex(head, valueToFind);
        
        if (index != -1) {
            System.out.println("Index of " + valueToFind + " is: " + index);
        } else {
            System.out.println(valueToFind + " not found in the list.");
        }
    }
    public int findIndex(Node head, int value) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == value) return index;
            current = current.next;
            index++;
        }
        return -1;
    }
}