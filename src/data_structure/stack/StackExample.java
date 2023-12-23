package data_structure.stack;

public class StackExample {
    public static void main(String[] args) {
        StackCustom<Integer> stack = new StackCustom<>();

        System.out.println(stack.getArray());
        System.out.println(stack.getSize());

        stack.push(1);

        System.out.println(stack.getArray());
        System.out.println(stack.getSize());
    }
}
