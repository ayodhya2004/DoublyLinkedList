package linkedlist;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addToFront(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addToEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void removeFromFront() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void removeFromEnd() {
        if (tail == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printListReverse() {
        Node<T> current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addToFront(10);
        list.addToFront(20);
        list.addToEnd(30);
        list.addToEnd(40);

        System.out.print("List: ");
        list.printList(); // Output: 20 10 30 40 

        System.out.print("Reversed List: ");
        list.printListReverse(); // Output: 40 30 10 20 

        list.removeFromFront();
        System.out.print("After removing from front: ");
        list.printList(); // Output: 10 30 40 

        list.removeFromEnd();
        System.out.print("After removing from end: ");
        list.printList(); // Output: 10 30 
    }
}
