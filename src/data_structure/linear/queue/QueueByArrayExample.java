package data_structure.linear.queue;

public class QueueByArrayExample {
    public static void main(String[] args) {
        QueueByArrayCustom<Integer> queue = new QueueByArrayCustom<>(10);

        System.out.println(queue.getArray());
        System.out.println("사이즈 : " + queue.getSize());
        System.out.println(queue.peak());
        System.out.println(queue.poll());
//        System.out.println(queue.remove());
//        System.out.println(queue.element());

        System.out.println();

        System.out.println(queue.add(1));
        System.out.println(queue.getArray());
        System.out.println(queue.getSize());

        System.out.println();

        System.out.println(queue.offer(2));
        System.out.println(queue.getArray());
        System.out.println(queue.getSize());

        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(0);

        System.out.println();

        System.out.println(queue.getArray());
        System.out.println(queue.getSize());

        System.out.println();

        System.out.println(queue.offer(10));
//        System.out.println(queue.add(10));

        System.out.println();

        System.out.println(queue.remove());
        System.out.println(queue.getArray());
        System.out.println(queue.getSize());

        System.out.println();

        System.out.println(queue.poll());
        System.out.println(queue.getArray());
        System.out.println(queue.getSize());

        System.out.println();

        System.out.println(queue.peak());
        System.out.println(queue.getArray());
        System.out.println(queue.getSize());

        System.out.println();

        System.out.println(queue.element());
        System.out.println(queue.getArray());
        System.out.println(queue.getSize());
    }
}
