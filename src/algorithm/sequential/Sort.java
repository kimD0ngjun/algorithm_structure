package algorithm.sequential;

import java.util.Arrays;

public class Sort {
    // 구현 대상
    // 버블 정렬, 선택 정렬, 삽입 정렬, 병합 정렬, 퀵 정렬
    // 메소드로 구현하며, 모든 메소드는 정적 메소드로 구현한다.
    public static void main(String[] args) {
        int[] array1 = {5, 2, 3, 1, 7, 4, 3, 8, 9};

        int[] bubbleSortedArray = bubbleSort(array1);
        System.out.println(Arrays.toString(bubbleSortedArray));

        int[] array2 = {5, 2, 3, 1, 7, 4, 3, 8, 9};

        int[] selectionSortedArray = selectionSort(array2);
        System.out.println(Arrays.toString(selectionSortedArray));

        int[] array3 = {5, 2, 3, 1, 7, 4, 3, 8, 9};

        int[] insertionSortedArray = insertionSort(array3);
        System.out.println(Arrays.toString(insertionSortedArray));
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
        // 인덱스 0은 어차피 앞에 비교할게 없으니 인덱스 1부터
        for (int i = 1; i < array.length; i++) {
            int target = array[i];

            // 현재 인덱스부터 인덱스 0까지 역순으로 탐색한다
            // 인덱스 i가 인덱스 j보다는 크지만, 인덱스 j-1보다는 작거나 같으면 스왑 후, 인덱스 밀어내기 수행
            for (int j = i; j > 0; j--) {
                if ((target > array[j] & target <= array[j - 1]) || target < array[0]) {
//                    shiftValues(array, j - 1, i);
                }
            }
        }

        return array;
    }

}
