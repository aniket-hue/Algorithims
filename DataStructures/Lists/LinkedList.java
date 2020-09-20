package Lists;


class SingleLinkedListNode<T extends Comparable<T>> implements Comparable<SingleLinkedListNode<T>> {
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

    @Override
    public int compareTo(SingleLinkedListNode<T> arg0) {
        return this.value.compareTo(arg0.value);
    }

}

public class LinkedList<T extends Comparable<T>> {
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
     * This will delete all the duplicates in the sorted Linked List.
     * 
     */

    public void removeDuplicates() {

        SingleLinkedListNode<T> leftPointer = head, rightPointer = head.getNext();

        while (leftPointer != null && rightPointer != null) {

            if (leftPointer.getValue() == rightPointer.getValue()) {

                while (rightPointer != null && leftPointer.getValue() == rightPointer.getValue())
                    rightPointer = rightPointer.getNext();

                leftPointer.setNext(rightPointer);
                rightPointer.setNext(leftPointer.getNext());

            } else {

                leftPointer = leftPointer.getNext();
                rightPointer = rightPointer.getNext();

            }
        }

    }

    /**
     * This will detect loop in Linked List.
     */

    public boolean detectLoop() {

        SingleLinkedListNode<T> fast = head, slow = head;

        while (slow != null && fast.getNext() != null && fast.getNext().getNext() != null) {

            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if (fast == slow)
                return true;

        }

        return false;
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

    SingleLinkedListNode<T> nextLargerNodesHandler(SingleLinkedListNode<T> temp, SingleLinkedListNode<T> prev) {
        if (temp.getNext() == null) {
            System.out.print(0 + " ");
            return temp;
        } else {
            SingleLinkedListNode<T> nextMax = nextLargerNodesHandler(temp.getNext(), temp);
            if (nextMax.compareTo(temp) == 1) {
                System.out.print(nextMax.getValue() + " ");
                if (temp.compareTo(prev) == 1)
                    return temp;
                else
                    return nextMax;
            } else {
                return temp;
            }
        }
    }

    public void nextLargerNodes() {
        nextLargerNodesHandler(head, head);
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
