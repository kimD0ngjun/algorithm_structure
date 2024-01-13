package data_structure.linear.queue;

public class QueueByLinkedListExample {
    public static void main(String[] args) {
        QueueByLinkedListCustom<Integer> queue = new QueueByLinkedListCustom<>();
        queue.getSize();
//        queue.insert(0, 0);
//        queue.poll();

        System.out.println();

        queue.add(0);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.getSize();
        queue.printAllNodes();

        System.out.println();

        queue.delete();
        queue.getSize();
        queue.printAllNodes();

        System.out.println();

        queue.add(99);
        queue.add(99);
        queue.add(99);
        queue.add(99);
        queue.add(99);
        queue.add(99);
        queue.add(99);
        queue.getSize();
        queue.printAllNodes();

        System.out.println();

        queue.add(99);
        queue.getSize();
        queue.printAllNodes();

        System.out.println();

        queue.delete();
        queue.getSize();
        queue.printAllNodes();

        System.out.println();

        queue.delete();
        queue.getSize();
        queue.printAllNodes();
    }
}
