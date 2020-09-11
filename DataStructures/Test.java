import Lists.*;

class Test {
    public static void main(String[] args) {
        
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.addFirst("Abc");
        list.addLast("as");
        list.addFirst("ds");
        list.addFirst("ewr");
        list.print();
    }
}