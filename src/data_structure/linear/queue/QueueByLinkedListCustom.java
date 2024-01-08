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
        System.out.println("capacity : " + this.capacity);
    }

    @Override
    public void delete(T deletedData) {
    }

    // poll 기능에 맞춰서 오버로딩
    public void delete() {
        if (this.size > 0) {
            T data = this.headNode.nodeData;
            System.out.println("The Output Data : " + data);
            super.delete(this.headNode.nodeData);
            if (this.capacity - this.size >= DEFAULT_CAPACITY) {
                this.capacity -= DEFAULT_CAPACITY;
            }
        } else {
            throw new IllegalArgumentException("Queue is empty. Cannot poll.");
        }
    }

//    public T poll() {
//        if (this.size > 0) {
//            T data = this.headNode.nodeData;
//            delete(this.headNode.nodeData);
//            if (this.capacity - this.size >= DEFAULT_CAPACITY) {
//                this.capacity -= DEFAULT_CAPACITY;
//            }
//            return data;
//        } else {
//            throw new IllegalArgumentException("Queue is empty. Cannot poll.");
//        }
//    }
}
