class dllnode {
    int data;
    dllnode prev, next;

    public dllnode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public dllnode(int data, dllnode prev, dllnode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

class dll {
    dllnode head, tail;

    public dll() {
        head = tail = null;
    }

    public boolean isempty() {
        return head == null && tail == null;
    }

    public void inserthead(int el) {
        if (isempty()) {
            head = tail = new dllnode(el);
        } else {
            dllnode nn = new dllnode(el, null, head);
            head.prev = nn;
            head = nn;
        }
    }

    public void traverseforward() {
        dllnode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void traversebackward() {
        dllnode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public void insertlast(int el) {
        if (isempty()) {
            head = tail = new dllnode(el);
        } else {
            dllnode nn = new dllnode(el, tail, null);
            tail.next = nn;
            tail = nn;
        }
    }

    public void deletefirst() {
        if (isempty()) {
            System.out.println("Linked list is empty");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }
    }

    public void deletelast() {
        if (isempty()) {
            System.out.println("Linked list is empty");
        } else if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        }
    }
}

 class doubly {
    public static void main(String[] args) {
        dll list = new dll();

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
