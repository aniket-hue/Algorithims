package Lists;

class CircularLinkedListNode<T> {
    private T value;
    private CircularLinkedListNode<T> next = null;

    public CircularLinkedListNode(T value) {
        this.value = value;
    }

    public void setNext(CircularLinkedListNode<T> next) {
        this.next = next;
    }

    public CircularLinkedListNode<T> getNext() {
        return this.next;
    }

    public T getValue() {
        return this.value;
    }

}

public class CircularLinkedList<T> {
    private CircularLinkedListNode<T> head = null;

    public CircularLinkedListNode<T> head() {
        return this.head;
    }

    public CircularLinkedListNode<T> createCircularLinkedListNode(T data) {
        return new CircularLinkedListNode<T>(data);
    }

    /**
     * Insert at the front of the list
     * 
     * @param data
     */

    public void addFront(T data) {
        CircularLinkedListNode<T> new_CircularLinkedListNode = createCircularLinkedListNode(data);
        if (head == null)
            head = new_CircularLinkedListNode;
        else {
            new_CircularLinkedListNode.setNext(head);
            CircularLinkedListNode<T> temp = head;
            while (temp.getNext() != null)
                temp = temp.getNext();
            head = new_CircularLinkedListNode;
            temp.setNext(head);
        }
    }

    /**
     * Insert at the last of the list
     * 
     * @param data
     */

    public void addLast(T data) {
        CircularLinkedListNode<T> new_CircularLinkedListNode = createCircularLinkedListNode(data);
        if (this.head == null) {
            this.head = new_CircularLinkedListNode;
            this.head.setNext(head);
        } else {
            CircularLinkedListNode<T> temp = head;
            while (temp.getNext() != null)
                temp = temp.getNext();
            temp.setNext(new_CircularLinkedListNode);
            temp = temp.getNext();
            temp.setNext(head);
        }
    }

    /**
     * Print recursively
     * 
     */
    public void print() {
        printList(this.head);
    }

    private void printList(CircularLinkedListNode<T> curr) {
        if (curr == null)
            return;
        else {
            System.out.println(curr.getValue());
            printList(curr.getNext());
        }
    }
}
