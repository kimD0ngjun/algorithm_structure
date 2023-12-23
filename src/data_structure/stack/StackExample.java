package data_structure.stack;

public class StackExample {
    public static void main(String[] args) {
        StackCustom<Integer> stack = new StackCustom<>();

        System.out.println(stack.getArray());
        System.out.println("사이즈 : " + stack.getSize());
        System.out.println("용량 : " + stack.getCapacity());
        System.out.println("비었는지 여부 : " + stack.empty());
        System.out.println("서치 : " + stack.search(100));

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(100);
        stack.push(4);

        System.out.println(stack.getArray());
        System.out.println("사이즈 : " + stack.getSize());
        System.out.println("맨 처음 서치 : " + stack.search(1));
        System.out.println("서치 : " + stack.search(100));

        stack.pop();

        System.out.println(stack.getArray());
        System.out.println("사이즈 : " + stack.getSize());
        System.out.println("서치 : " + stack.search(100));

        System.out.println(stack.peak());

        System.out.println("비었는지 여부 : " + stack.empty());
    }
}
