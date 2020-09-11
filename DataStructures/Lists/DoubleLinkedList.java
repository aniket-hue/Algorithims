package Lists;

class Node<T> {
    private T value;
    private Node<T> next = null;
    private Node<T> prev = null;

    public Node(T value) {
        this.value = value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getPrev() {
        return this.prev;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public T getValue() {
        return this.value;
    }

}

public class DoubleLinkedList<T> {
    private Node<T> head = null;

    public Node<T> createNode(T data) {
        return new Node<T>(data);
    }

    /**
     * Insert at the front of the list
     * 
     * @param value
     */

    public void addFirst(T data) {
        Node<T> newNode = createNode(data);
        if (head == null)
            head = newNode;
        else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
    }

    /**
     * Insert at the last of the list
     * 
     * @param value
     */

    public void addLast(T data) {
        Node<T> newNode = createNode(data);
        if (head == null)
            head = newNode;
        else {
            Node<T> temp = head;
            while (temp.getNext() != null)
                temp = temp.getNext();
            temp.setNext(newNode);
            newNode.setPrev(temp);
        }
    }

    /**
     * Recursively traverse this list and print the node value
     * 
     * @param node
     */

    public void printList(Node<T> curr) {
        if (curr == null)
            return;
        else {
            System.out.println(curr.getValue());
            printList(curr.getNext());
        }
    }

    public void print() {
        printList(head);
    }
}
