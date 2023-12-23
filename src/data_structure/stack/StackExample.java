package data_structure.stack;

public class StackExample {
    public static void main(String[] args) {
        StackCustom<Integer> stack = new StackCustom<>();

        System.out.println(stack.getArray());
        System.out.println(stack.getSize());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(100);
        stack.push(4);

        System.out.println(stack.getArray());
        System.out.println(stack.getSize());

        stack.pop();

        System.out.println(stack.getArray());
        System.out.println(stack.getSize());

        System.out.println(stack.peak());
    }
}
