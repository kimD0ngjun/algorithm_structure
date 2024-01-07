package data_structure.linear.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class QueueByArrayCustom<T> {
    private T[] array; // 큐 배열
    private int size; // 큐의 크기
    private int capacity; // 큐의 용량

    public QueueByArrayCustom(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    } // 큐 인터페이스의 메소드별 취지에 맞춰 디폴트 capacity를 별도로 정의하지 않음

    // add, offer, element, peak, remove, poll,
    public boolean add(T element) {
        if (this.size == this.capacity) {
            throw new IllegalStateException();
        } else {
            this.array[size] = element;
            this.size++;

            return true;
        }
    }

    public boolean offer(T element) {
        if (this.size == this.capacity) {
            return false;
        } else {
            this.array[size] = element;
            this.size++;

            return true;
        }
    }

    public T element() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        } else {
            return this.array[0];
        }
    }

    public T peak() {
        if (this.size == 0) {
            return null;
        } else {
            return this.array[0];
        }
    }

    public T remove() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }

        T firstElement = this.array[0];
        for (int i = 0; i < this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.array[size - 1] = null;
        this.size--;

        return firstElement;
    }

    public T poll() {
        if (this.size == 0) {
            return null;
        }

        T firstElement = this.array[0];
        for (int i = 0; i < this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }

        this.array[size - 1] = null;
        this.size--;

        return firstElement;
    }

    // 조회 메소드
    public int getSize() {
        return size;
    }

    public String getArray() {
        return Arrays.toString(getArrayData());
    } // 그래서 배열을 문자열로 변환하고 출력

    private T[] getArrayData() {
        return Arrays.copyOf(array, size);
    } // 이 상태로는 배열의 참조값을 출력
}
