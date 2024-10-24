package solution.thread;

public class SingleThread {

    public static void main(String[] args) {
        System.out.println("메인 스레드 시작");

        for (int i = 1; i <= 5; i++) {
            System.out.println("스레드 1 - 작업 " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("스레드 1 완료");

        for (int i = 1; i <= 5; i++) {
            System.out.println("스레드 2 - 작업 " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("스레드 2 완료");

        System.out.println("모든 스레드 작업 완료");
    }

}
