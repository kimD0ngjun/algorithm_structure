package data_structure.linear.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackByArrayCustom<T> {
    private static final int UNIT_CAPACITY = 10; // 스택의 디폴트 용량(자체)
    private T[] array; // 스택 배열
    private int capacity = UNIT_CAPACITY; // 스택의 용량
    private int size; // 스택의 크기

    public StackByArrayCustom() {
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    // push, pop, peak, empty, search
    public void push(T element) {
        if (size == capacity) {
            resize();
        }

        this.array[size] = element;
        this.size++;
    }

    private void resize() {
        this.capacity += UNIT_CAPACITY;
        this.array = Arrays.copyOf(array, capacity);
    }
    // 출력 결과에서 실제로 값이 있는 부분만 표시되고 나머지는 null로 초기화되어 출력
    // 제네릭 배열에서는 기본값으로 null이 사용되며, 이는 출력 시에는 표시되지 않음

    public void pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        this.array[size - 1] = null;
        this.size--;
    }

    public T peak() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        return this.array[size - 1];
    }

    public boolean empty() {
        return this.size == 0;
    }

    public int search(T element) {
        for (int i = 0; i < this.size; i++) {
            if (element.equals(this.array[i])) {
                return this.size - i;
            }
        }

        return -1;
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

    public int getCapacity() {
        return capacity;
    }
}
