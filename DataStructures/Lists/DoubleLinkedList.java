package Lists;

public class DoubleLinkedList<T> {
    private DoubleLinkedListNode<T> head = null;

    public DoubleLinkedListNode<T> createDoubleLinkedListNode(T data) {
        return new DoubleLinkedListNode<T>(data);
    }

    public DoubleLinkedListNode<T> head() {
        return this.head;
    }

    /**
     * Insert at the front of the list
     * 
     * @param value
     */

    public void addFirst(T data) {
        DoubleLinkedListNode<T> newDoubleLinkedListNode = createDoubleLinkedListNode(data);
        if (head == null)
            head = newDoubleLinkedListNode;
        else {
            newDoubleLinkedListNode.setNext(head);
            head.setPrev(newDoubleLinkedListNode);
            head = newDoubleLinkedListNode;
        }
    }

    /**
     * Insert at the last of the list
     * 
     * @param value
     */

    public void addLast(T data) {
        DoubleLinkedListNode<T> newDoubleLinkedListNode = createDoubleLinkedListNode(data);
        if (head == null)
            head = newDoubleLinkedListNode;
        else {
            DoubleLinkedListNode<T> temp = head;
            while (temp.getNext() != null)
                temp = temp.getNext();
            temp.setNext(newDoubleLinkedListNode);
            newDoubleLinkedListNode.setPrev(temp);
        }
    }

    /**
     * Recursively traverse this list and print the DoubleLinkedListNode value
     * 
     */

    public void print() {
        printList(this.head);
    }

    private void printList(DoubleLinkedListNode<T> curr) {
        if (curr == null)
            return;
        else {
            System.out.println(curr.getValue());
            printList(curr.getNext());
        }
    }

    /**
     * Recursively traverse this list and print the DoubleLinkedListNode value in
     * reverse order
     * 
     */
    public void printReverse() {
        printList2(this.head);
    }

    private void printList2(DoubleLinkedListNode<T> curr) {
        if (curr == null)
            return;
        else {
            printList2(curr.getNext());
            System.out.println(curr.getValue());
        }
    }
}
