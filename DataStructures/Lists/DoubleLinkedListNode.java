package Lists;

public class DoubleLinkedListNode<T> {
    private T value;
    private DoubleLinkedListNode<T> next = null;
    private DoubleLinkedListNode<T> prev = null;

    public DoubleLinkedListNode(T value) {
        this.value = value;
    }

    public void setNext(DoubleLinkedListNode<T> next) {
        this.next = next;
    }

    public void setPrev(DoubleLinkedListNode<T> prev) {
        this.prev = prev;
    }

    public DoubleLinkedListNode<T> getPrev() {
        return this.prev;
    }

    public DoubleLinkedListNode<T> getNext() {
        return this.next;
    }

    public T getValue() {
        return this.value;
    }

}