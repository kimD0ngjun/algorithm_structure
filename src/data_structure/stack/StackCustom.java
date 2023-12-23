package data_structure.stack;

import java.util.Arrays;

public class StackCustom<T> {
    private static final int DEFAULT_CAPACITY = 10; // 스택의 디폴트 용량(자체)
    private T[] array; // 스택 배열
    private int size; // 스택의 크기

    public StackCustom() {
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // TODO: push, pop, peak, search
    public void push(T element) {
        this.array[size] = element;
        this.size++;
    } // 근데 이 상태로는 배열 사이즈를 초과하면 예외 발생

    // TODO: 조회 메소드
    public int getSize() {
        return size;
    }

    public String getArray() {
        return Arrays.toString(getArrayData());
    } // 그래서 배열을 문자열로 변환하고 출력

    private T[] getArrayData() {
        return Arrays.copyOf(array, size);
    } // 이 상태는 배열의 참조값을 출력
}
