package data_structure.linear.linkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedListCustom<Integer> linkedList = new LinkedListCustom<>();
        linkedList.printAllNodes();
        linkedList.getSize();

//        linkedList.insert(1, 0);
//        linkedList.delete(0);

        System.out.println();

        linkedList.add(0);
        linkedList.printAllNodes();
        linkedList.getSize();

        System.out.println();

        linkedList.add(1);
        linkedList.printAllNodes();
        linkedList.getSize();

        System.out.println();

        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.printAllNodes();
        linkedList.getSize();

        System.out.println();

        linkedList.insert(100, 3);
        linkedList.printAllNodes();
        linkedList.getSize();

        System.out.println();

        linkedList.delete(2);
        linkedList.printAllNodes();
        linkedList.getSize();

        System.out.println();

        linkedList.add(7);
        linkedList.add(7);
        linkedList.add(7);
        linkedList.add(7);
        linkedList.add(7);
        linkedList.printAllNodes();
        linkedList.getSize();

        System.out.println();

        linkedList.insert(99, 7);
        linkedList.printAllNodes();
        linkedList.getSize();

        System.out.println();

        linkedList.insert(99, 7);
        linkedList.printAllNodes();
        linkedList.getSize();

        System.out.println();

        linkedList.delete(7);
        linkedList.printAllNodes();
        linkedList.getSize();

//        linkedList.insert(1000, 999);
//        linkedList.delete(999);

        System.out.println();

        linkedList.insert(66, 0);
        linkedList.printAllNodes();
        linkedList.getSize();

        System.out.println();

        linkedList.delete(66);
        linkedList.printAllNodes();
        linkedList.getSize();
    }
}
