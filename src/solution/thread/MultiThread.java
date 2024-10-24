package solution.thread;

public class MultiThread {

    public static void main(String[] args) {
        System.out.println("메인 스레드 시작");

        Thread thread1 = new Thread(new Task("스레드 1"));
        Thread thread2 = new Thread(new Task("스레드 2"));

        // 태스크 스레드 시작
        thread1.start();
        thread2.start();

        try {
            // 스레드 작업 끝날 때까지 메인 스레드 대기 진입
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("모든 스레드 작업 완료");
        // 테스크 스레드 두 개 종료시 메인 스레드 종료
    }

}

class Task implements Runnable {
    private final String threadName;

    public Task(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " - 작업 " + i);

            try {
                // 1초 작업 대기 (1000 밀리초)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }

        System.out.println(threadName + " 완료");
    }
}