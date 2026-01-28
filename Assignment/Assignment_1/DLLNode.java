public class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    public DLLNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    public static void main(String[] args) {
        // إنشاء قائمة مرتبطة ثنائية للاختبار: 1 <-> 2 <-> 3 <-> 2 <-> 4 <-> 3
        DLLNode head = new DLLNode(1);
        head.next = new DLLNode(2);
        head.next.prev = head;
        head.next.next = new DLLNode(3);
        head.next.next.prev = head.next;
        head.next.next.next = new DLLNode(2);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new DLLNode(4);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new DLLNode(3);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        // إزالة التكرارات
        DLLNode remover = new DLLNode(0); // إنشاء كائن فقط للوصول إلى الدالة
        remover.removeDuplicates(head);

        // طباعة القائمة بعد إزالة التكرارات
        DLLNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
    public void removeDuplicates(DLLNode head) {
        DLLNode current = head;
        while (current != null) {
            DLLNode runner = current.next;
            while (runner != null) {
                if (runner.data == current.data) {
                // حذف الـ runner
                    runner.prev.next = runner.next;
                    if (runner.next != null) runner.next.prev = runner.prev;
                }
                runner = runner.next;
            }
            current = current.next;
        }
    }
}