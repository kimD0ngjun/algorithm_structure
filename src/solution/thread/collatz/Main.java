package solution.thread.collatz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("계산할 파라미터를 입력하세요");
        int parameter = scanner.nextInt();

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
