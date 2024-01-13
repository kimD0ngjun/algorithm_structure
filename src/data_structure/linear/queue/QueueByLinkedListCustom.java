package data_structure.linear.queue;

import data_structure.linear.linkedList.LinkedListCustom;

public class QueueByLinkedListCustom<T> extends LinkedListCustom<T> {

    public QueueByLinkedListCustom() {
        super();
    }

    @Override
    public void add(T data) {
        super.add(data);
    }

    @Override
    public void getSize() {
        super.getSize();
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
