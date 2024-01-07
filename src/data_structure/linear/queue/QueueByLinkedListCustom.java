package data_structure.linear.queue;

import data_structure.linear.linkedList.LinkedListCustom;

public class QueueByLinkedListCustom<T> extends LinkedListCustom<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;

    public QueueByLinkedListCustom() {
        super();
        this.capacity = DEFAULT_CAPACITY;
    }

    public QueueByLinkedListCustom(int capacity) {
        super();
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be assigned a negative number");
        }
        this.capacity = capacity;
    }

    @Override
    public void add(T data) {
        if (this.size == this.capacity) {
            this.capacity += DEFAULT_CAPACITY;
        }
        super.add(data);
    }

    @Override
    public void getSize() {
        super.getSize();
        System.out.println("현재 용량 : " + this.capacity);
    }

    public T poll() {
        if (size > 0) {
            T data = headNode.nodeData;
            delete(headNode.nodeData);
            if (this.capacity - this.size >= DEFAULT_CAPACITY) {
                this.capacity -= DEFAULT_CAPACITY;
            }
            return data;
        } else {
            throw new IllegalArgumentException("Queue is empty. Cannot poll.");
        }
    }
}
