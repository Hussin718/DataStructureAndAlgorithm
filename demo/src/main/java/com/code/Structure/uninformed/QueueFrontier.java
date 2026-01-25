package com.example.Structure.uninformed;
import com.example.Structure.structurebase.*;

public class QueueFrontier {
    private class Element {
        Node node;
        Element next;
        Element(Node node) { this.node = node; }
    }

    private Element head = null;
    private Element tail = null;

    public void add(Node newNode) {
        Element newElement = new Element(newNode);
        if (tail == null) { // الطابور فارغ
            head = tail = newElement;
            return;
        }
        tail.next = newElement; // ربط العنصر الأخير بالجديد
        tail = newElement;      // تحديث المؤشر الأخير
    }

    public Node remove() {
        if (head == null) return null;
        Node toReturn = head.node;
        head = head.next;
        if (head == null) tail = null; // إذا أصبح فارغاً
        return toReturn;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
