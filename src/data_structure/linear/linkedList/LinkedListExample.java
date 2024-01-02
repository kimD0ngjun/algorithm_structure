package data_structure.linear.linkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedListCustom<Integer> linkedList = new LinkedListCustom<>();
        linkedList.printAllNodes();

        linkedList.add(0);
        linkedList.printAllNodes();

        linkedList.add(1);
        linkedList.printAllNodes();

        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.printAllNodes();

        linkedList.insert(100, 3);
        linkedList.printAllNodes();

        linkedList.delete(2);
        linkedList.printAllNodes();
    }
}
