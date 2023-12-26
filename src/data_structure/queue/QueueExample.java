package data_structure.queue;

public class QueueExample {
    public static void main(String[] args) {
        QueueCustom<Integer> queue = new QueueCustom<>(10);

        System.out.println(queue.getArray());
    }
}
