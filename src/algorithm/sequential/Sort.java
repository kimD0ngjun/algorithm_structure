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
    } // 얘는 정방향...

    //TODO: 삽입 정렬
    public static int[] insertionSort(int[] array) {
        // 어차피 인덱스 0은 비교 불필요, 그러므로 인덱스 1부터
        for (int i = 1; i < array.length; i++) {
            // 현재 시점의 값 할당 및 역순 시작점 인덱스 세팅
            int target = array[i];
            int j = i;

            // 한칸씩 지속적으로 밀어내기 위한 조건
            // 바로 앞의 값이 array[j-1] <= target 조건을 만족하는 순간
            // 업데이트된 j 인덱스에 해당하는 값에 target 산입
            while (j > 0 && target < array[j - 1]) {
                // 한칸씩 밀어내기
                array[j] = array[j - 1];
                j--;
            }

            // 밀어내지고 남은 기존의 조건 만족 위치에 산입
            array[j] = target;
        }

        return array;
    } // 얘는 역방향...

    //TODO: 병합 정렬
    public static int[] mergeSort(int[] array) {
        // 재귀로 쪼개기?
        // 배열의 길이를 넘지 않는 최대 2의 거듭제곱을 기준으로 나눈다?

    }
}
