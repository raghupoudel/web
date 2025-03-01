class cdllnode {
    int data;
    cdllnode prev, next;

    public cdllnode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public cdllnode(int data, cdllnode prev, cdllnode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

class cdll {
    cdllnode head, tail;

    public cdll() {
        head = tail = null;
    }

    public boolean isempty() {
        return head == null && tail == null;
    }

    public void inserthead(int el) {
        if (isempty()) {
            head = tail = new cdllnode(el);
            head.next = head.prev = head; // Circular reference
        } else {
            cdllnode nn = new cdllnode(el, tail, head);
            head.prev = nn;
            tail.next = nn;
            head = nn;
        }
    }

    public void traverseforward() {
        if (isempty()) {
            System.out.println("Circular linked list is empty");
            return;
        }
        cdllnode temp = head;
        do {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public void traversebackward() {
        if (isempty()) {
            System.out.println("Circular linked list is empty");
            return;
        }
        cdllnode temp = tail;
        do {
            System.out.print(temp.data + " --> ");
            temp = temp.prev;
        } while (temp != tail);
        System.out.println("(back to tail)");
    }

    public void insertlast(int el) {
        if (isempty()) {
            head = tail = new cdllnode(el);
            head.next = head.prev = head; // Circular reference
        } else {
            cdllnode nn = new cdllnode(el, tail, head);
            tail.next = nn;
            head.prev = nn;
            tail = nn;
        }
    }

    public void deletefirst() {
        if (isempty()) {
            System.out.println("Circular linked list is empty");
        } else if (head == tail) { // Single node case
            head = tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
    }

    public void deletelast() {
        if (isempty()) {
            System.out.println("Circular linked list is empty");
        } else if (head == tail) { // Single node case
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
    }
}

class circular {
    public static void main(String[] args) {
        cdll list = new cdll();

        list.inserthead(10);
        list.inserthead(20);
        list.insertlast(30);
        list.insertlast(40);

        System.out.println("Forward Traversal:");
        list.traverseforward();

        System.out.println("Backward Traversal:");
        list.traversebackward();

        list.deletefirst();
        System.out.println("After deleting first:");
        list.traverseforward();

        list.deletelast();
        System.out.println("After deleting last:");
        list.traverseforward();
    }
}
