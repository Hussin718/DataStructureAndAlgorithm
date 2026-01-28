public class DeleteAtPosition_Q14 {
    // تعريف نود القائمة المرتبطة الدائرية
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

        int positionToDelete = 2; // الموقع الذي نريد حذف النود عنده

        DeleteAtPosition_Q14 deleter = new DeleteAtPosition_Q14();
        Node newHead = deleter.deleteAtPosition(head, positionToDelete);

        // طباعة القائمة بعد الحذف (توقف بعد عدد معين من النود لتجنب الطباعة اللانهائية)
        Node current = newHead;
        for (int i = 0; i < 10; i++) { // طباعة أول 10 نود فقط
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
    public Node deleteAtPosition(Node head, int pos) {
        if (head == null) return null;
        if (pos == 0) {
        // حذف الرأس في القائمة الدائرية يتطلب تحديث آخر نود
            Node last = head;
            while (last.next != head) last = last.next;
            if (head == last) return null; // قائمة من عنصر واحد
            last.next = head.next;
            return head.next;
        }
        Node temp = head;
        for (int i = 0; i < pos - 1; i++) temp = temp.next;
        temp.next = temp.next.next;
        return head;

    }
}