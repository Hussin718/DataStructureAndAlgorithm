class SplitList_Q16 {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args) {
        // إنشاء قائمة مرتبطة دائرية للاختبار: 1 -> 2 -> 3 -> 4 -> 5 (ثم تعود إلى 1)
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head; // جعلها دائرية

        SplitList_Q16 splitter = new SplitList_Q16();
        splitter.splitList(head);

        // طباعة القائمتين الناتجتين (توقف بعد عدد معين من النود لتجنب الطباعة اللانهائية)
        System.out.println("First Circular Linked List:");
        Node current = head;
        for (int i = 0; i < 10; i++) { // طباعة أول 10 نود فقط
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();

        System.out.println("Second Circular Linked List:");
        Node secondHead = head;
        while (secondHead.next != head) secondHead = secondHead.next;
        secondHead = secondHead.next; // بداية النصف الثاني
        current = secondHead;
        for (int i = 0; i < 10; i++) { // طباعة أول 10 نود فقط
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
    public void splitList(Node head) {
        if (head == null) return;
        Node slow = head, fast = head;
    
    // استخدام fast and slow pointers لإيجاد المنتصف
        while (fast.next != head && fast.next.next != head) {
            fast = fast.next.next;
            slow = slow.next;
        }
    
    // تحديد رأس القائمة الثانية
        Node head1 = head;
        Node head2 = slow.next;
    
    // جعل النصف الثاني دائرياً
        Node temp = head2;
        while (temp.next != head) temp = temp.next;
        temp.next = head2;
    
    // جعل النصف الأول دائرياً
        slow.next = head1;
    }
}