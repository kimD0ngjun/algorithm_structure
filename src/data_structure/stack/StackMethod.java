package data_structure.stack;

import java.util.Stack;

public class StackMethod {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack);

        stack.push(0);
        System.out.println(stack);

        stack.push(1);
        System.out.println(stack);

        stack.push(2);
        System.out.println(stack);

        stack.push(3);
        System.out.println(stack);

        System.out.println("------");
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        System.out.println("------");
        System.out.println(stack);

        stack.add(0);
        System.out.println(stack);

        stack.add(1);
        System.out.println(stack);

        stack.add(2);
        System.out.println(stack);

        stack.push(100);
        System.out.println(stack);

        System.out.println(stack.peek());

        System.out.println(stack.search(0));
        System.out.println(stack.search(2));
        System.out.println(stack.search(100));
        System.out.println(stack.search(4));

        System.out.println(stack.empty());

        System.out.println(stack.capacity());
        System.out.println(stack.size());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        System.out.println(stack.capacity());
        System.out.println(stack.size());

        stack.clear();
        System.out.println(stack);
        System.out.println(stack.empty());
    }
}
