package Lists;

class SingleLinkedListNode<T> {
    private T value;
    private SingleLinkedListNode<T> next = null;

    public SingleLinkedListNode(T value) {
        this.value = value;
    }

    public void setNext(SingleLinkedListNode<T> next) {
        this.next = next;
    }

    public SingleLinkedListNode<T> getNext() {
        return this.next;
    }

    public T getValue() {
        return this.value;
    }

}

public class LinkedList<T> {
    private SingleLinkedListNode<T> head = null;

    public SingleLinkedListNode<T> head() {
        return this.head;
    }

    public SingleLinkedListNode<T> createSingleLinkedListNode(T data) {
        return new SingleLinkedListNode<T>(data);
    }

    /**
     * Insert at the front of the list
     * 
     * @param data
     */

    public void addFront(T data) {
        SingleLinkedListNode<T> new_SingleLinkedListNode = createSingleLinkedListNode(data);
        if (head == null)
            head = new_SingleLinkedListNode;
        else {
            new_SingleLinkedListNode.setNext(head);
            head = new_SingleLinkedListNode;
        }
    }

    /**
     * Insert at the last of the list
     * 
     * @param data
     */

    public void addLast(T data) {
        SingleLinkedListNode<T> new_SingleLinkedListNode = createSingleLinkedListNode(data);
        SingleLinkedListNode<T> temp = head;
        while (temp.getNext() != null)
            temp = temp.getNext();
        temp.setNext(new_SingleLinkedListNode);
    }

    /**
     * Insert at the middle of the list
     * 
     * @param value
     */

    public void addMid(T data) {
        SingleLinkedListNode<T> new_SingleLinkedListNode = createSingleLinkedListNode(data);
        if (head == null)
            head = new_SingleLinkedListNode;
        else {
            SingleLinkedListNode<T> temp = head, temp1 = head.getNext();

            while (temp1 != null && temp1.getNext() != null) {
                temp = temp.getNext();
                temp1 = temp1.getNext().getNext();
            }

            new_SingleLinkedListNode.setNext(temp.getNext());
            temp.setNext(new_SingleLinkedListNode);
        }
    }

    /**
     * Delete at specific position
     * 
     * @param position
     */

    public void deletePos(int position) {
        SingleLinkedListNode<T> temp = head;
        if (position == 1) {
            head = head.getNext();
            return;
        }
        position--;
        while (--position != 0)
            temp = temp.getNext();

        temp.setNext(temp.getNext().getNext());
        ;

    }

    /**
     * Print recursively
     * 
     */
    public void print() {
        printList(this.head);
    }

    private void printList(SingleLinkedListNode<T> curr) {
        if (curr == null)
            return;
        else {
            System.out.println(curr.getValue());
            printList(curr.getNext());
        }
    }
}
