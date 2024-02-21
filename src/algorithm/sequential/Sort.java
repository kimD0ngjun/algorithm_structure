package algorithm.sequential;

import java.util.Arrays;

public class Sort {
    // 구현 대상
    // 버블 정렬, 선택 정렬, 삽입 정렬, 병합 정렬, 퀵 정렬
    // 메소드로 구현하며, 모든 메소드는 정적 메소드로 구현한다.
    public static void main(String[] args) {
        int[] array = {5, 2, 3, 1, 7, 4, 3, 8, 9};

        int[] bubbleSortedArray = bubbleSort(array);
        System.out.println(Arrays.toString(bubbleSortedArray));
    }

    public static int[] bubbleSort(int[] array) {
        int temp;
        boolean swapped;

        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;

            for (int j = 0; j < array.length - i - 1; j++) {
                // swap
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            // not anymore needed sorting
            if (!swapped)
                break;
        }

        return array;
    }

}
