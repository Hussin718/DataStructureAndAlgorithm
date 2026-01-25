package com.example.Structure.uninformed;
import com.example.Structure.structurebase.*;

public class StackFrontier {

  // class inner
    private class Element {
        Node node;
        Element next;
        Element(Node node, Element next) {
            this.node = node;
            this.next = next;
        }
    }

    private Element head = null;

    public void add(Node newNode) {
        head = new Element(newNode, head);
    }

    public Node remove() {
        if (head == null) return null;
        Node toReturn = head.node;
        head = head.next; // نقل الرأس للعنصر التالي
        return toReturn;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
