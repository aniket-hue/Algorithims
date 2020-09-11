import Lists.*;

class Test {
    public static void main(String[] args) {

        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        // System.out.println("0--");
        list.printReverse();

    }
}