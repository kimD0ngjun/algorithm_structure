package algorithm.sequential;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] array = {5, 2, 3, 1, 7, 4, 3, 8, 9};

        MergeSort mergeSort = new MergeSort(array);
        System.out.println(Arrays.toString(mergeSort.mergeSort()));
    }
}
