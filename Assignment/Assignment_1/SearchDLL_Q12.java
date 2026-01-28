class SearchDLL_Q12 {
    int data;
    SearchDLL_Q12 next;
    SearchDLL_Q12 prev;
    public SearchDLL_Q12(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    public static void main(String[] args) {
        // إنشاء قائمة مرتبطة ثنائية للاختبار: 5 <-> 10 <-> 15 <-> 20 <-> 25
        SearchDLL_Q12 head = new SearchDLL_Q12(5);
        head.next = new SearchDLL_Q12(10);
        head.next.prev = head;
        head.next.next = new SearchDLL_Q12(15);
        head.next.next.prev = head.next;
        head.next.next.next = new SearchDLL_Q12(20);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new SearchDLL_Q12(25);
        head.next.next.next.next.prev = head.next.next.next;

        int keyToSearch = 15; // القيمة التي نريد البحث عنها

        SearchDLL_Q12 searcher = new SearchDLL_Q12(0); // إنشاء كائن فقط للوصول إلى الدالة
        boolean found = searcher.searchDLL(head, keyToSearch);

        if (found) {
            System.out.println(keyToSearch + " found in the doubly linked list.");
        } else {
            System.out.println(keyToSearch + " not found in the doubly linked list.");
        }
    }
public boolean searchDLL(SearchDLL_Q12 head, int key) {
    SearchDLL_Q12 temp = head;
    while (temp != null) {
        if (temp.data == key) return true;
        temp = temp.next;
    }
    return false;
}
}