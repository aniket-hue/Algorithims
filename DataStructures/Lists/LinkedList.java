package Lists;

class node {
    int data;
    node next;

    node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    node head = null;

    void insert_first(int data) {
        node new_node = new node(data);
        if (head == null)
            head = new_node;
        else {
            new_node.next = head;
            head = new_node;
        }
    }

    void insert_last(int data) {
        node new_node = new node(data);
        node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = new_node;
    }

    void insert_mid(int data) {
        node new_node = new node(data);
        if (head == null)
            head = new_node;
        else {
            node temp = head, temp1 = head.next;

            while (temp1 != null && temp1.next != null) {
                temp = temp.next;
                temp1 = temp1.next.next;
            }

            new_node.next = temp.next;
            temp.next = new_node;
        }
    }

    void delete_position(int position) {
        node temp = head;
        if (position == 1) {
            head = head.next;
            return;
        }
        position--;
        while (--position != 0)
            temp = temp.next;

        temp.next = temp.next.next;

    }

    void display() {
        node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

