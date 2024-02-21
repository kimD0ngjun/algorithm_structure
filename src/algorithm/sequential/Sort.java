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

        int[] selectionSortedArray = selectionSort(array);
        System.out.println(Arrays.toString(selectionSortedArray));
    }

    //TODO: 버블 정렬
    public static int[] bubbleSort(int[] array) {
        int temp;
        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;

                    swapped = true;
                }
            }

            // 더 이상 스왑이 한 번이라도 일어나지 않을 때까지 반복시킴
            if (!swapped) {
                break;
            }
        } while (true);

        return array;
    }

    //TODO: 선택 정렬
    public static int[] selectionSort(int[] array) {
        int temp;

        for (int i = 0; i < array.length; i++) {
            // 탐색 지점 인덱스 설정
            int minIndex = i;

            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // swap
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }

        return array;
    }

    //TODO: 삽입 정렬
    public static int[] insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (array[i] > array[j]) {
                    shiftValues(array, i, j);
                }
            }
        }

        return array;
    }

    // k ~ n 인덱스에서 n 값을 앞으로 옮기고 그 이전의 값들 인덱스 한 칸 밀어버리기
    private static void shiftValues(int[] array, int n, int k) {
        int temp = array[k]; // k 인덱스의 값 저장

        // 배열의 뒷부분을 한 칸씩 뒤로 이동
        for (int i = k; i > n; i--) {
            array[i] = array[i - 1];
        }

        // n 인덱스에 저장할 값 할당
        array[n] = temp;
    }

}
