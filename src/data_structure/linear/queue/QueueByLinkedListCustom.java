package data_structure.linear.queue;

import data_structure.linear.linkedList.LinkedListCustom;

public class QueueByLinkedListCustom<T> extends LinkedListCustom<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;

    public QueueByLinkedListCustom() {
        super();
        this.capacity = DEFAULT_CAPACITY;
    }

    // 별도의 생성자를 추가하여 capacity를 설정할 수 있도록 함
    public QueueByLinkedListCustom(int capacity) {
        super();
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be assigned a negative number");
        }
        this.capacity = capacity;
    }

    // 큐에 데이터를 추가할 때, 만약 용량이 사이즈보다 작으면 안 되니까. 동적으로 용량 늘이는 메소드 필요
    private void controlCapacity() {
        if(this.capacity == this.size) {
            this.capacity += DEFAULT_CAPACITY;
        }
        if(this.capacity - this.size > DEFAULT_CAPACITY) {
            this.capacity -= DEFAULT_CAPACITY;
        }
    }

    // 큐에서 데이터 추가(controlCapacity 메소드 적용)
    @Override
    public void add(T data) {
        super.add(data);
        controlCapacity();
    }

    // 큐에서 (맨 앞의) 데이터를 제거하고 반환
    public T poll() {
        controlCapacity();
        if (size > 0) {
            T data = headNode.nodeData;
            delete(headNode.nodeData);
            return data;
        } else {
            throw new IllegalArgumentException("Queue is empty. Cannot poll.");
        }
    }
}
