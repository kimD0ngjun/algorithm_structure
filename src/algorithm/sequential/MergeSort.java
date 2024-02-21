package algorithm.sequential;

public class MergeSort {
    private int[] array;

    public MergeSort(int[] array) {
        this.array = array;
    }

    public void sort(int lowIndex, int highIndex) {
        // 탈출 조건
        if (lowIndex == highIndex) {
            System.out.println(lowIndex);
            return;
        }

        int middleIndex = (highIndex + lowIndex) / 2;

        // 재귀 호출
        sort(lowIndex, middleIndex);
        sort(middleIndex + 1, highIndex);

        // 재귀 회수 단계에서 정리될 부분
        System.out.println("### 재귀 스택 호출 확인 ###");
        System.out.println("낮은 인덱스:" + lowIndex);
        System.out.println("중간 인덱스:" + middleIndex);
        System.out.println("높은 인덱스:" + highIndex);
    }
}
