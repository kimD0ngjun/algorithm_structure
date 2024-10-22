package solution.thread.collatz;

public class Collatz {

    public int solution(int num) {
        return CollatzSolution.solution(num);
    }

    static class CollatzSolution {
        private static int collatz(long num, int count) {
            if (count >= 500) {
                return -1;  // 500번을 넘어서도 1이 되지 않는 경우
            }

            if (num == 1) {
                return count;  // 수가 1이 되면 count 반환
            }

            // 짝수인 경우
            if (num % 2 == 0) {
                return collatz(num / 2, count + 1);
            }

            // 홀수인 경우
            else {
                return collatz(num * 3 + 1, count + 1);
            }
        }

        static int solution(int num) {
            return collatz(num, 0);
        }
    }
}

