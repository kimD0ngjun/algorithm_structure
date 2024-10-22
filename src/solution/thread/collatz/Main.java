package solution.thread.collatz;

public class Main {
    public static void main(String[] args) {
        int parameter = 20_000;

        long start = System.nanoTime();

        Collatz collatz = new Collatz();
        int answer = collatz.solution(parameter);

        long end = System.nanoTime();

        System.out.println("단일 스레드 정답: " + answer);
        System.out.println("단일 스레드 처리 시간: " + (end - start));

        long threadStart = System.nanoTime();

        CollatzWithThread collatzWithThread = new CollatzWithThread();
        int answerWithMultiThread = collatzWithThread.solution(parameter);

        long threadEnd = System.nanoTime();

        System.out.println("멀티 스레드 정답: " + answerWithMultiThread);
        System.out.println("멀티 스레드 처리 시간: " + (threadEnd - threadStart));

    }
}
