package algorithm.parallel;

public class Sort {
    // 구현 대상
    // 버블 정렬, 선택 정렬, 삽입 정렬, 병합 정렬, 퀵 정렬
    // 메소드로 구현하며, 모든 메소드는 정적 메소드로 구현한다.

    public static int[] bubble_sort(int[] array) {
        // 결과 담을 배열
        int[] sortedArray = new int[array.length];

        // 순회 카운트
        int count = 0;

        while (true) {
            for (int i = 0; i < array.length - 1; i++) {
                // 요소 추출
                int node = array[i];
                int adjacentNode = array[i + 1];

                // swap
                if (node > adjacentNode) {
                    sortedArray[i] = adjacentNode;
                    sortedArray[i + 1] = node;
                    count++;
                }

                if (node <= adjacentNode) {
                    sortedArray[i] = node;
                    sortedArray[i + 1] = adjacentNode;
                }
            }

            // not anymore needed sorting
            if (count == 0) {
                break;
            }
        }

        return sortedArray;
    }
}
