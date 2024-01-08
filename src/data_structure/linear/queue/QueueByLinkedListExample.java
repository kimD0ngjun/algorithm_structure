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

        System.out.println();
        System.out.println("----------------------");
        System.out.println();

        QueueByLinkedListCustom<String> anotherQueue =
                new QueueByLinkedListCustom<>(15);

        anotherQueue.getSize();
//        anotherQueue.poll();

        System.out.println();

        anotherQueue.add("A");
        anotherQueue.getSize();
        anotherQueue.printAllNodes();

        System.out.println();
        anotherQueue.add("B");
        anotherQueue.add("C");
        anotherQueue.add("E");
        anotherQueue.add("F");
        anotherQueue.add("G");
        anotherQueue.getSize();
        anotherQueue.printAllNodes();

        System.out.println();
        anotherQueue.add("H");
        anotherQueue.add("H");
        anotherQueue.add("H");
        anotherQueue.add("H");
        anotherQueue.getSize();
        anotherQueue.printAllNodes();

        System.out.println();
        anotherQueue.add("H");
        anotherQueue.add("H");
        anotherQueue.add("H");
        anotherQueue.add("H");
        anotherQueue.add("H");
        anotherQueue.add("I");
        anotherQueue.getSize();
        anotherQueue.printAllNodes();

        System.out.println();
        anotherQueue.delete();
        anotherQueue.getSize();
        anotherQueue.printAllNodes();

        System.out.println();
        anotherQueue.add("I");
        anotherQueue.getSize();
        anotherQueue.printAllNodes();
    }
}
