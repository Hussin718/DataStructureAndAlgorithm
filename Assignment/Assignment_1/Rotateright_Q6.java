public class Rotateright_Q6 {
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
        // إنشاء قائمة مرتبطة للاختبار: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        
        int k = 2; // عدد المرات التي نريد تدوير القائمة بها
        
        // تدوير القائمة
        Rotateright_Q6 rotator = new Rotateright_Q6();
        Node newHead = rotator.rotateRight(head, k);
        
        // طباعة القائمة بعد التدوير
        Node current = newHead;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
    public Node rotateRight(Node head, int k) {
    if (head == null || head.next == null || k == 0) return head;
    
    // 1. حساب الطول والوصول لآخر نود
    Node last = head;
    int length = 1;
    while (last.next != null) {
        last = last.next;
        length++;
    }
    
    // 2. جعل القائمة دائرية مؤقتاً
    last.next = head;
    
    // 3. إيجاد نقطة القطع الجديدة
    k = k % length;
    int stepsToNewLast = length - k;
    Node newLast = head;
    for (int i = 1; i < stepsToNewLast; i++) {
        newLast = newLast.next;
    }
    
    // 4. كسر الدائرة وتحديد الرأس الجديد
    Node newHead = newLast.next;
    newLast.next = null;
    
    return newHead;
    }
}