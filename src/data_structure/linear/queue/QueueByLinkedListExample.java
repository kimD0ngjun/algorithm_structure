package data_structure.linear.queue;

import data_structure.linear.linkedList.LinkedListCustom;

public class QueueByLinkedListExample {
    public static void main(String[] args) {
        QueueByLinkedListCustom<Integer> queue = new QueueByLinkedListCustom<>();
        queue.getSize();
//        queue.poll();

        System.out.println();

        queue.add(0);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.getSize();
        queue.printAllNodes();

        System.out.println();

        queue.poll();
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

        Integer pollData = queue.poll();
        System.out.println("The output Data : " + pollData);
        queue.getSize();
        queue.printAllNodes();

        System.out.println();

        pollData = queue.poll();
        System.out.println("The output Data : " + pollData);
        queue.getSize();
        queue.printAllNodes();
    }
}
