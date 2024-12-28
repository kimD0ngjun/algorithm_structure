package solution.thread.power;

import java.util.Scanner;

public class HighPower {

    public static void main(String[] args) {
        long start = System.nanoTime();

        Scanner scanner = new Scanner(System.in);

        System.out.print("밑 입력: ");
        long a = scanner.nextLong();
        System.out.print("지수 입력: ");
        long b = scanner.nextLong();

        long result = power(a, b);

        System.out.println();
        System.out.println("결과: " + result);

        long end = System.nanoTime();
        System.out.println();

        System.out.println("소요 시간: " + (end - start));
        logMemoryUsage();
    }

    public static long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            if (b % 2 != 0) {
                result *= a;
            }

            b /= 2;
            a *= a;
        }

        return result;
    }

    private static void logMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        System.out.println("전체 메모리: " + totalMemory / 1024 + " KB");
        System.out.println("사용 중인 메모리: " + usedMemory / 1024 + " KB");
        System.out.println("사용 가능한 메모리: " + freeMemory / 1024 + " KB");
    }
}
