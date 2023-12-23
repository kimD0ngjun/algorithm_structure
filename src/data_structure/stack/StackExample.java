package data_structure.stack;

public class StackExample<T> {
    private static final int DEFAULT_CAPACITY = 10; // 스택의 디폴트 용량(자체)
    private T[] array; // 스택 배열
    private int size; // 스택의 크기

    public StackExample() {
        this.array = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }
}
