package solution.thread.collatz;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CollatzWithThread {

    public int solution(int num) {
        return CollatzSolution.solution(num);
    }

    static class CollatzSolution {
        private static final ExecutorService executorService = Executors.newCachedThreadPool();

        private static int collatz(long num, int count) throws ExecutionException, InterruptedException {
            if (count >= 500) {
                return -1;  // 500번을 넘어서도 1이 되지 않는 경우
            }

            if (num == 1) {
                return count;  // 수가 1이 되면 count 반환
            }

            Callable<Integer> task;

            // 짝수인 경우
            if (num % 2 == 0) {
                task = () -> collatz(num / 2, count + 1);
            }
            // 홀수인 경우
            else {
                task = () -> collatz(num * 3 + 1, count + 1);
            }

            Future<Integer> future = executorService.submit(task);
            return future.get();  // 자식 스레드의 결과를 기다림
        }

        static int solution(int num) {
            try {
                return collatz(num, 0);
            } catch (ExecutionException | InterruptedException e) {
                System.err.println(e.getMessage());
                return -1;
            }
        }
    }

}
