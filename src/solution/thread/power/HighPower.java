package solution.thread.power;

public class HighPower {

    public static void main(String[] args) {

    }

    public static int power(int a, int b) {
        int result = 1;

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
