package algorithm.sequential;

public class MergeSort {
    private int[] array;

    public MergeSort(int[] array) {
        this.array = array;
    }

    public int[] mergeSort() {
        sort(0, this.array.length - 1);
        return this.array;
    }

    public void sort(int lowIndex, int highIndex) {
        // 탈출 조건
        if (lowIndex == highIndex) {
            return;
        }

        // 가운데 인덱스 추출
        int middleIndex = (highIndex + lowIndex) / 2;

        // 재귀 호출
        sort(lowIndex, middleIndex);
        sort(middleIndex + 1, highIndex);

        //TODO: 병합(재귀 회수) 단계에서 정리될 부분
        merge(lowIndex, middleIndex, highIndex);
    }

    // 별도의 배열화
    private void merge(int lowIndex, int middleIndex, int highIndex) {
        int[] temp = new int[highIndex - lowIndex + 1]; // 임시로 담을 배열
        int tempIndex = 0; // 임시 배열 인덱스
        int leftPointer = lowIndex; // 쪼갠 배열 중 한쪽 포인터
        int rightPointer = middleIndex + 1; // 쪼갠 배열 중 다른쪽 포인터

        // 각 포인터가 담당 배열의 마지막 인덱스까지 닿을 때까지 수행한다
        while (leftPointer <= middleIndex && rightPointer <= highIndex) {
            if (this.array[leftPointer] <= this.array[rightPointer]) {
                // 배열에 할당시킴과 동시에 변수 증가 업데이트(외워두기)
                temp[tempIndex++] = this.array[leftPointer++];
            } else {
                temp[tempIndex++] = this.array[rightPointer++];
            }
        }

        // 한쪽 포인터가 먼저 다다랐을 때 수행한다
        while (leftPointer <= middleIndex) {
            // 잔여 배열들 전부 붙여넣기
            temp[tempIndex++] = this.array[leftPointer++];
        }

        // 얘도 마찬가지
        while (rightPointer <= highIndex) {
            temp[tempIndex++] = this.array[rightPointer++];
        }

        // 임시 배열의 내용을 원래 배열에 붙여넣기
        for (int i = 0; i < temp.length; i++) {
            this.array[lowIndex + i] = temp[i];
        }
    }
}
